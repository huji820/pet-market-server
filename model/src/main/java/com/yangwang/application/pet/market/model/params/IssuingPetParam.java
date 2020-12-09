package com.yangwang.application.pet.market.model.params;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author yang hituzi
 * @description 宠物 代发
 * @date 2020年4月14日 16:09:34
 */
@Data
@ApiModel(value = "宠物代发参数")
public class IssuingPetParam {

    @ApiModelProperty(value = "商家编号")
    String businessNo;

    @ApiModelProperty(value = "宠物编号")
    String petNo;

    @ApiModelProperty(value = "零售价")
    BigDecimal retailPrice;

    @ApiModelProperty(value = "佣金")
    BigDecimal commissionAmount;
}
