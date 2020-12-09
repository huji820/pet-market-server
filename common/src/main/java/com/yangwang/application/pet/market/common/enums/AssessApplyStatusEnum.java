package com.yangwang.application.pet.market.common.enums;

/**
 * @Description 测评申请状态枚举
 * @Param
 * @return
 **/
public enum AssessApplyStatusEnum {
    /**
     * 正常 未审核 正常
     */
    APPLY_WAIT_REPLY(1, "已申请,等待活动商家批复"),
    APPLY_PASS(2, "申请通过"),
    APPLY_FAILED(3, "申请被拒绝");


    private int type;
    private String describe;

    AssessApplyStatusEnum(int type, String describe) {
        this.type = type;
        this.describe = describe;
    }

    public int getType() {
        return type;
    }

    public String getDescribe() {
        return describe;
    }
}

