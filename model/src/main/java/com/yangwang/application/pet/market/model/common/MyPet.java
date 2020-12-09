package com.yangwang.application.pet.market.model.common;

import com.yangwang.application.pet.market.model.business.Business;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 爱宠
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className MyPet
 * @date 2020/3/24 17:31
 **/
@Data
@ApiModel(description = "爱宠")
public class MyPet {
    @ApiModelProperty(value = "爱宠编号")
    Integer petNo;

    @ApiModelProperty(value = "宠物名称")
    String petName;

    @ApiModelProperty(value = "宠物类型")
    PetSort petSort;

    @ApiModelProperty(value = "宠物类别")
    PetGenre petGenre;

    @ApiModelProperty(value = "所属商家")
    Business business;

    @ApiModelProperty(value = "宠物图片")
    String petImg;

    @ApiModelProperty(value = "宠物性别")
    Integer petSex;

    @ApiModelProperty(value = "宠物生日")
    String petBirthday;

    @ApiModelProperty(value = "宠物重量")
    String petWeight;

    @ApiModelProperty(value = "毛色")
    String coatColor;

    @ApiModelProperty(value = "肩高")
    Integer shoulderHeight;

    @ApiModelProperty(value = "是否打过疫苗")
    Integer petVaccine;

    @ApiModelProperty(value = "是否绝育")
    Integer petSterilization;

}
