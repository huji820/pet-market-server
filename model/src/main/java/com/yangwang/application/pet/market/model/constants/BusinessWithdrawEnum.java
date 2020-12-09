package com.yangwang.application.pet.market.model.constants;

public enum BusinessWithdrawEnum {

    TO_BE_AUDITED("待审核", "待审核"),
    AUDITED("已审核", "已审核"),
    COMPLETED("已完成", "已完成");

    String state;
    String describe;

    BusinessWithdrawEnum(String state, String describe) {
        this.state = state;
        this.describe = describe;
    }

    public String getState() {
        return state;
    }

    public String getDescribe() {
        return describe;
    }
}
