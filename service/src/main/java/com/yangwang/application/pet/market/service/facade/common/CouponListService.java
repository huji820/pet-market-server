package com.yangwang.application.pet.market.service.facade.common;

import com.yangwang.application.pet.market.model.common.coupon.Coupon;
import com.yangwang.application.pet.market.model.params.QueryCouponListParam;
import com.yangwang.application.pet.market.model.params.QueryUsableCouponListParam;

import java.util.List;

/**
 * <p>
 * 优惠券列表
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className CouponListService
 * @date 2020/3/27 17:16
 **/
public interface CouponListService {
    /**
     * <p>
     * 通过查询参数获取优惠券列表
     * </p>
     *
     * @param queryCouponListParam 查询参数
     * @return java.util.List<com.yangwang.application.pet.market.model.common.coupon.Coupon>
     * @author LiuXiangLin
     * @date 17:17 2020/3/27
     **/
    List<Coupon> listByParam(QueryCouponListParam queryCouponListParam);

    /**
     * 获取当前单据可使用的优惠券列表
     * @param queryUsableCouponListParam 查询参数
     * @author huji
     * @date 2020/03/28
     * @return
     */
    List<Coupon> listUsableCoupon(QueryUsableCouponListParam queryUsableCouponListParam);
}
