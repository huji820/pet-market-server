package com.yangwang.application.pet.market.service.spring.common;

import com.yangwang.application.pet.market.dao.market.item.ItemOrderListMapper;
import com.yangwang.application.pet.market.model.market.ItemOrder;
import com.yangwang.application.pet.market.model.market.ItemOrderInfo;
import com.yangwang.application.pet.market.model.params.QueryOrderListParam;
import com.yangwang.application.pet.market.service.facade.common.ItemOrderInfoService;
import com.yangwang.application.pet.market.service.facade.common.ItemOrderListServer;
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
 * @className ItemOrderListServerImpl
 * @date 2020/4/1 9:20
 **/
@Service
public class ItemOrderListServerImpl implements ItemOrderListServer {
    @Resource
    ItemOrderListMapper itemOrderListMapper;

    @Resource
    ItemOrderInfoService itemOrderInfoService;

    @Override
    public List<ItemOrder> listBuyerOrderByParam(QueryOrderListParam queryOrderListParam) {
        List<ItemOrder> itemOrders = itemOrderListMapper.listBuyerOrderByParam(queryOrderListParam);
        return addItemOrderDetails(itemOrders);
    }

    @Override
    public List<ItemOrder> listShopOrderByParam(QueryOrderListParam queryOrderListParam) {
        List<ItemOrder> itemOrders = itemOrderListMapper.listShopOrderByParam(queryOrderListParam);
        return addItemOrderDetails(itemOrders);
    }

    @Override
    public int delOrderByNo(String OrderNo) {
        return itemOrderListMapper.delOrderByNo(OrderNo);
    }

    /**
     * @Description: 商品订单添加订单详情
     * @Author: zxj
     * @Date: 2020/9/5 10:15
     * @param itemOrders: 商品订单集合
     * @return: java.util.List<com.yangwang.application.pet.market.model.market.ItemOrder>
     **/
    private List<ItemOrder> addItemOrderDetails(List<ItemOrder> itemOrders){
        if(itemOrders != null){
            for(ItemOrder itemOrder : itemOrders){
                List<ItemOrderInfo> itemOrderInfos = itemOrderInfoService.listByOrderNo(itemOrder.getOrderNo());
                itemOrder.setItemOrderInfoList(itemOrderInfos);
            }
        }
        return itemOrders;
    }

}
