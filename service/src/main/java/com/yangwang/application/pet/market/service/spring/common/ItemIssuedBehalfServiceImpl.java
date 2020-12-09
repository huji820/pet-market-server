package com.yangwang.application.pet.market.service.spring.common;

import com.yangwang.application.pet.market.dao.market.item.ItemIssuedBehalfMapper;
import com.yangwang.application.pet.market.model.business.Business;
import com.yangwang.application.pet.market.model.common.Item;
import com.yangwang.application.pet.market.model.common.Pet;
import com.yangwang.application.pet.market.service.facade.common.ItemIssuedBehalfService;
import com.yangwang.application.pet.market.service.facade.common.ItemService;
import com.yangwang.application.pet.market.service.service.BusinessService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/***
 * <p>
 * 一键代发商家商品
 * </p>
 *
 **/
@Service
public class ItemIssuedBehalfServiceImpl implements ItemIssuedBehalfService {

    @Resource
    ItemIssuedBehalfMapper itemIssuedBehalfMapper;

    @Resource
    ItemService itemService;

    @Resource
    BusinessService businessService;

    @Override
    public int save(String itemNo, String businessNo) {
        //获取要一键代发的商品
        Item item = itemService.get(Integer.valueOf(itemNo));
        //获取商品
        Business business = businessService.getByBusinessNoWithOutState(businessNo);
        if(item.getSourceItemNo()==null){ //是源头商品
            item.setSourceItemNo(String.valueOf(item.getItemNo()));
        }else{  //不是源头商品
            //获取源头商品
            Item sourceItem = itemService.get(Integer.valueOf(item.getSourceItemNo()));
            item.setSourceItemNo(String.valueOf(sourceItem.getItemNo()));
        }
        item.setBusiness(business);
        int i = itemIssuedBehalfMapper.save(item);
        return i;
    }

    @Override
    public List<Item> listByBusinessNo(String businessNo) {
        return itemIssuedBehalfMapper.listByBusinessNo(businessNo);
    }

    @Override
    public int removeItemByItemNo(String itemNo) {
        return itemIssuedBehalfMapper.removeByItemNo(itemNo);
    }

    @Override
    public int updateItemState(String sourceItemNo, int state) {
        return itemIssuedBehalfMapper.updateItemState(sourceItemNo, state);
    }

}
