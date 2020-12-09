package com.yangwang.application.pet.market.common.enums;

/**
 * 平台交易类型枚举
 */
public enum PlatformTradeEnum {
    /***/
    PET(1, "宠物"),
    ITEM(2, "商品"),
    SERVICE(3, "服务");

    int code;
    String msg;

    PlatformTradeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }}
