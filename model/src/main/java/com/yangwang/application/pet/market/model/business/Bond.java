package com.yangwang.application.pet.market.model.business;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * <p>
 * 商家保证金
 * </p>
 *
 * @author LiuXiangLin
 * @date 14:36 2020/3/24
 **/
@Data
@ApiModel(value = "商家保证金")
public class Bond {
    @ApiModelProperty(value = "单据编号")
    String billNo;

    @ApiModelProperty(value = "商家")
    Business business;

    @ApiModelProperty(value = "创建日期")
    String createDate;

    @ApiModelProperty(value = "创建时间")
    String createTime;

    @ApiModelProperty(value = "支付金额")
    BigDecimal paymentAmount;

    @ApiModelProperty(value = "支付状态")
    Integer paymentState;
}
