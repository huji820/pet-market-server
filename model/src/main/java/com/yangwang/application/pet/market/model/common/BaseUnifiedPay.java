package com.yangwang.application.pet.market.model.common;

import com.yangwang.application.pet.market.model.business.Business;
import com.yangwang.application.pet.market.model.common.coupon.Coupon;

import java.math.BigDecimal;

/**
 * <p>
 * 同一支付请求参数
 * </p>
 *
 * @author HuJi
 * @date 10:03 2020/3/26
 **/
public abstract class BaseUnifiedPay {


    /**
     * 获取单据编号
     *
     * @return
     */
    public abstract String getOutTradeNo();

    /**
     * 获取卖家
     *
     * @return
     */
    public abstract Business getSeller();

    /**
     * 获取买家
     *
     * @return
     */
    public abstract Business getBuyer();

    /**
     * 获取分销商
     *
     * @return
     */
    public abstract Business getDistributor();

    /**
     * 获取回调地址
     *
     * @return
     */
    public abstract String getNotifyUrl();

    /**
     * 获取支付的内容
     *
     * @return
     */
    public abstract String getBody();

    /**
     * 获取支付的金额
     *
     * @return
     */
    public abstract BigDecimal getTotalFee();

    /**
     * 获取使用的余额
     *
     * @return
     */
    public abstract BigDecimal getUsedBalance();

    /**
     * 获取获得的积分
     *
     * @return
     */
    public abstract int getPoint();

    /**
     * 获取优惠券使用金额
     *
     * @return
     */
    public abstract Coupon getUsedCoupon();

    /**
     * 获取优惠券使用金额
     *
     * @return
     */
    public abstract BigDecimal getUsedCouponAmount();

    /**
     * 获取佣金
     *
     * @return
     */
    public abstract BigDecimal getBrokerage();

    /**
     * <p>
     * 获取用户ip地址
     * </p>
     *
     * @return java.lang.String
     * @author LiuXiangLin
     * @date 9:00 2020/3/31
     **/
    public abstract String getIpAddress();

    /**
     * <p>
     * 单号
     * </p>
     *
     * @return long
     * @author LiuXiangLin
     * @date 13:44 2020/4/1
     **/
    public abstract String getOrderNo();

    /**
     * <p>
     * 商家金额
     * </p>
     *
     * @return java.math.BigDecimal
     * @author LiuXiangLin
     * @date 14:36 2020/4/2
     **/
    public abstract BigDecimal getShopAmount();
}
