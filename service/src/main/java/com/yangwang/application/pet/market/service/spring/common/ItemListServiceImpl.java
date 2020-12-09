package com.yangwang.application.pet.market.service.spring.common;

import com.yangwang.application.pet.market.dao.business.SupplyRelationMapper;
import com.yangwang.application.pet.market.dao.market.item.ItemListMapper;
import com.yangwang.application.pet.market.model.params.QueryItemListParam;
import com.yangwang.application.pet.market.model.vo.ItemVo;
import com.yangwang.application.pet.market.service.facade.common.ItemListService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className ItemListServiceImpl
 * @date 2020/3/22 9:53
 **/
@Service
public class ItemListServiceImpl implements ItemListService {
    @Resource
    ItemListMapper itemListMapper;

    @Resource
    SupplyRelationMapper supplyRelationMapper;

    @Override
    public List<ItemVo> list(QueryItemListParam queryItemListParam) {
        return itemListMapper.list(queryItemListParam);
    }

    @Override
    public List<ItemVo> listManufactorItem(String businessNo) {
        //获取所有相关厂家编号
        List<String> listManufactor = supplyRelationMapper.listManufactor(businessNo);
        //获取所有相关厂家商品
        if(listManufactor == null ||listManufactor.size() == 0){
            listManufactor.add("-1");
        }
        List<ItemVo> itemVos = itemListMapper.listManufactorItem(listManufactor);
        return itemVos;
    }
}
