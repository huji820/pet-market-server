package com.yangwang.application.pet.market.model.vo;

import com.yangwang.application.pet.market.model.market.BaseOrderVo;
import com.yangwang.application.pet.market.model.market.PetOrderVo;
import com.yangwang.sysframework.utils.TypeConvertUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * <p>
 * 宠物价格
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className OrderPriceVo
 * @date 2020/3/30 14:17
 **/
@Data
@ApiModel(description = "价格Vo")
public class OrderPriceVo {
    /**
     * 计算成功
     */
    public static final int SUCCESS_CALC = 0;
    /**
     * 运输价格计算错误
     */
    public static final int ERROR_TRANSPORT = -1;
    /**
     * 优惠券价格错误
     */
    public static final int ERROR_COUPON = -2;
    /**
     * 计算宠物价格错误
     */
    public static final int ERROR_PRICE = -3;

    @ApiModelProperty(value = "商品单价")
    BigDecimal goodsPrice;

    @ApiModelProperty(value = "商品金额")
    BigDecimal goodsAmount;

    @ApiModelProperty(value = "数量")
    Integer qty;

    @ApiModelProperty(value = "运输价格")
    BigDecimal transportAmount;

    @ApiModelProperty(value = "优惠券抵用金额")
    BigDecimal couponDiscountAmount;

    @ApiModelProperty(value = "需要支付的金额")
    BigDecimal paymentAmount;

    @ApiModelProperty(value = "价格状态")
    Integer priceState;

    /**
     * <p>
     * 计算最终支付价格
     * </p>
     *
     * @return java.math.BigDecimal
     * @author LiuXiangLin
     * @date 16:17 2020/3/30
     **/
    public BigDecimal calcPaymentAmount() {
        System.out.println("goodsAmount" + goodsAmount);
        System.out.println("transportAmount" + transportAmount);
        System.out.println("couponDiscountAmount" + couponDiscountAmount);
        return TypeConvertUtil.$BigDecimal(goodsAmount).add(TypeConvertUtil.$BigDecimal(transportAmount)).subtract(TypeConvertUtil.$BigDecimal(couponDiscountAmount));
    }


    public boolean checkSame(BaseOrderVo baseOrderVo) {
        if (goodsPrice.compareTo(baseOrderVo.getGoodsPrice()) != 0) {
            throw new RuntimeException("宠物价格前后不一致！");
        }
        if (goodsAmount.compareTo(baseOrderVo.getGoodsAmount()) != 0) {
            throw new RuntimeException("宠物金额前后不一致！");
        }
        if (!qty.equals(baseOrderVo.getQty())) {
            throw new RuntimeException("宠物数量前后不一致！");
        }
//        if (transportAmount.compareTo(baseOrderVo.getTransportAmount()) != 0) {
//            throw new RuntimeException("运输金额前后不一致！");
//        }
        if (couponDiscountAmount.compareTo(baseOrderVo.getCouponDisCountAmount()) != 0) {
            throw new RuntimeException("优惠券折扣金额前后不一致！");
        }
//        if (paymentAmount.compareTo(baseOrderVo.getPaymentAmount()) != 0) {
//            throw new RuntimeException("支付金额前后不一致！");
//        }
        return true;
    }
}
