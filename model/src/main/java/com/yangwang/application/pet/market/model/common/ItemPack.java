package com.yangwang.application.pet.market.model.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 商品套餐
 * </p>
 *
 * @author LiuXiangLin
 * @date 10:10 2020/3/22
 **/
@Data
@ApiModel(value = "商品套餐")
public class ItemPack {
    @ApiModelProperty(value = "套餐主键")
    Integer itemPackNo;

    @ApiModelProperty(value = "套餐名称")
    String itemPackName;

    @ApiModelProperty(value = "套餐图片")
    String itemPackImg;
}
