package com.yangwang.application.pet.market.model.market;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;


/**
 * 宠物订单
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className PetOrder
 * @date 2019/10/24 15:14
 **/

@Data
@ApiModel(value = "商家宠物订单表")
public class PetOrder extends BaseOrder {
    @ApiModelProperty(value = "商品主键")
    String petNo;

    @ApiModelProperty(value = "商品名称")
    String petName;

    @ApiModelProperty(value = "宠物一级分类编号")
    Integer petSortNo;

    @ApiModelProperty(value = "宠物二级编号")
    Integer petGenreNo;

    @ApiModelProperty(value = "宠物性别")
    Integer petSex;

    @ApiModelProperty(value = "是否绝育")
    Integer petSterilization;

    @ApiModelProperty(value = "宠物生日")
    String petBirthday;

    @ApiModelProperty(value = "宠物唯一编码")
    String petUniqueCode;

    @ApiModelProperty(value = "宠物重量")
    BigDecimal weight;

    @ApiModelProperty(value = "质保天数")
    Integer insurance;

    @ApiModelProperty(value = "七天质保")
    Integer sevenWarranty;

    @ApiModelProperty(value = "宠物图片")
    String petImg;

    @ApiModelProperty(value = "是否是团购商品")
    Integer groupon;

    @ApiModelProperty(value = "支付凭证")
    private String paymentVoucher;
}
