package com.yangwang.application.pet.market.model.params;

import com.yangwang.application.pet.market.common.enums.OrderStateEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 宠物查询对象
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className QueryOrderListParam
 * @date 2020/3/31 15:23
 **/
@Data
public class QueryOrderListParam extends BaseQueryParam {
    @ApiModelProperty(value = "支付状态")
    Integer paymentState;

    @ApiModelProperty(value = "发货状态")
    Integer driverState;

    @ApiModelProperty(value = "收货状态")
    Integer receiveState;

    @ApiModelProperty(value = "评价状态")
    Integer evaluateState;

    @ApiModelProperty(value = "退款状态")
    Integer refundsState;

    @ApiModelProperty(value = "购买人")
    String buyerNo;

    @ApiModelProperty(value = "店铺编号")
    String shopNo;

    public QueryOrderListParam() {
    }

    public QueryOrderListParam(Integer paymentState, Integer driverState, Integer receiveState, Integer evaluateState, Integer refundsState) {
        this.paymentState = paymentState;
        this.driverState = driverState;
        this.receiveState = receiveState;
        this.evaluateState = evaluateState;
        this.refundsState = refundsState;
    }

    /**
     * 待支付
     */
    public static QueryOrderListParam getNonPayment() {
        return new QueryOrderListParam(OrderStateEnum.PAY_UNPAID.getState(), null, null, null, null);
    }

    /**
     * 待发货
     */
    public static QueryOrderListParam getToBeDelivered() {
        return new QueryOrderListParam(OrderStateEnum.PAY_PAID.getState(), OrderStateEnum.DRIVER_UN_DRIVER.getState(), null, null, null);
    }

    /**
     * 待收货
     */
    public static QueryOrderListParam getToBeReceived() {
        return new QueryOrderListParam(OrderStateEnum.PAY_PAID.getState(), OrderStateEnum.RECEIVE_RECEIVED.getState(), OrderStateEnum.RECEIVE_UN_RECEIVE.getState(), null, null);
    }

    /**
     * 待评价
     */
    public static QueryOrderListParam getToBeEvaluated() {
        return new QueryOrderListParam(OrderStateEnum.PAY_PAID.getState(), OrderStateEnum.DRIVER_DRIVERED.getState(), OrderStateEnum.RECEIVE_RECEIVED.getState(), OrderStateEnum.EVALUATE_UN_EVALUATE.getState(), null);
    }


}
