package com.yangwang.application.pet.market.service.facade.common;

import com.yangwang.application.pet.market.model.common.coupon.CouponType;
import com.yangwang.application.pet.market.model.market.ItemOrder;
import com.yangwang.application.pet.market.model.market.ItemOrderInfo;
import com.yangwang.application.pet.market.model.vo.ItemOrderVo;
import com.yangwang.application.pet.market.service.spring.common.ItemOrderFacedServiceImpl;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * <p>
 * 宠物折扣
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className CouponItemService
 * @date 2020/3/28 14:19
 **/
public interface CouponItemService {

    /**
     * <p>
     * 计算优惠金额
     * </p>
     *
     * @param itemOrderVo 订单
     * @return java.math.BigDecimal
     * @author LiuXiangLin
     * @date 14:20 2020/3/28
     **/
    BigDecimal calcDisCount(ItemOrderVo itemOrderVo);

    /**
     * <p>
     * 是否满足最低使用要求
     * </p>
     *
     * @param itemOrder 商品订单对象
     * @return boolean
     * @author LiuXiangLin
     * @date 15:32 2020/3/30
     **/
    default boolean checkLeast(ItemOrder itemOrder) {
        if (itemOrder.getCoupon().getCouponType().isAtLeast()) {
            return itemOrder.getOriginalAmount().compareTo(BigDecimal.valueOf(itemOrder.getCoupon().getCouponType().getLeastAmount())) >= 0;
        }
        return true;
    }

    /**
     * <p>
     * 是否满足商家要求
     * </p>
     *
     * @param itemOrderVo 商品订单vo对象
     * @return boolean
     * @author LiuXiangLin
     * @date 15:36 2020/3/30
     **/
    default boolean checkBusiness(ItemOrderVo itemOrderVo) {
        if (CouponType.RANGE_TYPE_PART.equals(itemOrderVo.getCoupon().getCouponType().getBusinessType())) {
            return itemOrderVo.getCoupon().getCouponType().getSpecifyBusinessIds().contains(itemOrderVo.getSeller().getBusinessNo());
        }
        return true;
    }

    /**
     * <p>
     * 校验商品是否在范围内
     * </p>
     *
     * @param itemOrder 商品订单vo
     * @return boolean
     * @author LiuXiangLin
     * @date 10:34 2020/4/1
     **/
    default boolean checkItem(ItemOrder itemOrder) {
        int i = 0;
        for(ItemOrderInfo itemOrderInfo : itemOrder.getItemOrderInfoList()){
            if (CouponType.RANGE_TYPE_PART.equals(itemOrder.getCoupon().getCouponType().getRangeType())) {
                i++;
                if(itemOrder.getCoupon().getCouponType().getSpecifyItemIds().contains(itemOrderInfo.getBarCode())){
                    return true;
                }
            }
        }
        if(i == itemOrder.getItemOrderInfoList().size()){
            return false;
        }
        return true;
    }
}
