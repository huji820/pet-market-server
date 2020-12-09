package com.yangwang.application.pet.market.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
@ApiModel(value = "购物车")
public class ShoppingCartVO {
    @ApiModelProperty(value="数量")
    int qty;

    @ApiModelProperty(value="宠物或用品id")
    String goodsNo;

    @ApiModelProperty(value = "用户id")
    String businessNo;

    @ApiModelProperty(value = "添加类型(宠物或用品)")
    int goodsType;

    @ApiModelProperty(value = "价格")
    BigDecimal goodsPrice;

    @ApiModelProperty(value = "名称")
    String goodsName;

    @ApiModelProperty(value = "图片")
    String goodsCoverimg;

    @ApiModelProperty(value = "描述")
    String description;

    @ApiModelProperty(value = "店铺名称")
    String storeName;

    @ApiModelProperty(value = "选框")
    boolean checked;


}
