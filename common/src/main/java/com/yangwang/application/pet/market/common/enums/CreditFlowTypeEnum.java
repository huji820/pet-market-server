package com.yangwang.application.pet.market.common.enums;

/**
 * 
 *
 * 积分流水类型枚举
 * @return 
 * @author yang hituzi
 * @date 11:48 2020/4/8
 */
public enum CreditFlowTypeEnum {

    COUPON_EXCHANGE("优惠券兑换");

    String creditFlowType;

    CreditFlowTypeEnum(String creditFlowType) {
        this.creditFlowType = creditFlowType;
    }

    public String getCreditFlowType() {
        return creditFlowType;
    }
}
