package com.yangwang.application.pet.market.service.spring.chain.order.pet;

import com.yangwang.application.pet.market.model.market.PetOrderVo;
import com.yangwang.application.pet.market.service.facade.common.PetOrderCheckChainService;
import com.yangwang.application.pet.market.service.facade.coupon.CouponService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className CouponChainServiceImpl
 * @date 2020/3/28 11:01
 **/
@Service
public class CouponChainServiceImpl implements PetOrderCheckChainService {
    private PetOrderCheckChainService next;

    @Resource
    CouponService couponService;

    @Override
    public void check(PetOrderVo petOrderVo) {
    }

    @Override
    public void setNext(PetOrderCheckChainService petOrderCheckChainService) {
        this.next = petOrderCheckChainService;
    }
}
