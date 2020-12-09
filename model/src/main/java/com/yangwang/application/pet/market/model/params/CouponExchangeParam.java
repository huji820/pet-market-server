package com.yangwang.application.pet.market.model.params;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author yang hituzi
 * @description 兑换优惠券参数
 * @date 2020年4月8日 14:12:10
 */
@Data
public class CouponExchangeParam {

    @NotNull
    @ApiModelProperty(value = "优惠券编号")
    Long couponTypeID;

    @NotEmpty
    @ApiModelProperty(value = "用户编号")
    String businessNo;

    public CouponExchangeParam(@NotNull Long couponTypeID, @NotEmpty String businessNo) {
        this.couponTypeID = couponTypeID;
        this.businessNo = businessNo;
    }

    public CouponExchangeParam() {
    }
}
