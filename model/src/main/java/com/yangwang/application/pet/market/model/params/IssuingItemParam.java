package com.yangwang.application.pet.market.model.params;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author yang hituzi
 * @description 商品 代发
 * @date 2020年4月14日 16:00:25
 */
@Data
@ApiModel(value = "商品代发参数")
public class IssuingItemParam {

    @ApiModelProperty(value = "商家编号")
    String businessNo;

    @ApiModelProperty(value = "商品编号")
    Integer itemNo;

    @ApiModelProperty(value = "零售价")
    BigDecimal retailPrice;

    @ApiModelProperty(value = "佣金")
    BigDecimal commissionAmount;
}
