package com.yangwang.application.pet.market.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
@ApiModel(value = "删除购物车条件")
public class DelShoppingCartVO {
    @ApiModelProperty(value="商品或宠物 0/1")
    int goodsType;

    @ApiModelProperty(value="用户No")
    String businessNo;

    @ApiModelProperty(value="商品或宠物No")
    String goodsNo;
}
