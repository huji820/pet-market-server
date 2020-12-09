package com.yangwang.application.pet.market.service.facade.coupon;

import com.yangwang.application.pet.market.model.common.coupon.CouponType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 优惠券类型
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className CouponTypeService
 * @date 2020/3/27 15:05
 **/
public interface CouponTypeService {
    /**
     * <p>
     * 通过主键获取数据
     * </p>
     *
     * @param couponTypeId 主键
     * @return com.yangwang.application.pet.market.model.common.coupon.CouponType
     * @author LiuXiangLin
     * @date 15:05 2020/3/27
     **/
    CouponType get(long couponTypeId);

    /**
     *
     * 显示所有优惠券列表
     * @param
     * @return java.util.List<com.yangwang.application.pet.market.model.common.coupon.CouponType>
     * @author yang hituzi
     * @date 15:01 2020/4/15
     */
    List<CouponType> list(Integer preferentialType);

    /**
     * 添加优惠券类型
     * @param couponType
     * @return
     */
    int save(CouponType couponType);

    /**
     * 添加新客大礼包
     * @param couponTypeList
     * @return
     */
    int addNewGuestGiftBag(List<CouponType> couponTypeList);

    /**
     * 获取新客大礼包所有优惠券
     * @return
     */
    List<CouponType> listNewGuestGiftBag();
}
