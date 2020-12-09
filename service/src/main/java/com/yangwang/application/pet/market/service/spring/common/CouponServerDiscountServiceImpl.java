package com.yangwang.application.pet.market.service.spring.common;

import com.yangwang.application.pet.market.model.common.coupon.Coupon;
import com.yangwang.application.pet.market.model.service.Service;
import com.yangwang.application.pet.market.service.facade.common.CouponServerService;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * <p>
 * 服务打折
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className CouponServerDiscountServiceImpl
 * @date 2020/3/28 14:24
 **/
@Component
public class CouponServerDiscountServiceImpl implements CouponServerService {
    @Override
    public BigDecimal calcDisCount(Service service, Coupon coupon) {
        return null;
    }
}
