package com.yangwang.application.pet.market.service.facade.common;

import com.yangwang.application.pet.market.model.common.coupon.CouponType;

/**
 * <p>
 * 优惠券工厂
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className BaseCouponFactory
 * @date 2020/3/28 11:36
 **/
public interface BaseCouponFactory {
    /***
     * <p>
     * 获取宠物优惠券服务
     * </p>
     *
     * @param couponType 优惠券类型
     * @return com.yangwang.application.pet.market.service.facade.common.CouponPetService
     * @author LiuXiangLin
     * @date 14:51 2020/3/28
     **/
    CouponPetService getCouponPetService(CouponType couponType);

    /**
     * <p>
     * 获取商品优惠券服务
     * </p>
     *
     * @param couponType 优惠券类型
     * @return com.yangwang.application.pet.market.service.facade.common.CouponItemService
     * @author LiuXiangLin
     * @date 14:52 2020/3/28
     **/
    CouponItemService getCouponItemService(CouponType couponType);

    /**
     * <p>
     * 获取服务优惠券服务
     * </p>
     *
     * @param couponType 优惠券类型
     * @return com.yangwang.application.pet.market.service.facade.common.CouponServerService
     * @author LiuXiangLin
     * @date 14:52 2020/3/28
     **/
    CouponServerService getCouponServerService(CouponType couponType);
}
