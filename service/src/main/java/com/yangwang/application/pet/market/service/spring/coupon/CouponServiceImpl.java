package com.yangwang.application.pet.market.service.spring.coupon;

import com.yangwang.application.pet.market.dao.market.coupon.CouponMapper;
import com.yangwang.application.pet.market.model.common.coupon.Coupon;
import com.yangwang.application.pet.market.service.facade.common.CouponListService;
import com.yangwang.application.pet.market.service.facade.coupon.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *
 * </p>
 *
 * @author LiuXiangLin
 * @date 13:56 2020/3/27
 **/
@Service
public class CouponServiceImpl implements CouponService {
    @Resource
    CouponMapper couponMapper;

    @Autowired
    CouponListService couponListService;

    @Override
    public Coupon getByVerifyCode(String verifyCode) {
        return couponMapper.getByVerifyCode(verifyCode);
    }

    @Override
    public Coupon get(long couponId) {
        return couponMapper.get(couponId);
    }

    @Override
    public int save(Coupon coupon) {
        return couponMapper.save(coupon);
    }

    @Override
    public int updateUsedState(long couponNo, boolean usedState) {
        return couponMapper.updateUsedState(couponNo, usedState);
    }

    @Override
    public int updateInvalidState(long couponNo, boolean invalidState) {
        return couponMapper.updateInvalidState(couponNo, invalidState);
    }
}
