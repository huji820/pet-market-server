package com.yangwang.application.pet.market.service.facade.common;

import com.yangwang.application.pet.market.model.common.coupon.Coupon;
import com.yangwang.application.pet.market.model.service.Service;

import java.math.BigDecimal;

/**
 * <p>
 * 服务折扣
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className CouponServerService
 * @date 2020/3/28 14:23
 **/
public interface CouponServerService {
    /**
     * <p>
     * 计算服务折扣金额
     * </p>
     *
     * @param service 服务
     * @param coupon  优惠券
     * @return java.math.BigDecimal
     * @author LiuXiangLin
     * @date 14:23 2020/3/28
     **/
    BigDecimal calcDisCount(Service service, Coupon coupon);
}
