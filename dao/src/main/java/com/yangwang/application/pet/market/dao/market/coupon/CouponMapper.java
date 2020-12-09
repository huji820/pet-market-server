package com.yangwang.application.pet.market.dao.market.coupon;

import com.yangwang.application.pet.market.model.common.coupon.Coupon;
import org.apache.ibatis.annotations.Param;


/**
 * <p>
 * 优惠券
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className CouponMapper
 * @date 2020/3/27 14:11
 **/
public interface CouponMapper {
    /**
     * <p>
     * 通过主键获取券
     * </p>
     *
     * @param couponId 券主键
     * @return com.yangwang.application.pet.market.model.common.coupon.Coupon
     * @author LiuXiangLin
     * @date 2020/3/27
     **/
    Coupon get(@Param("couponId") long couponId);

    /**
     * <p>
     * 通过核销码获取优惠券
     * </p>
     *
     * @param verifyCode 核销码
     * @return com.yangwang.application.pet.market.model.common.coupon.Coupon
     * @author LiuXiangLin
     * @date 14:54 2020/3/27
     **/
    Coupon getByVerifyCode(@Param("verifyCode") String verifyCode);

    /**
     * <p>
     * 新增一张券
     * </p>
     *
     * @param coupon 优惠券对象
     * @return int
     * @author LiuXiangLin
     * @date 14:14 2020/3/27
     **/
    int save(@Param("coupon") Coupon coupon);

    /**
     * <p>
     * 更新优惠券使用状态
     * </p>
     *
     * @param couponId  优惠券编号
     * @param usedState 优惠券状态
     * @return int
     * @author LiuXiangLin
     * @date 14:14 2020/3/27
     **/
    int updateUsedState(@Param("couponId") long couponId, @Param("usedState") boolean usedState);

    /**
     * <p>
     * 更新优惠券失效状态
     * </p>
     *
     * @param couponId     优惠券券编号
     * @param invalidState 优惠券失效状态
     * @return int
     * @author LiuXiangLin
     * @date 14:15 2020/3/27
     **/
    int updateInvalidState(@Param("couponId") long couponId, @Param("invalidState") boolean invalidState);
}
