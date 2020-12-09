package com.yangwang.application.pet.market.service.facade.customer;

import com.yangwang.application.pet.market.model.market.PetOrder;

import java.math.BigDecimal;

/**
 * <p>
 * 宠物订单
 * </p>
 *
 * @author LiuXiangLin
 * @date 9:42 2020/3/28
 **/
public interface PetOrderService {
    /**
     * <p>
     * 新增订单
     * </p>
     *
     * @param petOrder 订单对象
     * @return int
     * @author LiuXiangLin
     * @date 9:31 2020/3/28
     **/
    int save(PetOrder petOrder);

    /**
     * <p>
     * 修改订单支付状态
     * </p>
     *
     * @param orderNo      订单编号
     * @param paymentState 订单状态
     * @return int
     * @author LiuXiangLin
     * @date 9:33 2020/3/28
     **/
    int updatePaymentState(String orderNo, int paymentState);

    /**
     * <p>
     * 修改订单发货状态
     * </p>
     *
     * @param orderNo     订单编号
     * @param driverState 订单发货状态
     * @return int
     * @author LiuXiangLin
     * @date 9:34 2020/3/28
     **/
    int updateDriverState(String orderNo, int driverState);

    /**
     * <p>
     * 修改订单收货状态
     * </p>
     *
     * @param orderNo      订单编号
     * @param receiveState 订单收货状态
     * @return int
     * @author LiuXiangLin
     * @date 9:35 2020/3/28
     **/
    int updateReceiveState(String orderNo, int receiveState);

    /**
     * <p>
     * 修改订单评价状态
     * </p>
     *
     * @param orderNo       订单编号
     * @param evaluateState 订单评价状态
     * @return int
     * @author LiuXiangLin
     * @date 9:36 2020/3/28
     **/
    int updateEvaluateState(String orderNo, int evaluateState);

    /**
     * <p>
     * 修改订单退款状态
     * </p>
     *
     * @param orderNo      订单编号
     * @param refundsState 订单退款状态
     * @return int
     * @author LiuXiangLin
     * @date 9:37 2020/3/28
     **/
    int updateRefundsState(String orderNo, int refundsState);

    /**
     * <p>
     * 修改运单单号
     * </p>
     *
     * @param orderNo 订单编号
     * @param wayBill 支付状态
     * @return int
     * @author LiuXiangLin
     * @date 9:37 2020/3/28
     **/
    int updateWayBill(String orderNo, String wayBill);

    /**
     * <p>
     * 修改订单微信支付订单单号
     * </p>
     *
     * @param orderNo    订单编号
     * @param outTradeNo 微信支付单号
     * @return int
     * @author LiuXiangLin
     * @date 9:38 2020/3/28
     **/
    int updateOutTradeNo(String orderNo, String outTradeNo);

    /**
     * <p>
     * 修改订单退款状态
     * </p>
     *
     * @param orderNo  订单状态
     * @param refundNo 退款单号
     * @return int
     * @author LiuXiangLin
     * @date 9:39 2020/3/28
     **/
    int updateRefundNo(String orderNo, String refundNo);

    /**
     * <p>
     * 获取宠物订单
     * </p>
     *
     * @param orderNo 宠物订单编号
     * @return com.yangwang.application.pet.market.model.market.PetOrder
     * @author LiuXiangLin
     * @date 9:41 2020/3/28
     **/
    PetOrder get(String orderNo);

    /**
     * <p>
     * 取消超过时间未支付的订单
     * </p>
     *
     * @param beforeTime 最早的时间
     * @return int
     * @author LiuXiangLin
     * @date 13:48 2020/4/26
     **/
    int cancelUnpaidOrder(String beforeTime);

    /**
     * 通过运单号获取订单
     * @param wayBill
     * @return
     */
    PetOrder getPetOrderByWaybill(String wayBill);

    /**
     * 修改订单运价
     * @param carriage
     * @param paymentAmount
     * @param orderNo
     * @return
     */
    int updateOrderCarriage(BigDecimal carriage,BigDecimal paymentAmount,
                            String orderNo);

    /**
     * 修改订单价格
     *
     * @param petOrder
     * @return int
     * @author HuZhengYu
     * @date 10:45 2020/9/29
     */
    int updateOrderPrice(PetOrder petOrder);

    /**
     * 添加支付凭证
     *
     * @param orderNo
     * @param paymentVoucher
     * @return int
     * @author HuZhengYu
     * @date 18:32 2020/9/28
     */
    int uploadPaymentVoucher(String orderNo, String paymentVoucher);

}
