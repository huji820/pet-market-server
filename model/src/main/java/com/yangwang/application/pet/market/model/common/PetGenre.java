package com.yangwang.application.pet.market.model.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * <p>
 * 宠物二级分类
 * </p>
 *
 * @author LiuXiangLin
 * @date 13:42 2020/3/22
 **/
@Data
@ApiModel(value = "宠物类型表")
public class PetGenre {
    @ApiModelProperty(value = "宠物分类")
    PetSort petSort;

    @ApiModelProperty(value = "宠物类型主键")
    Integer petGenreNo;

    @ApiModelProperty(value = "宠物类型名称")
    String petGenreName;

    @ApiModelProperty(value = "宠物图片")
    String petGenreImg;

    @ApiModelProperty(value = "拼音")
    String pinyin;

    @ApiModelProperty(value = "描述")
    String describe;
}
