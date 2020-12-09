package com.yangwang.application.pet.market.model.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * <p>
 * 宠物封面
 * </p>
 *
 * @author LiuXiangLin
 * @date 9:23 2020/3/13
 **/
@Data
@ApiModel(description = "宠物封面表")
@JsonIgnoreProperties(ignoreUnknown = true)
public class PetCover extends AbstractPetAdd {
    @ApiModelProperty(value = "主键")
    Integer coverNo;

    @ApiModelProperty(value = "地址")
    String coverAddress;

    @ApiModelProperty(value = "媒体类型")
    String type;

    @ApiModelProperty(value = "图片顺序")
    Integer order;
}
