package com.yangwang.application.pet.market.model.common.coupon;

import com.yangwang.application.pet.market.model.business.Business;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 优惠券
 * </p>
 *
 * @author LiuXiangLin
 * @date 16:56 2020/3/27
 **/
@Data
@ApiModel(value = "优惠券")
public class Coupon {
    @ApiModelProperty(value = "优惠券编号 ")
    Long couponID;

    @ApiModelProperty(value = "优惠券类别")
    CouponType couponType;

    @ApiModelProperty(value = "所属客户")
    Business business;

    @ApiModelProperty(value = "优惠券是否已使用，0 表示未使用，1 表示已使用")
    boolean used;

    @ApiModelProperty(value = "优惠券是否已失效，0 表示未实效，1 表示已实效")
    boolean invalid;

    @ApiModelProperty(value = "核销码")
    String verifyCode;

    public Coupon() {
    }

    public Coupon(CouponType couponType, Business business, boolean used, boolean invalid, String verifyCode) {
        this.couponType = couponType;
        this.business = business;
        this.used = used;
        this.invalid = invalid;
        this.verifyCode = verifyCode;
    }
}
