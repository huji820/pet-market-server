package com.yangwang.application.pet.market.common.enums;

/**
 * 微信支付回调地址
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className WeChatPayCallBackEnum
 * @date 2019/10/29 15:13
 **/
public enum WeChatPayCallBackEnum {
    /**
     * 宠粮订单
     */
    ITEM_ORDER("/api/market/pay/callback/item/order/", "淘宠惠宠粮订单"),
    /**
     * 宠物订单
     */
    PET_ORDER("/api/market/pay/callback/pet/order/", "淘宠惠宠物订单"),

    /**
     * 保证金订单
     */
    BOND_ORDER("/api/market/pay/callback/bond/", "淘宠惠保证金订单"),

    /**
     * 服务订单
     */
    SERVICE_ORDER("/api/market/pay/callback/service/", "淘宠惠驿站服务订单");

    String callBackUrl;
    String paramBody;

    WeChatPayCallBackEnum(String callBackUrl, String paramBody) {
        this.callBackUrl = callBackUrl;
        this.paramBody = paramBody;
    }

    /**
     * 获取完整的回调地址
     *
     * @param localHost 本机地址
     * @param orderNo   订单编号
     * @return java.lang.String
     * @author LiuXiangLin
     * @date 15:37 2019/10/29
     **/
    public String getCompleteCallBackUrl(String localHost, String orderNo) {
        return localHost + callBackUrl + orderNo;
    }

    public String getParamBody() {
        return paramBody;
    }}
