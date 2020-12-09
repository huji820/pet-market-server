package com.yangwang.application.pet.market.service.facade.common;

import com.yangwang.application.pet.market.model.common.coupon.CouponType;
import com.yangwang.application.pet.market.model.market.PetOrderVo;

import java.math.BigDecimal;

/**
 * <p>
 * 宠物优惠券折扣
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className CouponPetService
 * @date 2020/3/28 11:37
 **/
public interface CouponPetService {
    /**
     * <p>
     * 计算优惠券金额
     * </p>
     *
     * @param petOrderVo 宠物订单Vo
     * @return java.math.BigDecimal
     * @author LiuXiangLin
     * @date 14:12 2020/3/28
     **/
    BigDecimal calcDisCount(PetOrderVo petOrderVo);

    /**
     * <p>
     * 是否满足最低使用要求
     * </p>
     *
     * @param petOrderVo 宠物订单对象
     * @return boolean
     * @author LiuXiangLin
     * @date 15:32 2020/3/30
     **/
    default boolean checkLeast(PetOrderVo petOrderVo) {
        if (petOrderVo.getCoupon().getCouponType().isAtLeast()) {
            return petOrderVo.getGoodsAmount().compareTo(BigDecimal.valueOf(petOrderVo.getCoupon().getCouponType().getLeastAmount())) >= 0;
        }
        return true;
    }

    /**
     * <p>
     * 是否满足商家要求
     * </p>
     *
     * @param petOrderVo 宠物vo对象
     * @return boolean
     * @author LiuXiangLin
     * @date 15:36 2020/3/30
     **/
    default boolean checkBusiness(PetOrderVo petOrderVo) {
        if (CouponType.RANGE_TYPE_PART.equals(petOrderVo.getCoupon().getCouponType().getBusinessType())) {
            return petOrderVo.getCoupon().getCouponType().getSpecifyBusinessIds().contains(petOrderVo.getBusiness().getBusinessNo());
        }
        return true;
    }
}
