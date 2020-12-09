package com.yangwang.application.pet.market.model.business;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * <p>
 * 商家余额流水Vo
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className BusinessBalanceFlowVo
 * @date 2020/4/2 10:11
 **/
@Data
public class BusinessBalanceFlowVo {
    @ApiModelProperty(value = "订单编号")
    String orderNo;

    @ApiModelProperty(value = "商家名称")
    String shopName;

    @ApiModelProperty(value = "分销人名称")
    String distributorName;

    @ApiModelProperty(value = "买家名称")
    String buyerName;

    @ApiModelProperty(value = "日期")
    String createDate;

    @ApiModelProperty(value = "时间")
    String createTime;

    @ApiModelProperty(value = "支付金额")
    BigDecimal paymentAmount;

    @ApiModelProperty(value = "商家获取金额")
    BigDecimal shopAmount;

    @ApiModelProperty(value = "运费")
    BigDecimal carriage;

    @ApiModelProperty(value = "优惠券抵扣金额")
    BigDecimal couponAmount;

    @ApiModelProperty(value = "分销金额")
    BigDecimal distributorAmount;
}
