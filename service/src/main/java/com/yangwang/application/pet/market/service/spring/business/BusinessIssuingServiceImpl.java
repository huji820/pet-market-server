package com.yangwang.application.pet.market.service.spring.business;

import com.yangwang.application.pet.market.model.business.Business;
import com.yangwang.application.pet.market.model.common.Item;
import com.yangwang.application.pet.market.model.common.Pet;
import com.yangwang.application.pet.market.model.params.IssuingItemParam;
import com.yangwang.application.pet.market.model.params.IssuingPetParam;
import com.yangwang.application.pet.market.model.vo.ItemVo;
import com.yangwang.application.pet.market.model.vo.PetVo;
import com.yangwang.application.pet.market.service.facade.business.BusinessIssuingService;
import com.yangwang.application.pet.market.service.facade.common.*;
import com.yangwang.application.pet.market.service.service.BusinessService;
import com.yangwang.sysframework.utils.TypeConvertUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author yang hituzi
 * @description 从厂家进货商品
 * @date 2020年4月14日 16:13:16
 */
@Service
public class BusinessIssuingServiceImpl implements BusinessIssuingService {


    @Resource
    BusinessService businessService;

    @Resource
    ItemPutOnSaleService itemPutOnSaleService;


    @Override
    public int purchase(String businessNo, ItemVo itemVo) {
        ItemVo newItemVo = this.replaceItemVo(itemVo, businessNo);
        return itemPutOnSaleService.newPutOnSale(newItemVo);
    }

    /**
     * 复制进货商品信息
     *
     * @param itemVo
     * @param businessNo
     * @return com.yangwang.application.pet.market.model.vo.ItemVo
     * @author yang hituzi
     * @date 9:31 2020/4/16
     */
    private ItemVo replaceItemVo(ItemVo itemVo, String businessNo) {
        // 更改商品内的商家信息和价格
        Business business = businessService.getByBusinessNoWithOutState(businessNo);
        Item item = itemVo.getItem();

        //添加厂家
        item.setManufactor(item.getBusiness().getBusinessNo());
        item.setItemNo(null);
        item.setBusiness(business);
        //佣金
        item.setCommissionAmount(item.getCommissionAmount());
        //佣金比例
        item.setCommission(item.getCommissionAmount().divide(item.getRetailPrice(), 2, BigDecimal.ROUND_DOWN).multiply(BigDecimal.valueOf(100)));
        itemVo.setItem(item);

        return itemVo;
    }

}
