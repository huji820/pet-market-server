package com.yangwang.application.pet.market.common.enums;

/**
 * <p>
 * 上架状态
 * </p>
 *
 * @author LiuXiangLin
 * @date 9:40 2020/3/13
 **/
public enum OnSaleStateEnum {
    /**
     * 已上架
     */
    FOR_SALE(1),
    /**
     * 已下架
     */
    OFF_SALE(0);

    int type;

    OnSaleStateEnum(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public static OnSaleStateEnum filter(int type) {
        if (type == FOR_SALE.type) {
            return FOR_SALE;
        }
        if (type == OFF_SALE.type) {
            return OFF_SALE;
        }
        return null;
    }

}
