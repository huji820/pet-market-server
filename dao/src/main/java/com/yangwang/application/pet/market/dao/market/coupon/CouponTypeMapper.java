package com.yangwang.application.pet.market.dao.market.coupon;

import com.yangwang.application.pet.market.model.common.coupon.CouponType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 优惠券类别
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className CouponTypeMapper
 * @date 2020/3/27 13:56
 **/
public interface CouponTypeMapper {
    /**
     * <p>
     * 听过主键获取券类别
     * </p>
     *
     * @param couponTypeId 券类别编号
     * @return com.yangwang.application.pet.market.model.common.coupon.CouponType
     * @author LiuXiangLin
     * @date 13:57 2020/3/27
     **/
    CouponType get(@Param("couponTypeId") long couponTypeId);

    /**
     *
     * 显示所有可兑换优惠券种类列表
     * @param
     * @return java.util.List<com.yangwang.application.pet.market.model.common.coupon.CouponType>
     * @author yang hituzi
     * @date 14:59 2020/4/15
     */
    List<CouponType> list(@Param("preferentialType") Integer preferentialType);

    /**
     * 添加优惠券类型
     * @param couponType
     * @return
     */
    int save(@Param("couponType")CouponType couponType);

    /**
     * 通过标题获取优惠券类型
     * @param title
     * @return
     */
    List<CouponType> listByTitle(@Param("title")String title);
}
