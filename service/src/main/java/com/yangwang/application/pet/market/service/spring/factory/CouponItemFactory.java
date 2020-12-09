package com.yangwang.application.pet.market.service.spring.factory;

import com.yangwang.application.pet.market.model.common.coupon.CouponType;
import com.yangwang.application.pet.market.service.facade.common.BaseCouponFactory;
import com.yangwang.application.pet.market.service.facade.common.CouponPetService;
import com.yangwang.application.pet.market.service.facade.common.CouponItemService;
import com.yangwang.application.pet.market.service.facade.common.CouponServerService;
import com.yangwang.application.pet.market.service.spring.common.CouponItemBuyReductionServiceImpl;
import com.yangwang.application.pet.market.service.spring.common.CouponItemDiscountServiceImpl;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * <p>
 * 商品优惠券工厂
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className CouponItemFactory
 * @date 2020/3/28 14:35
 **/
@Component
public class CouponItemFactory implements BaseCouponFactory {
    @Resource
    CouponItemBuyReductionServiceImpl couponItemBuyReductionServiceImpl;

    @Resource
    CouponItemDiscountServiceImpl couponItemDiscountServiceImpl;

    @Override
    public CouponPetService getCouponPetService(CouponType couponType) {
        return null;
    }

    @Override
    public CouponItemService getCouponItemService(CouponType couponType) {
        if (CouponType.TYPE_CASE == couponType.getPreferentialType()) {
            return couponItemBuyReductionServiceImpl;
        }
        if (CouponType.TYPE_DISCOUNT == couponType.getPreferentialType()) {
            return couponItemDiscountServiceImpl;
        }
        return null;
    }

    @Override
    public CouponServerService getCouponServerService(CouponType couponType) {
        return null;
    }
}
