package com.yangwang.application.pet.market.service.facade.coupon;

import com.yangwang.application.pet.market.model.common.coupon.Coupon;

/**
 * <p>
 * 优惠券门面
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className CouponFacedService
 * @date 2020/3/27 15:22
 **/
public interface CouponFacedService {
    /**
     * <p>
     * 核销券
     * </p>
     *
     * @param couponId 优惠券主键
     * @return int
     * @author LiuXiangLin
     * @date 15:28 2020/3/27
     **/
    int writeOff(long couponId);

    /**
     * <p>
     * 获取优惠券
     * </p>
     *
     * @param couponNo 优惠券主键
     * @return com.yangwang.application.pet.market.model.common.coupon.Coupon
     * @author LiuXiangLin
     * @date 15:04 2020/4/1
     **/
    Coupon getUseful(long couponNo);

}
