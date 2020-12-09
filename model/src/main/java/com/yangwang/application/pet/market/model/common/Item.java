package com.yangwang.application.pet.market.model.common;

import com.yangwang.application.pet.market.model.business.Business;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;


/**
 * <p>
 * 商品
 * </p>
 *
 * @author LiuXiangLin
 * @date 17:09 2020/3/21
 **/
@Data
@ApiModel(value = "商品")
public class Item {
    @ApiModelProperty(value = "商品主键")
    Integer itemNo;

    @ApiModelProperty(value = "商品名称")
    String itemName;

    @ApiModelProperty(value = "商品简介")
    String itemProfile;

    @ApiModelProperty(value = "宠物分类（作为宠物的一级分类）")
    PetSort petSort;

    @ApiModelProperty(value = "商品类型")
    List<ItemType> itemTypes;

    @ApiModelProperty(value = "条码")
    String barCode;

    @ApiModelProperty(value = "商品品牌")
    ItemBrand itemBrand;

    @ApiModelProperty(value = "套餐分类")
    List<ItemPack> itemPacks;

    @ApiModelProperty(value = "所属商家")
    Business business;

    @ApiModelProperty(value = "宠粮对应宠物阶段")
    String itemStage;

    @ApiModelProperty(value = "毛重")
    BigDecimal grossWeight;

    @ApiModelProperty(value = "保质")
    String itemValidity;

    @ApiModelProperty(value = "品种")
    String petGenreStr;

    @ApiModelProperty(value = "零售价")
    BigDecimal retailPrice;

    @ApiModelProperty(value = "市场价")
    BigDecimal marketPrice;

    @ApiModelProperty(value = "佣金比例")
    BigDecimal commission;

    @ApiModelProperty(value = "佣金金额")
    BigDecimal commissionAmount;

    @ApiModelProperty(value = "底价")
    BigDecimal basePrice;

    @ApiModelProperty(value = "封面")
    String coverImg;

    @ApiModelProperty(value = "上架日期")
    String createDate;

    @ApiModelProperty(value = "上架时间")
    String createTime;

    @ApiModelProperty(value = "描述(html代码的路径)")
    String itemDescription;

    @ApiModelProperty(value = "状态")
    Integer itemState;

    @ApiModelProperty(value = "是否包邮")
    Integer freeShipping;

    @ApiModelProperty(value = "收藏量")
    Integer collectionQty;

    @ApiModelProperty(value = "评价数量")
    Integer evaluationQty;

    @ApiModelProperty(value = "好评率")
    BigDecimal favorableRate;

    @ApiModelProperty(value = "销量")
    Integer salesVolume;

    @ApiModelProperty(value = "是否是组合商品")
    Integer groupon;

    @ApiModelProperty(value = "团购商品标题")
    String groupTitle;

    @ApiModelProperty(value = "库存")
    Integer qty;

    @ApiModelProperty(value = "成本价")
    BigDecimal costPrice;

    @ApiModelProperty(value = "是否允许一键代发")
    Integer issuedBehalf;

    @ApiModelProperty(value = "源头商品编号")
    String sourceItemNo;

    @ApiModelProperty(value = "商品厂家编号")
    String manufactor;

    //*****************扩展为了方便存数据库****************//

    @ApiModelProperty(value = "itemType的字符串存入形式")
    String types;

    @ApiModelProperty(value = "itemPack的字符串存入形式")
    String packs;
}
