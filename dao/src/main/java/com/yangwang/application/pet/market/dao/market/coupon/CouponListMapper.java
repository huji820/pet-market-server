package com.yangwang.application.pet.market.dao.market.coupon;

import com.yangwang.application.pet.market.model.common.coupon.Coupon;
import com.yangwang.application.pet.market.model.params.QueryCouponListParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 优惠券列表
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className CouponListMapper
 * @date 2020/3/27 17:02
 **/
public interface CouponListMapper {
    /**
     * <p>
     * 通过多个参数查询优惠券列表
     * </p>
     *
     * @param queryCouponListParam 查询参数
     * @return java.util.List<com.yangwang.application.pet.market.model.common.coupon.Coupon>
     * @author LiuXiangLin
     * @date 17:03 2020/3/27
     **/
    List<Coupon> listByParam(@Param("queryCouponListParam") QueryCouponListParam queryCouponListParam);
}
