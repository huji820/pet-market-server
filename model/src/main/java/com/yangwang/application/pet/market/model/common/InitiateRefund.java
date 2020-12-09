package com.yangwang.application.pet.market.model.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @program: trunk
 * @description: 发起退款
 * @author: lsy
 * @create: 2019-12-06 :
 **/

@Data
@ApiModel(value = "退款")
public class InitiateRefund {

    @ApiModelProperty(value = "退款主键")
    private String refundNo;

    @ApiModelProperty(value = "订单主键")
    private String petOrderNo;

    @ApiModelProperty(value = "商品主键")
    private String itemOrderNo;

    @ApiModelProperty(value = "退款单号")
    private String refundOrderNo;

    @ApiModelProperty(value = "退款金额")
    private BigDecimal refundFee;

    @ApiModelProperty(value = "是否同意退款：(-1: 不同意；1：同意)")
    Integer refundState;

    @ApiModelProperty(value = "原因")
    private String refundCause;

    @ApiModelProperty(value = "拒绝退款原因")
    private String cancelRefundCause;

    @ApiModelProperty(value = "订单金额")
    BigDecimal totalFee;
}
