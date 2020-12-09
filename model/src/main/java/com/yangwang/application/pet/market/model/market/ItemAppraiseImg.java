package com.yangwang.application.pet.market.model.market;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 商品评价图片
 * </p>
 *
 * @author LiuXiangLin
 * @date 9:06 2020/3/24
 **/
@Data
@ApiModel(value = "商品评价图片")
public class ItemAppraiseImg extends BaseAppraiseImg {
    @ApiModelProperty(value = "商品评价")
    ItemAppraise itemAppraise;
}
