package com.yangwang.application.pet.market.common.enums;

public enum VerifyCodeEnum {

    INVALID_CODE(1001,"无效的核销码!"),
    DISABLED_COUPON(1002,"优惠券已失效!"),
    USED_COUPON(1003,"优惠券已使用!");

    int errorCode;
    String errorMsg;

    VerifyCodeEnum(int errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
