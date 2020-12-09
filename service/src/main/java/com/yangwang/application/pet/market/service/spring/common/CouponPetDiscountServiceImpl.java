package com.yangwang.application.pet.market.service.spring.common;

import com.yangwang.application.pet.market.model.market.PetOrderVo;
import com.yangwang.application.pet.market.service.facade.common.CouponPetService;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * <p>
 * 宠物折扣券
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className CouponPetDiscountServiceImpl
 * @date 2020/3/28 14:18
 **/
@Component
public class CouponPetDiscountServiceImpl implements CouponPetService {
    @Override
    public BigDecimal calcDisCount(PetOrderVo petOrderVo) {
        if (checkBusiness(petOrderVo) && checkLeast(petOrderVo)) {
            return petOrderVo.getGoodsAmount().subtract(petOrderVo.getGoodsAmount()
                    .multiply(BigDecimal.valueOf(petOrderVo.getCoupon().getCouponType().getDiscount()))
                    .divide(BigDecimal.valueOf(100), BigDecimal.ROUND_HALF_UP, 2));
        }
        return null;
    }
}
