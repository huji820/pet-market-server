package com.yangwang.application.pet.market.service.spring.common;

import com.yangwang.application.pet.market.dao.market.item.ItemMapper;
import com.yangwang.application.pet.market.model.common.Item;

import com.yangwang.application.pet.market.service.facade.common.ItemIssuedBehalfService;
import com.yangwang.application.pet.market.service.facade.common.ItemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author LiuXiangLin
 * @date 8:58 2020/3/22
 **/
@Service
public class ItemServiceImpl implements ItemService {
    @Resource
    ItemMapper itemMapper;

    @Resource
    ItemIssuedBehalfService itemIssuedBehalfService;

    @Override
    public int save(Item item) {
        return itemMapper.save(item);
    }

    @Override
    public Item get(int itemNo) {
        return itemMapper.get(itemNo);
    }

    @Override
    public int update(Item item) {
        return itemMapper.update(item);
    }

    @Override
    public int updateState(int itemNo, int state) {
        Item item = itemMapper.get(itemNo);
        if(item.getSourceItemNo()==null){
            //是源头商品,所有代发它的商家店铺内的全部同步更新状态
            itemIssuedBehalfService.updateItemState(String.valueOf(itemNo), state);
        }else{
            //不是源头商品，需要先判断源头商品是否下架，下架则无法修改
            Item sourceItem = itemMapper.get(Integer.valueOf(item.getSourceItemNo()));
            if(sourceItem.getItemState().equals(0)){
                return 0;
            }
        }
        return itemMapper.updateState(itemNo, state);
    }

    @Override
    public int updateCollectionAdd(int itemNo, int collection) {
        return itemMapper.addCollectionQty(itemNo, collection);
    }

    @Override
    public int updateCollectionSub(int itemNo, int collection) {
        return itemMapper.addCollectionQty(itemNo, -collection);
    }

    @Override
    public int updateEvaluationAdd(int itemNo, int evaluation) {
        return itemMapper.addEvaluationQty(itemNo, evaluation);
    }

    @Override
    public int updateEvaluationSub(int itemNo, int evaluation) {
        return itemMapper.addEvaluationQty(itemNo, -evaluation);
    }

    @Override
    public int updateFavorableRate(int itemNo, BigDecimal favorableRate) {
        return itemMapper.updateFavorableRate(itemNo, favorableRate);
    }

    @Override
    public int updateSalesVolumeAdd(int itemNo, int salesVolume) {
        return itemMapper.updateSalesVolumeQty(itemNo, salesVolume);
    }

    @Override
    public int updateSalesVolumeSub(int itemNo, int salesVolume) {
        return itemMapper.updateSalesVolumeQty(itemNo, -salesVolume);
    }

    @Override
    public int updateQty(int itemNo, int qty) {
        return itemMapper.updateQty(itemNo, qty);
    }

    @Override
    public List<Integer> listItemNoByName(String keyWord) {
        return itemMapper.listItemNoByName(keyWord);
    }
}

