package com.yangwang.application.pet.market.common.enums;

/**
 * @ClassName SMSTemplateTypeEnum
 * @Description 模板枚举
 * @Author LiuXiangLin
 * @Date 2019/7/19 11:25
 * @Version 1.0
 **/

public enum SMSTemplateTypeEnum {
    /***/
    SENDER_CONFIRM_TEMPLATE("确认收货发货人短息消息模板", "182833"),
    PLACE_ORDER_CUSTOMER_TEMPLATE("下单之后收件人以及发件人短信模板", "185246"),
    PLACE_ORDER_STATION_TEMPLATE("下单之后站点短信模板", "185236"),
    ADDRESSEE_IN_PORT_TEMPLATE("入港之后收件人短信模板", "182832"),
    START_STATION_TEMPLATE("起始站点消息模板", ""),
    END_STATION_TEMPLATE("目标站点消息模板", ""),
    COUPON_TEMPLATE("优惠券模板", "182882"),
    BUSINESS_VERIFICATION_CODE("商家注册", "187629"),
    SALES_TIPS_CODE("商品售出提示","SMS_198345154"),
    SALES_STIPS_CODE("商品售出提示2","SMS_198340344"),
    WITHDRAWAL_CODE("提现","SMS_198340345");

    String describe;
    String templateId;

    SMSTemplateTypeEnum(String describe, String templateId) {
        this.describe = describe;
        this.templateId = templateId;
    }

    public String getDescribe() {
        return describe;
    }

    public String getTemplateId() {
        return templateId;
    }}
