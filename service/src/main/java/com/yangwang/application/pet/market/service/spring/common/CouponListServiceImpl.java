package com.yangwang.application.pet.market.service.spring.common;

import com.yangwang.application.pet.market.dao.market.coupon.CouponListMapper;
import com.yangwang.application.pet.market.model.common.coupon.Coupon;
import com.yangwang.application.pet.market.model.params.QueryCouponListParam;
import com.yangwang.application.pet.market.model.params.QueryUsableCouponListParam;
import com.yangwang.application.pet.market.service.facade.common.CouponListService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className CouponListServiceImpl
 * @date 2020/3/27 17:17
 **/
@Service
public class CouponListServiceImpl implements CouponListService {
    @Resource
    CouponListMapper couponListMapper;

    @Override
    public List<Coupon> listByParam(QueryCouponListParam queryCouponListParam) {
        return couponListMapper.listByParam(queryCouponListParam);
    }

    @Override
    public List<Coupon> listUsableCoupon(QueryUsableCouponListParam queryUsableCouponListParam) {

        List<Coupon> result = new ArrayList<>();

        QueryCouponListParam queryCouponListParam = new QueryCouponListParam();
        queryCouponListParam.setBusinessNo(queryUsableCouponListParam.getBusinessNo());
        queryCouponListParam.setInvalid(0);
        queryCouponListParam.setUsed(0);

        List<Coupon> coupons = this.listByParam(queryCouponListParam);

        /*if (queryUsableCouponListParam.getType() == PlatformTradeEnum.PET.getCode()) {
            for (Coupon coupon : coupons) {
                if (isLegalPetCoupon(coupon, queryUsableCouponListParam)) {
                    result.add(coupon);
                }
            }
        } else if (queryUsableCouponListParam.getType() == PlatformTradeEnum.ITEM.getCode()) {
            for (Coupon coupon : coupons) {
                if (isLegalItemCoupon(coupon, queryUsableCouponListParam)) {
                    result.add(coupon);
                }
            }
        } else if (queryUsableCouponListParam.getType() == PlatformTradeEnum.SERVICE.getCode()) {
            for (Coupon coupon : coupons) {
                if (isLegalServiceCoupon(coupon, queryUsableCouponListParam)) {
                    result.add(coupon);
                }
            }
        }*/

        return coupons;
    }

    /**
     * 是否合法的宠物优惠券
     * @param coupon
     * @param param
     * @return
     */
    private boolean isLegalPetCoupon(Coupon coupon, QueryUsableCouponListParam param) {
        if ((coupon.getCouponType().getBusinessType().equals("ALL") || coupon.getCouponType().getSpecifyBusinessIds().indexOf(param.getShopNo()) > -1) && (coupon.getCouponType().getRangeType().equals("ALL") || coupon.getCouponType().getRangeType().equals("ALL-PET"))) {
            return true;
        }
        return false;
    }

    /**
     * 是否合法的宠物优惠券
     * @param coupon
     * @param param
     * @return
     */
    private boolean isLegalItemCoupon(Coupon coupon, QueryUsableCouponListParam param) {
        if ((coupon.getCouponType().getBusinessType().equals("ALL") || coupon.getCouponType().getSpecifyBusinessIds().indexOf(param.getShopNo()) > -1) && (coupon.getCouponType().getRangeType().equals("ALL") || coupon.getCouponType().getRangeType().equals("ALL-ITEM") || coupon.getCouponType().getSpecifyItemIds().indexOf(param.getKey()) > -1)) {
            return true;
        }
        return false;
    }

    /**
     * 是否合法的宠物优惠券
     * @param coupon
     * @param param
     * @return
     */
    private boolean isLegalServiceCoupon(Coupon coupon, QueryUsableCouponListParam param) {
        if ((coupon.getCouponType().getBusinessType().equals("ALL") || coupon.getCouponType().getSpecifyBusinessIds().indexOf(param.getShopNo()) > -1) && (coupon.getCouponType().getRangeType().equals("ALL") || coupon.getCouponType().getRangeType().equals("ALL-SERVICE") || coupon.getCouponType().getSpecifyServiceIds().indexOf(param.getKey()) > -1)) {
            return true;
        }
        return false;
    }
}
