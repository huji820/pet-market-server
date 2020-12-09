package com.yangwang.application.pet.market.model.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * <p>
 * 商品品牌
 * </p>
 *
 * @author LiuXiangLin
 * @date 10:28 2020/3/22
 **/
@Data
@ApiModel(value = "商品品牌")
public class ItemBrand {
    @ApiModelProperty(value = "品牌主键")
    Integer itemBrandNo;

    @ApiModelProperty(value = "品牌名称")
    String itemBrandName;

    @ApiModelProperty(value = "品牌图片")
    String itemBrandImg;
}
