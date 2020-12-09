package com.yangwang.application.pet.market.model.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 宠物分类
 * </p>
 *
 * @author LiuXiangLin
 * @date 11:45 2020/3/22
 **/
@Data
@ApiModel(value = "宠物分类")
public class PetSort {
    @ApiModelProperty(value = "宠物分类主键")
    Integer petSortNo;

    @ApiModelProperty(value = "宠物分类名称")
    String petSortName;

    @ApiModelProperty(value = "分类图片")
    String petSortImg;

    @ApiModelProperty(value = "拼音")
    String pinyin;
}
