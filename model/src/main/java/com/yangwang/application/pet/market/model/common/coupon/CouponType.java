package com.yangwang.application.pet.market.model.common.coupon;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 优惠券
 *
 * @Description
 * @Author Administrator
 * @Date 2020-03-21 0:38
 * @Version 1.0
 */
@Data
@ApiModel(value = "优惠券类别")
public class CouponType {

    // 折扣券
    public static final int TYPE_DISCOUNT = 1;

    // 代金券
    public static final int TYPE_CASE = 2;

    // 领用券
    public static final int TYPE_RECEIVE = 3;

    public static final String RANGE_TYPE_ALL = "ALL";

    public static final String RANGE_TYPE_PART = "PART";


    @ApiModelProperty(value = "优惠券类别主键 ")
    long couponTypeID;

    @ApiModelProperty(value = "优惠券标题")
    String title;

    @ApiModelProperty(value = "优惠属性，2表示优惠，1表示折扣, 3表示领用券")
    int preferentialType;

    @ApiModelProperty(value = "折扣（示例：88 8.8折）")
    int discount;

    @ApiModelProperty(value = "优惠券面额(示例：50元)")
    BigDecimal value;

    @ApiModelProperty(value = "领用商品/服务主键")
    Long receiveId;

    @ApiModelProperty(value = "领用商品/服务数量")
    Integer receiveNum;

    @ApiModelProperty(value = "兑换优惠券所需积分")
    Integer couponCredit;

    @ApiModelProperty(value = "是否到期前4天发送提醒，0 表示不发送，1 表示发送")
    boolean expireNotice;

    @ApiModelProperty(value = "是否设置满多少元可用，0 表示不限制，1 表示限制")
    boolean atLeast;

    @ApiModelProperty(value = "最低满的金额")
    Integer leastAmount;

    @ApiModelProperty(value = "是否仅原价购买商品时可用，0 表示否，1 表示是")
    boolean forbidPreference;

    @ApiModelProperty(value = "每人限领个数，为 0 则表示不限制")
    int quota;

    @ApiModelProperty(value = "可用范围的类型，可选值：PART（部分商品可用，或指定商品可用）ALL（全部商品可用）")
    String rangeType;

    @ApiModelProperty(value = "可用商家范围的类型，可选值：PART（部分商家可用，或指定商家可用）ALL（全部商品可用）")
    String businessType;

    @ApiModelProperty(value = "否如果 range_type 为 PART，需要指定可用商品ID，多个用半角逗号分隔")
    String specifyItemIds;

    @ApiModelProperty(value = "否如果 range_type 为 PART，需要指定可用商品ID，多个用半角逗号分隔")
    String specifyServiceIds;

    @ApiModelProperty(value = "如果businessType 为PART,需指定可用的商家ID，多个用半角逗号分隔")
    String specifyBusinessIds;
}
