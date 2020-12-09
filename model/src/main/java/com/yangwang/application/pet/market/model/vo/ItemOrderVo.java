package com.yangwang.application.pet.market.model.vo;

import com.yangwang.application.pet.market.model.business.Business;
import com.yangwang.application.pet.market.model.common.ReceivingAddress;
import com.yangwang.application.pet.market.model.common.coupon.Coupon;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 * 商品订单vo
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className ItemOrderVo
 * @date 2020/3/30 10:00
 **/
@Data
@ApiModel(description = "商品订单Vo")
public class ItemOrderVo{

    @ApiModelProperty(value = "商品订单信息vo集合")
    List<ItemOrderInfoVo> itemOrderInfoVos;

    @ApiModelProperty(value = "卖家")
    Business seller;

    @ApiModelProperty(value = "购买人")
    Business buyer;

    @ApiModelProperty(value = "收货地址")
    ReceivingAddress receivingAddress;

    @ApiModelProperty(value = "优惠券")
    Coupon coupon;

    @ApiModelProperty(value = "优惠券抵用金额")
    BigDecimal couponDisCountAmount;

    @ApiModelProperty(value = "分销商")
    Business shareBusiness;

    @ApiModelProperty(value = "配送方式 0自提 1商家配送")
    Integer shippingMethods;
}
