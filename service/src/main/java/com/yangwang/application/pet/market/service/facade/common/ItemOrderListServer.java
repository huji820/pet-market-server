package com.yangwang.application.pet.market.service.facade.common;

import com.yangwang.application.pet.market.model.market.ItemOrder;
import com.yangwang.application.pet.market.model.params.QueryOrderListParam;

import java.util.List;

/**
 * <p>
 * 商品订单列表
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className ItemOrderListServer
 * @date 2020/4/1 9:19
 **/
public interface ItemOrderListServer {
    /**
     * <p>
     * 通过参数查询买家订单列表
     * </p>
     *
     * @param queryOrderListParam 查询参数
     * @return java.util.List<com.yangwang.application.pet.market.model.market.ItemOrder>
     * @author LiuXiangLin
     * @date 9:19 2020/4/1
     **/
    List<ItemOrder> listBuyerOrderByParam(QueryOrderListParam queryOrderListParam);

    /**
     * <p>
     * 通过参数查询卖家订单列表
     * </p>
     *
     * @param queryOrderListParam 查询参数
     * @return java.util.List<com.yangwang.application.pet.market.model.market.ItemOrder>
     * @author LiuXiangLin
     * @date 9:27 2020/4/1
     **/
    List<ItemOrder> listShopOrderByParam(QueryOrderListParam queryOrderListParam);

    /**
     * <p>
     * 通过商城订单编号删除买家未支付订单
     * </p>
     *
     * @param  OrderNo 订单号
     * @return java.util.List<com.yangwang.application.pet.market.model.market.ItemOrder>
     * @author GuoPengCheng
     * @date 17:47 2020/7/24
     **/
    int delOrderByNo(String OrderNo);
}
