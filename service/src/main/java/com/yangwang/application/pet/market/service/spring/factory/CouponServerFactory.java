package com.yangwang.application.pet.market.service.spring.factory;

import com.yangwang.application.pet.market.model.common.coupon.CouponType;
import com.yangwang.application.pet.market.service.facade.common.BaseCouponFactory;
import com.yangwang.application.pet.market.service.facade.common.CouponItemService;
import com.yangwang.application.pet.market.service.facade.common.CouponPetService;
import com.yangwang.application.pet.market.service.facade.common.CouponServerService;
import com.yangwang.application.pet.market.service.spring.common.CouponServerBuyReductionServiceImpl;
import com.yangwang.application.pet.market.service.spring.common.CouponServerDiscountServiceImpl;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * <p>
 * 服务优惠券工厂
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className CouponServerFactory
 * @date 2020/3/28 14:38
 **/
@Component
public class CouponServerFactory implements BaseCouponFactory {
    @Resource
    CouponServerBuyReductionServiceImpl couponServerBuyReductionServiceImpl;

    @Resource
    CouponServerDiscountServiceImpl couponServerDiscountServiceImpl;

    @Override
    public CouponPetService getCouponPetService(CouponType couponType) {
        return null;
    }

    @Override
    public CouponItemService getCouponItemService(CouponType couponType) {
        return null;
    }

    @Override
    public CouponServerService getCouponServerService(CouponType couponType) {
        return null;
    }
}
