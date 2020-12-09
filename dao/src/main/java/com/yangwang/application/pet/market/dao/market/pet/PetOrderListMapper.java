package com.yangwang.application.pet.market.dao.market.pet;

import com.yangwang.application.pet.market.model.market.PetOrder;
import com.yangwang.application.pet.market.model.params.QueryOrderListParam;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 * 宠物订单列表
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className PetOrderListMapper
 * @date 2020/3/31 15:41
 **/
public interface PetOrderListMapper {
    /**
     * <p>
     * 通过多个参数查询买家宠物而订单列表
     * </p>
     *
     * @param queryOrderListParam 查询参数
     * @return java.util.List<com.yangwang.application.pet.market.model.market.PetOrder>
     * @author LiuXiangLin
     * @date 15:41 2020/3/31
     **/
    List<PetOrder> listBuyerOrderParam(@Param("queryOrderListParam") QueryOrderListParam queryOrderListParam);

    /**
     * <p>
     * 通过多个参数查询卖家宠物而订单列表
     * </p>
     *
     * @param queryOrderListParam 查询参数
     * @return java.util.List<com.yangwang.application.pet.market.model.market.PetOrder>
     * @author LiuXiangLin
     * @date 9:37 2020/4/1
     **/
    List<PetOrder> listShopOrderParam(@Param("queryOrderListParam") QueryOrderListParam queryOrderListParam);

    /**
     * <p>
     * 通过宠物订单号删除订单
     * </p>
     *
     * @param  orderNo 订单编号
     * @return int
     * @author GuoPengCheng
     * @date 18:24 2020/7/24
     **/
    int delPetOrderByNO(@Param("orderNo") String orderNo);

    /**
     * <p>
     * 通过宠物订单号修改宠物支付金额
     * </p>
     *
     * @param  orderNo 订单编号
     * @param  PaymentAmount 支付金额
     * @return int
     * @author GuoPengCheng
     * @date 10:40 2020/7/29
     **/
    int upPaymentAmount(@Param("orderNo") String orderNo, @Param("PaymentAmount")BigDecimal PaymentAmount);
}
