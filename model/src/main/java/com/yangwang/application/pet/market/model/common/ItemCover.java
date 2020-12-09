package com.yangwang.application.pet.market.model.common;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 商品封面图片
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className ItemCover
 * @date 2020/4/9 9:09
 **/
@Data
public class ItemCover extends AbstractItemAdd {
    @ApiModelProperty(value = "主键")
    Integer coverNo;

    @ApiModelProperty(value = "地址")
    String coverAddress;

    @ApiModelProperty(value = "媒体类型")
    String type;

    @ApiModelProperty(value = "图片顺序")
    Integer order;
}
