package com.yangwang.application.pet.market.model.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 宠物驱虫
 * </p>
 *
 * @author LiuXiangLin
 * @date 9:24 2020/3/13
 **/
@Data
@ApiModel(value = "宠物驱虫表")
public class PetWormKill extends AbstractPetAdd {
    @ApiModelProperty(value = "驱虫主键")
    Integer wormKillNo;

    @ApiModelProperty(value = "驱虫时间")
    String killDate;

    @ApiModelProperty(value = "驱虫品牌")
    String killBrandName;
}
