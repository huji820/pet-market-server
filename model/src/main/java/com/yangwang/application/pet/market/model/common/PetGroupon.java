package com.yangwang.application.pet.market.model.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * <p>
 * 宠物团购
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className PetGroupon
 * @date 2020/3/25 10:58
 **/
@Data
@ApiModel(description = "宠物团购")
public class PetGroupon extends AbstractPetAdd {
    @ApiModelProperty(value = "主键")
    Integer petGrouponNo;

    @ApiModelProperty(value = "数量")
    Integer qty;

    @ApiModelProperty(value = "价格")
    BigDecimal price;
}
