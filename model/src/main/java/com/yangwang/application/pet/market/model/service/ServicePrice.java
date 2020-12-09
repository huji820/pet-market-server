package com.yangwang.application.pet.market.model.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.yangwang.application.pet.market.model.common.PetHair;
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
@ApiModel(value = "服务分类")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ServicePrice {
    @ApiModelProperty(value = "价格主键")
    long servicePriceID;

    @ApiModelProperty(value = "所属服务")
    Service service;

    @ApiModelProperty(value = "宠物种类")
    PetSort petSort;

    @ApiModelProperty(value = "毛发长度")
    PetHair petHair;

    @ApiModelProperty(value = "宠物起始重量")
    int startWeight;

    @ApiModelProperty(value = "宠物结束重量")
    int endWeight;

    @ApiModelProperty(value = "年龄类型")
    int ageType;

    @ApiModelProperty(value = "服务价格")
    BigDecimal servicePrice;
}
