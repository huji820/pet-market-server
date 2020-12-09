package com.yangwang.application.pet.market.common.enums;

public enum MessageTypeEnum {

    COMMODITY_NEW(1,"关注店铺上新"),
    COMMODITY_SOLD(2,"关注商品售出"),
    COMMODITY_REMOVE(3,"关注商品下架"),
    //提示商家
    COMMODITY_SALESTIPS(4,"商品售出提示");

    Integer type;
    String typeMsg;

    MessageTypeEnum(Integer type, String typeMsg) {
        this.type = type;
        this.typeMsg = typeMsg;
    }

    public Integer getType() {
        return type;
    }

    public String getTypeMsg() {
        return typeMsg;
    }

    public static String getMsgByType(Integer messageType){
        String msg;
        switch(messageType){
            case 1:
                msg = MessageTypeEnum.COMMODITY_NEW.getTypeMsg();
            break;

            case 2:
                msg = MessageTypeEnum.COMMODITY_SOLD.getTypeMsg();
            break;

            case 3:
                msg = MessageTypeEnum.COMMODITY_REMOVE.getTypeMsg();
            break;

            case 4:
                msg = MessageTypeEnum.COMMODITY_SALESTIPS.getTypeMsg();
                break;
            default:
                msg = null;
        }
        return msg;
    }
}
