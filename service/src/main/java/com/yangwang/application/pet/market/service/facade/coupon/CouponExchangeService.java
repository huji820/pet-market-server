package com.yangwang.application.pet.market.service.facade.coupon;

import com.yangwang.application.pet.market.model.params.CouponExchangeParam;

public interface CouponExchangeService {

    /**
     *
     * 兑换优惠券
     * @param couponExchangeParam
     * @return int
     * @author yang hituzi
     * @date 14:15 2020/4/8
     */
    int exchangeCoupon(CouponExchangeParam couponExchangeParam);

    /**
     *
     * 优惠券核销
     * @param verifyCode
     * @return int
     * @author yang hituzi
     * @date 14:58 2020/4/8
     */
    int verifyCoupon(String verifyCode);

    /**
     * 领取优惠卷
     * @param couponExchangeParam
     * @return
     */
    int receiveCoupon(CouponExchangeParam couponExchangeParam);
}
