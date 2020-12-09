package com.yangwang.application.pet.market.dao.market.pet;

import com.yangwang.application.pet.market.model.market.PetOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;


/**
 * <p>
 * 宠物订单
 * </p>
 *
 * @author LiuXiangLin
 * @date 9:32 2020/3/28
 **/
@Mapper
public interface PetOrderMapper {
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
    int save(@Param("petOrder") PetOrder petOrder);

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
    int updatePaymentState(@Param("orderNo") String orderNo, @Param("paymentState") int paymentState);

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
    int updateDriverState(@Param("orderNo") String orderNo, @Param("driverState") int driverState);

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
    int updateReceiveState(@Param("orderNo") String orderNo, @Param("receiveState") int receiveState);

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
    int updateEvaluateState(@Param("orderNo") String orderNo, @Param("evaluateState") int evaluateState);

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
    int updateRefundsState(@Param("orderNo") String orderNo, @Param("refundsState") int refundsState);

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
    int updateWayBill(@Param("orderNo") String orderNo, @Param("wayBill") String wayBill);

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
    int updateOutTradeNo(@Param("orderNo") String orderNo, @Param("outTradeNo") String outTradeNo);

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
    int updateRefundNo(@Param("orderNo") String orderNo, @Param("refundNo") String refundNo);

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
    PetOrder get(@Param("orderNo") String orderNo);

    /**
     * 修改订单运价
     * @param carriage
     * @param paymentAmount
     * @param orderNo
     * @return
     */
    int updateOrderCarriage(@Param("carriage")BigDecimal carriage,
                            @Param("paymentAmount")BigDecimal paymentAmount,
                            @Param("orderNo")String orderNo);

    /**
     * 通过运单号获取宠物订单
     * @param wayBill
     * @return
     */
    PetOrder getPetOrderByWaybill(@Param("wayBill")String wayBill);

    /**
     * <p>
     * 取消某一时间前的未支付的订单
     * </p>
     *
     * @param beforeDateTime 时间
     * @return int
     * @author LiuXiangLin
     * @date 13:49 2020/4/26
     **/
    int cancelUnpaidOrder(@Param("beforeDateTime")String beforeDateTime);

    /**
     * 修改订单价格
     *
     * @param petOrder
     * @return int
     * @author HuZhengYu
     * @date 10:46 2020/9/29
     */
    int updateOrderPrice(PetOrder petOrder);

    /**
     * 添加支付凭证
     *
     * @param orderNo
     * @param paymentVoucher
     * @return int
     * @author HuZhengYu
     * @date 18:33 2020/9/28
     */
    int uploadPaymentVoucher(@Param("orderNo") String orderNo,
                             @Param("paymentVoucher") String paymentVoucher);

}
