package com.yangwang.application.pet.market.model.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * <p>
 * 宠物疫苗
 * </p>
 *
 * @author LiuXiangLin
 * @date 9:24 2020/3/13
 **/
@Data
@ApiModel(value = "宠物疫苗表")
public class PetVaccine extends AbstractPetAdd {
    @ApiModelProperty(value = "主键")
    Integer vaccineNo;

    @ApiModelProperty(value = "打育苗时间")
    String vaccineDate;

    @ApiModelProperty(value = "育苗的品牌")
    String vaccineBrandName;
}
