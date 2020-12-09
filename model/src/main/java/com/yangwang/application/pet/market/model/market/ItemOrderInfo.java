package com.yangwang.application.pet.market.model.market;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * <p>
 *   商品订单信息
 * </p>
 *
 * @Author zhouxiaojian
 * @Date 2020/9/3 14:36
 * @Version 1.0
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(value = "商品订单信息")
public class ItemOrderInfo {

    @ApiModelProperty("商品信息主键")
    Integer orderInfoNo;

    @ApiModelProperty("商品订单外键")
    String orderNo;

    @ApiModelProperty("商品外键")
    Integer itemNo;

    @ApiModelProperty("卖家外键")
    String shopNo;

    @ApiModelProperty("分销商外键")
    String distributorNo;

    @ApiModelProperty("分销金额")
    BigDecimal distributorAmount;

    @ApiModelProperty("价格")
    BigDecimal price;

    @ApiModelProperty("单价")
    BigDecimal unitPrice;

    @ApiModelProperty("数量")
    Integer qty;

    @ApiModelProperty("成本价")
    BigDecimal costPrice;

    @ApiModelProperty(value = "商品名称")
    String itemName;

    @ApiModelProperty(value = "商品一级分类编号")
    Integer petSortNo;

    @ApiModelProperty(value = "商品品牌编号")
    Integer petBrandNo;

    @ApiModelProperty(value = "商品条码")
    String barCode;

    @ApiModelProperty(value = "毛重")
    BigDecimal grossWeight;

    @ApiModelProperty(value = "质保时长")
    String itemValidity;

    @ApiModelProperty(value = "适用宠物类别")
    String petGenreStr;

    @ApiModelProperty(value = "商品封面")
    String coverImg;

}
