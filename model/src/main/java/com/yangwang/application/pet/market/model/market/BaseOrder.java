package com.yangwang.application.pet.market.model.market;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.yangwang.application.pet.market.model.business.Business;
import com.yangwang.application.pet.market.model.common.coupon.Coupon;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 订单
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className BaseOrder
 * @date 2019/10/24 15:14
 **/
@Data
@ApiModel(description = "订单")
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class BaseOrder {
    @ApiModelProperty(value = "订单编号")
    String orderNo;

    @ApiModelProperty(value = "商家")
    Business shop;

    @ApiModelProperty(value = "分销员")
    Business distributor;

    @ApiModelProperty(value = "购买人")
    Business buyer;

    @ApiModelProperty(value = "订单日期")
    String createDate;

    @ApiModelProperty(value = "订单时间")
    String createTime;

    @ApiModelProperty(value = "数量")
    Integer qty;

    @ApiModelProperty(value = "使用的优惠券")
    Coupon coupon;

    @ApiModelProperty(value = "券抵用金额")
    BigDecimal couponAmount;

    @ApiModelProperty(value = "商家金额")
    BigDecimal shopAmount;

    @ApiModelProperty(value = "运费")
    BigDecimal carriage;

    @ApiModelProperty(value = "是否包邮")
    Integer freeShipping;

    @ApiModelProperty(value = "原价金额")
    BigDecimal originalAmount;

    @ApiModelProperty(value = "零售价")
    BigDecimal retailPrice;

    @ApiModelProperty(value = "实际付款金额")
    BigDecimal paymentAmount;

    @ApiModelProperty(value = "分销金额")
    BigDecimal distributorAmount;

    @ApiModelProperty(value = "收件人名称")
    String receivingName;

    @ApiModelProperty(value = "收件人电话号码")
    String receivingPhone;

    @ApiModelProperty(value = "收件人地址")
    String receivingAddress;

    @ApiModelProperty(value = "支付状态(0:未支付;1:已支付)")
    Integer paymentState;

    @ApiModelProperty(value = "发货状态(0:未发货;1:已发货)")
    Integer driverState;

    @ApiModelProperty(value = "收货状态(0:未收货;1:已收货)")
    Integer receiveState;

    @ApiModelProperty(value = "是否已经评价(0：未评价;1:已评价)")
    Integer evaluateState;

    @ApiModelProperty(value = "是否退款（0：未退款，1：退款中 2 ：退款完成）")
    Integer refundsState;

    @ApiModelProperty(value = "运单号")
    String wayBill;

    @ApiModelProperty(value = "微信商户订单号")
    String outTradeNo;

    @ApiModelProperty(value = "退款单号")
    String refundNo;
}
