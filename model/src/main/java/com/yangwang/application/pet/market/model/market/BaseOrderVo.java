package com.yangwang.application.pet.market.model.market;

import com.yangwang.application.pet.market.model.business.Business;
import com.yangwang.application.pet.market.model.common.ReceivingAddress;
import com.yangwang.application.pet.market.model.common.coupon.Coupon;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * <p>
 * 订单
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className BaseOrderVo
 * @date 2020/3/31 10:48
 **/
@Data
public abstract class BaseOrderVo {
    @ApiModelProperty(value = "数量")
    Integer qty;

    @ApiModelProperty(value = "买家")
    Business business;

    @ApiModelProperty(value = "收货地址")
    ReceivingAddress receivingAddress;

    @ApiModelProperty(value = "优惠券")
    Coupon coupon;

    @ApiModelProperty(value = "分销商")
    Business shareBusiness;

    @ApiModelProperty(value = "宠物价格")
    BigDecimal goodsPrice;

    @ApiModelProperty(value = "宠物金额")
    BigDecimal goodsAmount;

    @ApiModelProperty(value = "优惠券抵用金额")
    BigDecimal couponDisCountAmount;

    @ApiModelProperty(value = "实际支付金额")
    BigDecimal paymentAmount;

    @ApiModelProperty(value = "运输价格")
    BigDecimal transportAmount;
}
