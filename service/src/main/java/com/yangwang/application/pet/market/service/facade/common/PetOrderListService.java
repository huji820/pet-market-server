package com.yangwang.application.pet.market.service.facade.common;

import com.yangwang.application.pet.market.model.market.PetOrder;
import com.yangwang.application.pet.market.model.params.QueryOrderListParam;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 * 宠物订单列表
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className PetOrderListService
 * @date 2020/3/31 15:21
 **/
public interface PetOrderListService {
    /**
     * <p>
     * 通过参数获取买家订单列表
     * </p>
     *
     * @param queryOrderListParam 查询参数
     * @return java.util.List<com.yangwang.application.pet.market.model.market.PetOrder>
     * @author LiuXiangLin
     * @date 15:39 2020/3/31
     **/
    List<PetOrder> listBuyerOrderByParam(QueryOrderListParam queryOrderListParam);

    /**
     * <p>
     * 通过参数获取卖家订单列表
     * </p>
     *
     * @param queryOrderListParam 查询参数
     * @return java.util.List<com.yangwang.application.pet.market.model.market.PetOrder>
     * @author LiuXiangLin
     * @date 9:36 2020/4/1
     **/
    List<PetOrder> listShopOrderByParam(QueryOrderListParam queryOrderListParam);

    /**
     * <p>
     * 通过宠物订单号删除订单
     * </p>
     *
     * @param  orderNo 订单编号
     * @param  buyercustomerno 下单客户编号
     * @param  waybill 运单号
     * @return int
     * @author GuoPengCheng
     * @date 18:22 2020/7/24
     **/
   int delPetOrderByNO(String orderNo,String buyercustomerno,String waybill);

    /**
     * <p>
     * 通过宠物订单号修改订单支付金额
     * </p>
     *
     * @param  orderNo 订单编号
     * @param  PaymentAmount 订单支付金额
     * @return int
     * @author GuoPengCheng
     * @date 10:49 2020/7/29
     **/
   int upPaymentAmount(String orderNo, BigDecimal PaymentAmount);

    /**
     * <p>
     * 通过宠物订单号级联删除运输订单
     * </p>
     *
     * @param  buyercustomerno 下单客户编号
     * @param  waybill 运单号
     * @return int
     * @author GuoPengCheng
     * @date 17:03 2020/7/29
     **/
   int delTransportOrder(String buyercustomerno,String waybill);
}
