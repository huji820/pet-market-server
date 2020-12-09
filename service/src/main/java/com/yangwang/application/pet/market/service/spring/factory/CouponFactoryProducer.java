package com.yangwang.application.pet.market.service.spring.factory;

import com.yangwang.application.pet.market.model.market.BaseOrder;
import com.yangwang.application.pet.market.model.market.ItemOrder;
import com.yangwang.application.pet.market.model.market.PetOrder;
import com.yangwang.application.pet.market.service.facade.common.BaseCouponFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * <p>
 *
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className CouponProducer
 * @date 2020/3/28 14:41
 **/
@Component
public class CouponFactoryProducer<T extends BaseOrder> {
    @Resource
    CouponPetFactory couponPetFactory;

    @Resource
    CouponItemFactory couponItemFactory;

    @Resource
    CouponServerFactory couponServerFactory;

    public BaseCouponFactory getFactory(T t) {
        if (t instanceof ItemOrder) {
            return couponItemFactory;
        }

        if (t instanceof PetOrder) {
            return couponPetFactory;
        }

        return null;
    }
}
