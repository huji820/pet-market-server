package com.yangwang.application.pet.market.model.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 商品类别
 * </p>
 *
 * @author LiuXiangLin
 * @date 10:44 2020/3/22
 **/
@Data
@ApiModel(value = "商品类别")
public class ItemType {
    @ApiModelProperty(value = "类别主键")
    Integer itemTypeNo;

    @ApiModelProperty(value = "类别名称")
    String itemTypeName;

    @ApiModelProperty(value = "类别图片")
    String itemTypeImg;
}
