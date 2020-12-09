package com.yangwang.application.pet.market.dao.market.item;

import com.yangwang.application.pet.market.model.market.ItemOrder;
import com.yangwang.application.pet.market.model.params.QueryOrderListParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 商品订单列表
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className ItemOrderListMapper
 * @date 2020/4/1 9:10
 **/
public interface ItemOrderListMapper {
    /**
     * <p>
     * 通过参数查询买家订单列表
     * </p>
     *
     * @param queryOrderListParam 查询参数
     * @return java.util.List<com.yangwang.application.pet.market.model.market.ItemOrder>
     * @author LiuXiangLin
     * @date 9:12 2020/4/1
     **/
    List<ItemOrder> listBuyerOrderByParam(@Param("queryOrderListParam") QueryOrderListParam queryOrderListParam);

    /**
     * <p>
     * 通过参数查询卖家订单列表
     * </p>
     *
     * @param queryOrderListParam 查询参数
     * @return java.util.List<com.yangwang.application.pet.market.model.market.ItemOrder>
     * @author LiuXiangLin
     * @date 9:29 2020/4/1
     **/
    List<ItemOrder> listShopOrderByParam(@Param("queryOrderListParam") QueryOrderListParam queryOrderListParam);

    /**
     * <p>
     * 通过商品订单编号删除买家订单
     * </p>
     *
     * @param OrderNo 商品订单编号
     * @return java.util.List<com.yangwang.application.pet.market.model.market.ItemOrder>
     * @author GuoPengCheng
     * @date 17:50 2020/7/24
     **/
    int delOrderByNo(@Param("OrderNo") String OrderNo);
}
