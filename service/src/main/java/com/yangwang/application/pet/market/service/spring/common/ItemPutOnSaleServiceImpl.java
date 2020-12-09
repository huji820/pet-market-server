package com.yangwang.application.pet.market.service.spring.common;

import com.yangwang.application.pet.market.common.enums.MessageTypeEnum;
import com.yangwang.application.pet.market.common.enums.OnSaleStateEnum;
import com.yangwang.application.pet.market.common.utils.CollectionUtils;
import com.yangwang.application.pet.market.model.common.AbstractItemAdd;
import com.yangwang.application.pet.market.model.common.Item;
import com.yangwang.application.pet.market.model.common.ItemPack;
import com.yangwang.application.pet.market.model.common.ItemType;
import com.yangwang.application.pet.market.model.vo.ItemVo;
import com.yangwang.application.pet.market.service.facade.common.*;
import com.yangwang.sysframework.utils.DateUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className ItemPutOnSaleServiceImpl
 * @date 2020/3/22 16:13
 **/
@Service
public class ItemPutOnSaleServiceImpl implements ItemPutOnSaleService {
    @Resource
    ItemService itemService;

    @Resource
    ItemCoverService itemCoverService;

    @Resource
    ItemGrouponService itemGrouponService;

    @Resource(name = "PushItemService")
    MessagePushService messagePushService;

    @Override
    public int putOnSale(int itemNo) {
        return itemService.updateState(itemNo, OnSaleStateEnum.FOR_SALE.getType());
    }

    @Override
    public int pullOffShelves(int itemNo) {
        return itemService.updateState(itemNo, OnSaleStateEnum.OFF_SALE.getType());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int newPutOnSale(ItemVo itemVo) {
        itemVo.getItem().setBasePrice(itemVo.getItem().getRetailPrice().subtract(itemVo.getItem().getCommissionAmount()));
        itemVo.getItem().setCollectionQty(0);
        itemVo.getItem().setItemState(OnSaleStateEnum.FOR_SALE.getType());
        itemVo.getItem().setCreateDate(DateUtil.format(new Date(), DateUtil.FORMAT_SIMPLE));
        itemVo.getItem().setCreateTime(DateUtil.format(new Date(), DateUtil.FORMAT_TIME));
        itemVo.getItem().setFavorableRate(BigDecimal.valueOf(1));
        itemVo.getItem().setEvaluationQty(0);
        itemVo.getItem().setSalesVolume(0);
        itemVo.getItem().setCoverImg(CollectionUtils.isNotEmpty(itemVo.getItemCoverList()) ? itemVo.getItemCoverList().get(0).getCoverAddress() : null);
        setCommission(itemVo.getItem());

        StringBuilder types = new StringBuilder();
        StringBuilder packs = new StringBuilder();

        for (ItemType itemType : itemVo.getItem().getItemTypes()) {
            types.append(itemType.getItemTypeNo()).append(",");
        }
        itemVo.getItem().setTypes(types.delete(types.length() - 1, types.length()).toString());
        if (itemVo.getItem().getItemPacks() != null) {
            for (ItemPack itemPack : itemVo.getItem().getItemPacks()) {
                packs.append(itemPack.getItemPackNo()).append(",");
            }
            itemVo.getItem().setPacks(packs.delete(packs.length() -1, packs.length()).toString());
        }
        itemService.save(itemVo.getItem());

        // 团购商品
        AbstractItemAdd.addPetToList(itemVo.getItemGrouponList(), itemVo.getItem());
        itemGrouponService.saveList(itemVo.getItemGrouponList());

        // 封面图片
        AbstractItemAdd.addPetToList(itemVo.getItemCoverList(), itemVo.getItem());
        itemCoverService.saveList(itemVo.getItemCoverList());

        //给关注该店铺的用户发送 新品上架 的站内信推送
        messagePushService.messagePush(Integer.toString(itemVo.getItem().getItemNo()), MessageTypeEnum.COMMODITY_NEW.getType());

        return 1;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int update(ItemVo itemVo) {
        itemVo.getItem().setBasePrice(itemVo.getItem().getRetailPrice().multiply((BigDecimal.valueOf(100).subtract(itemVo.getItem().getCommission()).divide(BigDecimal.valueOf(100), BigDecimal.ROUND_HALF_UP, 2))));
        setCommission(itemVo.getItem());

        StringBuilder types = new StringBuilder();
        StringBuilder packs = new StringBuilder();

        if (itemVo.getItem().getItemTypes() != null) {
            for (ItemType itemType : itemVo.getItem().getItemTypes()) {
                types.append(itemType.getItemTypeNo()).append(",");
            }
            itemVo.getItem().setTypes(types.delete(types.length() - 1, types.length()).toString());
        }

        if (itemVo.getItem().getItemPacks() != null) {
            for (ItemPack itemPack : itemVo.getItem().getItemPacks()) {
                packs.append(itemPack.getItemPackNo()).append(",");
            }
            itemVo.getItem().setPacks(packs.delete(packs.length() -1, packs.length()).toString());
        }

        itemService.update(itemVo.getItem());

        // 团购商品
        AbstractItemAdd.addPetToList(itemVo.getItemGrouponList(), itemVo.getItem());
        itemGrouponService.update(itemVo.getItemGrouponList(), itemVo.getItem());

        // 团购封面
        AbstractItemAdd.addPetToList(itemVo.getItemCoverList(), itemVo.getItem());
        itemCoverService.update(itemVo.getItemCoverList(), itemVo.getItem());

        return 1;
    }

    /**
     * 计算并设置佣金比例
     *
     * @param item
     * @return void
     * @author yang hituzi
     * @date 17:59 2020/4/10
     */
    private void setCommission(Item item) {
        BigDecimal commission = item.getCommissionAmount().divide(item.getRetailPrice(), 2, BigDecimal.ROUND_DOWN).multiply(BigDecimal.valueOf(100));
        item.setCommission(commission);
    }
}
