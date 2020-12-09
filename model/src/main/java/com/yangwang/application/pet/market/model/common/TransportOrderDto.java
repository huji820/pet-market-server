package com.yangwang.application.pet.market.model.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * <p>
 * 宠物运输订单
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className TransportOrderDto
 * @date 2020/3/26 9:22
 **/
@Data
@ApiModel(description = "宠物运输订单")
public class TransportOrderDto {
    @ApiModelProperty(value = "开始城市")
    String startCity;

    @ApiModelProperty(value = "目的城市")
    String endCity;

    @ApiModelProperty(value = "出发时间")
    String leaveDate;

    @ApiModelProperty(value = "宠物数量")
    Integer num;

    @ApiModelProperty(value = "宠物类别")
    String petType;

    @ApiModelProperty(value = "宠物类型")
    String petClassify;

    @ApiModelProperty(value = "宠物重量")
    BigDecimal weight;

    @ApiModelProperty(value = "运输方式")
    Integer transportType;

    @ApiModelProperty(value = "购买宠物笼")
    Integer buyPetCage;

    @ApiModelProperty(value = "上门接宠物地址")
    String receiptAddress;

    @ApiModelProperty(value = "上门接宠经度")
    String receiptLongitude;

    @ApiModelProperty(value = "上门接宠纬度")
    String receiptLatitude;

    @ApiModelProperty(value = "上门送宠物地址")
    String sendAddress;

    @ApiModelProperty(value = "送宠到家纬度")
    String sendLatitude;

    @ApiModelProperty(value = "送宠到家经度")
    String sendLongitude;

    @ApiModelProperty(value = "送宠到家距离")
    BigDecimal sendDistance;

    @ApiModelProperty(value = "宠物总金额")
    BigDecimal petAmount;

    @ApiModelProperty(value = "发宠人姓名")
    String senderName;

    @ApiModelProperty(value = "发宠人电话")
    String senderPhone;

    @ApiModelProperty(value = "收宠人姓名")
    String receiverName;

    @ApiModelProperty(value = "收宠人电话")
    String receiverPhone;

    @ApiModelProperty(value = "customerNo")
    String customerNo;

    @ApiModelProperty(value = "备注")
    String remarks;

    @ApiModelProperty(value = "免费食物 0:不需要 1:需要")
    Integer giveFood;

    @ApiModelProperty(value = "是否需要担保")
    Integer guarantee;

    @ApiModelProperty(value = "分享人openId")
    String shareOpenId;

    @ApiModelProperty(value = "宠物年龄")
    String petAge;
}
