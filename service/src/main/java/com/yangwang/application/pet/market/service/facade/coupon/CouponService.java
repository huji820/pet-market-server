package com.yangwang.application.pet.market.service.facade.coupon;

import com.yangwang.application.pet.market.model.common.coupon.Coupon;

/**
 * <p>
 * 优惠券
 * </p>
 *
 * @author LiuXiangLin
 * @date 14:22 2020/3/27
 **/
public interface CouponService {
    /**
     * <p>
     * 通过核销码获取优惠券
     * </p>
     *
     * @param verifyCode 核销码
     * @return com.yangwang.application.pet.market.model.common.coupon.Coupon
     * @author LiuXiangLin
     * @date 14:27 2020/3/27
     **/
    Coupon getByVerifyCode(String verifyCode);

    /**
     * <p>
     * 通过主键获取优惠券
     * </p>
     *
     * @param couponId 优惠券主键
     * @return com.yangwang.application.pet.market.model.common.coupon.Coupon
     * @author LiuXiangLin
     * @date 14:28 2020/3/27
     **/
    Coupon get(long couponId);

    /**
     * <p>
     * 新增一张券
     * </p>
     *
     * @param coupon 优惠券对象
     * @return com.yangwang.application.pet.market.model.common.coupon.Coupon
     * @author LiuXiangLin
     * @date 14:28 2020/3/27
     **/
    int save(Coupon coupon);

    /**
     * <p>
     * 更新使用状态
     * </p>
     *
     * @param couponNo  优惠券编号
     * @param usedState 使用状态
     * @return int
     * @author LiuXiangLin
     * @date 14:50 2020/3/27
     **/
    int updateUsedState(long couponNo, boolean usedState);

    /**
     * <p>
     * 更新失效状态
     * </p>
     *
     * @param couponNo     优惠券编号
     * @param invalidState 失效状态
     * @return int
     * @author LiuXiangLin
     * @date 14:51 2020/3/27
     **/
    int updateInvalidState(long couponNo, boolean invalidState);
}
