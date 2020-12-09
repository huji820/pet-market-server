package com.yangwang.application.pet.market.common.enums;

/**
 * <p>
 * 商家收款账户类型
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className BusinessAccountTypeEnum
 * @date 2020/5/20 14:14
 **/
public enum BusinessAccountTypeEnum {
    /**
     * 支付宝
     */
    ALIPAY(1),
    /**
     * 微信
     */
    WECHAT(2),
    /**
     * 银行卡
     */
    BANK_CARD(3);

    int type;

    BusinessAccountTypeEnum(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }
}
