package com.yangwang.application.pet.market.dao.market.item;

import com.yangwang.application.pet.market.model.market.ItemOrder;
import org.apache.ibatis.annotations.Param;


/**
 * <p>
 * 商品
 * </p>
 *
 * @author LiuXiangLin
 * @date 9:34 2020/3/30
 **/
public interface ItemOrderMapper {
    /**
     * <p>
     * 新增订单
     * </p>
     *
     * @param itemOrder 商品订单
     * @return int
     * @author LiuXiangLin
     * @date 9:35 2020/3/30
     **/
    int save(ItemOrder itemOrder);

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
     * @param expressCompany 快递公司
     * @return int
     * @author LiuXiangLin
     * @date 9:34 2020/3/28
     **/
    int updateDriverState(@Param("orderNo") String orderNo, @Param("driverState") int driverState, @Param("expressCompany") String expressCompany);

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
    ItemOrder get(@Param("orderNo") String orderNo);


    /**
     * <p>
     * 取消未支付的订单
     * </p>
     *
     * @param beforeDateTime 时间
     * @return int
     * @author LiuXiangLin
     * @date 11:46 2020/4/26
     **/
    int cancelUnpaidOrder(String beforeDateTime);

    /**
     * @Description:  修改订单的价格
     * @Author: zxj
     * @Date: 2020/9/8 10:10
     * @param itemOrder 修改后的订单
     * @return: int
     **/
    int updateOrderPrice(ItemOrder itemOrder);

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
