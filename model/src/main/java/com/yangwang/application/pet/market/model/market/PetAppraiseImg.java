package com.yangwang.application.pet.market.model.market;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * <p>
 * 商家宠物评价图片表
 * </p>
 *
 * @author LiuXiangLin
 * @date 16:47 2020/3/23
 **/
@Data
@ApiModel(value = "商家宠物评价图片表")
public class PetAppraiseImg extends BaseAppraiseImg {
    @ApiModelProperty(value = "所属评价")
    PetAppraise petAppraise;
}
