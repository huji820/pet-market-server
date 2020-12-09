package com.yangwang.application.pet.market.service.spring.common;

import com.yangwang.application.pet.market.model.market.PetOrderVo;
import com.yangwang.application.pet.market.service.facade.common.CouponPetService;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * <p>
 * 宠物满减折扣
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className BaseCouponPetBuyReductionServiceImpl
 * @date 2020/3/28 14:14
 **/
@Component
public class CouponPetBuyReductionServiceImpl implements CouponPetService {
    @Override
    public BigDecimal calcDisCount(PetOrderVo petOrderVo) {
        if (checkBusiness(petOrderVo) && checkLeast(petOrderVo)) {
            return petOrderVo.getCoupon().getCouponType().getValue().compareTo(petOrderVo.getGoodsAmount()) >= 0 ?
                    petOrderVo.getGoodsAmount()
                    : petOrderVo.getCoupon().getCouponType().getValue();
        }
        return null;
    }
}
