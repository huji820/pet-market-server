package com.yangwang.application.pet.market.model.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @TODO
 * @Description
 * @Author Administrator
 * @Date 2020-03-28 11:08
 * @Version 1.0
 */
@Data
@ApiModel(value = "宠物毛发")
public class PetHair {

    @ApiModelProperty(value = "宠物毛发长度主键")
    int hairLength;

    @ApiModelProperty(value = "宠物毛发长度名称")
    String hairLengthName;
}
