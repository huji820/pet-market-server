package com.yangwang.application.pet.market.model.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * <p>
 * 商品团购
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className ItemGroupon
 * @date 2020/4/8 17:51
 **/
@Data
@ApiModel(description = "团购商品")
public class ItemGroupon extends AbstractItemAdd {
    @ApiModelProperty(value = "主键")
    Integer itemGrouponNo;

    @ApiModelProperty(value = "数量")
    Integer qty;

    @ApiModelProperty(value = "价格")
    BigDecimal price;
}
