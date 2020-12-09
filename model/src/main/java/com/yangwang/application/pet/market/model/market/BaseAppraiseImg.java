package com.yangwang.application.pet.market.model.market;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * <p>
 * 评价图片
 * </p>
 *
 * @author LiuXiangLin
 * @date 10:12 2020/3/23
 **/
@Data
@ApiModel(value = "商家宠物评价图片表")
public abstract class BaseAppraiseImg {
    @ApiModelProperty(value = "主键")
    Integer appraiseImgNo;

    @ApiModelProperty(value = "评价图片")
    String imgAddress;
}
