package com.yangwang.application.pet.market.common.enums;

/**
 * 订单状态枚举
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className OrderStateEnum
 * @date 2019/10/23 18:53
 **/
public enum OrderStateEnum {
    /**未支付*/
    PAY_UNPAID(0,"未支付"),
    /**已支付*/
    PAY_PAID(1,"已支付"),
    /**取消支付*/
    PAY_CANCEL(-1,"订单取消"),
    /**未发货*/
    DRIVER_UN_DRIVER(0,"未发货"),
    /**已发货*/
    DRIVER_DRIVERED(1,"已发货"),
    /**待收货*/
    RECEIVE_UN_RECEIVE(0,"待收货"),
    /**已收货*/
    RECEIVE_RECEIVED(1,"已收货"),
    /**未评价*/
    EVALUATE_UN_EVALUATE(0,"未评价"),
    /**已评价*/
    EVALUATE_EVALUATED(1,"已评价"),
    /**未触发退款*/
    REFUNDS_UN_REFUNDS(0,"未退款"),
    /**退款中*/
    REFUNDS_REFUNDSING(1,"退款中"),
    /***退款完成*/
    REFUNDS_REFUNDS(2,"退款完成"),
    /***退款失败*/
    REFUNDS_FAILURE(-1,"退款失败");

    int state;
    String describe;

    OrderStateEnum(int state,String describe){
        this.state = state;
        this.describe = describe;
    }

    public int getState() {
        return state;
    }

    public String getDescribe() {
        return describe;
    }}
