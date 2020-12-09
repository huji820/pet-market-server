package com.yangwang.application.pet.market.service.spring.factory;

import com.yangwang.application.pet.market.model.common.coupon.CouponType;
import com.yangwang.application.pet.market.service.facade.common.BaseCouponFactory;
import com.yangwang.application.pet.market.service.facade.common.CouponPetService;
import com.yangwang.application.pet.market.service.facade.common.CouponItemService;
import com.yangwang.application.pet.market.service.facade.common.CouponServerService;
import com.yangwang.application.pet.market.service.spring.common.CouponPetBuyReductionServiceImpl;
import com.yangwang.application.pet.market.service.spring.common.CouponPetDiscountServiceImpl;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * <p>
 * 宠物优惠券工厂
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className CouponPetFactory
 * @date 2020/3/28 14:33
 **/
@Component
public class CouponPetFactory implements BaseCouponFactory {
    @Resource
    CouponPetBuyReductionServiceImpl couponPetBuyReductionServiceImpl;

    @Resource
    CouponPetDiscountServiceImpl couponPetDiscountServiceImpl;

    @Override
    public CouponPetService getCouponPetService(CouponType couponType) {
        if (CouponType.TYPE_DISCOUNT == couponType.getPreferentialType()) {
            return couponPetDiscountServiceImpl;
        }
        if (CouponType.TYPE_CASE == couponType.getPreferentialType()) {
            return couponPetBuyReductionServiceImpl;
        }
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
