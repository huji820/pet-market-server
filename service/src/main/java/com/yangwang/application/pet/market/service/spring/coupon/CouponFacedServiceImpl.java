package com.yangwang.application.pet.market.service.spring.coupon;

import com.yangwang.application.pet.market.common.utils.CollectionUtils;
import com.yangwang.application.pet.market.model.common.coupon.Coupon;
import com.yangwang.application.pet.market.model.params.QueryCouponListParam;
import com.yangwang.application.pet.market.service.facade.common.CouponListService;
import com.yangwang.application.pet.market.service.facade.coupon.CouponFacedService;
import com.yangwang.application.pet.market.service.facade.coupon.CouponService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className CouponFacedServiceImpl
 * @date 2020/3/27 15:28
 **/
@Service
public class CouponFacedServiceImpl implements CouponFacedService {
    @Resource
    CouponListService couponListService;

    @Override
    public int writeOff(long couponId) {
        return 0;
    }

    @Override
    public Coupon getUseful(long couponNo) {
        List<Coupon> couponList = couponListService.listByParam(new QueryCouponListParam(null, couponNo, null, 0, 0));
        return CollectionUtils.isNotEmpty(couponList) ? couponList.get(0) : null;
    }

}
