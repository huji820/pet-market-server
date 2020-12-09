package com.yangwang.application.pet.market.dao.market.coupon;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CouponExchangeMapper {

    /**
     *
     * 获取用户兑换该优惠券数量
     * @param couponTypeID
     * @param businessNo
     * @return int
     * @author yang hituzi
     * @date 11:01 2020/4/8
     */
    int countCouponByBusinessNo(@Param("couponTypeID") long couponTypeID,
                                @Param("businessNo") String businessNo);

    /**
     *
     * 使用核销码更新优惠券
     * @param verifyCode
     * @return int
     * @author yang hituzi
     * @date 15:15 2020/4/8
     */
    int updateCouponByVerifyCode(@Param("verifyCode") String verifyCode);
}
