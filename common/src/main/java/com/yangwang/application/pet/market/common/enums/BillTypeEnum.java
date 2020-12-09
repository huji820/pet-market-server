package com.yangwang.application.pet.market.common.enums;

/**
 * 单据类型枚举
 */
public enum BillTypeEnum {
    /***/
    ITEM_ORDER(101, "商品订单"),
    PET_ORDER(201, "宠物订单"),
    SERVICE_ORDER(301, "服务订单订单");

    int billType;

    String description;

    BillTypeEnum() {
    }

    BillTypeEnum(int billType, String description) {
        this.billType = billType;
        this.description = description;
    }

    public int getBillType() {
        return billType;
    }

    public void setBillType(int billType) {
        this.billType = billType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static BillTypeEnum filter(String startOrderNum) {
        int orderNo = Integer.parseInt(startOrderNum);

        if (orderNo == ITEM_ORDER.getBillType()) {
            return ITEM_ORDER;
        }
        if (orderNo == PET_ORDER.getBillType()) {
            return PET_ORDER;
        }
        if (orderNo == SERVICE_ORDER.getBillType()) {
            return SERVICE_ORDER;
        }
        return null;
    }
}
