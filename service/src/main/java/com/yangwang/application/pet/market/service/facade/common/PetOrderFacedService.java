package com.yangwang.application.pet.market.service.facade.common;

import com.yangwang.application.pet.market.model.market.PetOrderVo;
import com.yangwang.application.pet.market.model.vo.OrderPriceVo;

import java.math.BigDecimal;
import java.util.Map;

/**
 * <p>
 * 宠物订单门面
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className PetOrderFacedService
 * @date 2020/3/28 9:57
 **/
public interface PetOrderFacedService {
    /**
     * <p>
     * 新增订单
     * </p>
     *
     * @param petOrderVo 订单对象
     * @return long
     * @author LiuXiangLin
     * @date 9:57 2020/3/28
     **/
    long save(PetOrderVo petOrderVo);

    /**
     * <p>
     * 取消订单
     * </p>
     *
     * @param orderNo 订单编号
     * @return int
     * @author LiuXiangLin
     * @date 9:58 2020/3/28
     **/
    int cancel(long orderNo);

    /**
     * <p>
     * 获取订单价格
     * </p>
     *
     * @param petOrderVo 宠物订单vo
     * @return java.math.BigDecimal
     * @author LiuXiangLin
     * @date 14:13 2020/3/30
     **/
    OrderPriceVo getPrice(PetOrderVo petOrderVo);

    /**
     * <p>
     * 获取宠物价格
     * </p>
     *
     * @param petNo 宠物编号
     * @param qty   数量
     * @return java.math.BigDecimal
     * @author LiuXiangLin
     * @date 15:10 2020/3/30
     **/
    BigDecimal getPetPrice(String petNo, int qty);

    /**
     * <p>
     * 获取支付参数
     * </p>
     *
     * @param orderNo   订单编号
     * @param ipAddress 用户ip地址
     * @return java.util.Map<java.lang.String, java.lang.String>
     * @throws Exception 获取支付失败的异常
     * @author LiuXiangLin
     * @date 10:42 2020/3/31
     **/
    Map<String, String> getPayParam(String orderNo, String ipAddress) throws Exception;

    /**
     * <p>
     * 支付回调处理
     * </p>
     *
     * @param orderNo 单号
     * @return int
     * @author LiuXiangLin
     * @date 14:00 2020/4/1
     **/
    int payCallBack(String orderNo) throws Exception;

    /**
     * <p>
     * 取消未支付的宠物订单
     * </p>
     *
     * @param
     * @return int
     * @author LiuXiangLin
     * @date 13:41 2020/4/26
     **/
    int cancelUnpaidOrder();

    /**
     * <p>
     * 签收订单
     * </p>
     *
     * @param orderNo 订单编号
     * @return int
     * @author LiuXiangLin
     * @date 11:01 2020/4/30
     **/
    int signFor(String orderNo);

    /**
     * <p>
     * 订单发货
     * </p>
     *
     * @param orderNo 订单编号
     * @param wayBill 运单号
     * @return int
     * @author LiuXiangLin
     * @date 14:53 2020/4/30
     **/
    int deliverOrder(String orderNo, String wayBill);

    /**
     * 获取最新订单价格
     * @param paymentAmount
     * @return int
     * @author GuoPengCheng
     * @date 10:40 2020/07/28
     */
    BigDecimal getPaymentAmounts(BigDecimal paymentAmount,String consignOrderNo);

    /**
     * 添加支付凭证
     *
     * @param orderNo
     * @param paymentVoucher
     * @return int
     * @author HuZhengYu
     * @date 18:09 2020/9/28
     */
    int uploadPaymentVoucher(String orderNo, String paymentVoucher);

    /**
     * 修改订单价格
     *
     * @param orderNo
     * @param price
     * @return java.lang.Integer
     * @author HuZhengYu
     * @date 14:57 2020/9/30
     */
    int updateOrderPrice(String orderNo, BigDecimal price);
}
