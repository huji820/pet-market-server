package com.yangwang.application.pet.market.model.common;

import com.yangwang.application.pet.market.model.business.Business;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * <p>
 * 宠物对象
 * </p>
 *
 * @author LiuXiangLin
 * @date 9:00 2020/3/13
 **/
@Data
@ApiModel(value = "宠物表")
public class Pet {
    @ApiModelProperty(value = "宠物主键")
    String petNo;

    @ApiModelProperty(value = "宠物名称")
    String petName;

    @ApiModelProperty(value = "宠物分类主键")
    PetSort petSort;

    @ApiModelProperty(value = "宠物类型主键")
    PetGenre petGenre;

    @ApiModelProperty(value = "所属商家")
    Business business;

    @ApiModelProperty(value = "所属城市")
    String city;

    @ApiModelProperty(value = "性别(1:公,2:母)")
    Integer petSex;

    @ApiModelProperty(value = "是否绝育(1:已绝育,2:未绝育)")
    Integer petSterilization;

    @ApiModelProperty(value = "宠物生日")
    String petBirthday;

    @ApiModelProperty(value = "宠物CKU编号或芯片号(宠物唯一码)")
    String petUniqueCode;

    @ApiModelProperty(value = "零售价")
    BigDecimal retailPrice;

    @ApiModelProperty(value = "市场价")
    BigDecimal marketPrice;

    @ApiModelProperty(value = "佣金比例")
    BigDecimal commission;

    @ApiModelProperty(value = "佣金")
    BigDecimal commissionAmount;

    @ApiModelProperty(value = "底价")
    BigDecimal basePrice;

    @ApiModelProperty(value = "上架日期")
    String createDate;

    @ApiModelProperty(value = "上架时间")
    String createTime;

    @ApiModelProperty(value = "父亲照片")
    String fatherImg;

    @ApiModelProperty(value = "父亲姓名")
    String fatherName;

    @ApiModelProperty(value = "母亲照片")
    String motherImg;

    @ApiModelProperty(value = "母亲姓名")
    String motherName;

    @ApiModelProperty(value = "描述(html代码的路径)")
    String petDescription;

    @ApiModelProperty(value = "宠物重量")
    BigDecimal weight;

    @ApiModelProperty(value = "是否包邮")
    Integer freeShipping;

    @ApiModelProperty(value = "保险天数")
    Integer insurance;

    @ApiModelProperty(value = "是否七天质保")
    Integer sevenWarranty;

    @ApiModelProperty(value = "标签")
    String labels;

    @ApiModelProperty(value = "收藏量")
    Integer collectionQty;

    @ApiModelProperty(value = "评价数量")
    Integer evaluationQty;

    @ApiModelProperty(value = "好评率")
    BigDecimal favorableRate;

    @ApiModelProperty(value = "销量")
    Integer salesVolume;

    @ApiModelProperty(value = "上架状态")
    Integer petState;

    @ApiModelProperty(value = "权重")
    Integer power;

    @ApiModelProperty(value = "商品图片")
    String petImg;

    @ApiModelProperty(value = "是否是团购商品")
    Integer groupon;

    @ApiModelProperty(value = "是否售出")
    Integer petIsSell;

    @ApiModelProperty(value = "是否允许一键代发")
    Integer IssuedBehalf;

    @ApiModelProperty(value = "源头宠物编号")
    String sourcePetNo;

    public Pet() {
    }

    public Pet(String petNo) {
        this.petNo = petNo;
    }
}
