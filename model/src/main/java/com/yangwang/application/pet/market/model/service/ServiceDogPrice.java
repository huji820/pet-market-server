package com.yangwang.application.pet.market.model.service;

import com.yangwang.application.pet.market.model.common.PetSort;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 服务分类
 * @Description
 * @Author Administrator
 * @Date 2020-03-20 21:53
 * @Version 1.0
 */
@Data
@ApiModel(value = "狗服务价格")
public class ServiceDogPrice {

    @ApiModelProperty(value = "价格主键")
    long servicePriceID;

    @ApiModelProperty(value = "所属服务")
    Service service;

    @ApiModelProperty(value = "宠物种类")
    PetSort petSort;

    @ApiModelProperty(value = "毛发长度")
    int hairLength;

    @ApiModelProperty(value = "宠物起始长度")
    int startWeight;

    @ApiModelProperty(value = "宠物起始长度")
    int endWeight;

    @ApiModelProperty(value = "服务价格")
    BigDecimal servicePrice;
}
