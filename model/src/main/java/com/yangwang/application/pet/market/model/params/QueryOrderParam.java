package com.yangwang.application.pet.market.model.params;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 订单查询参数
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className QueryOrderParam
 * @date 2019/10/24 15:32
 **/
@Data
@ApiModel(description = "订单查询参数")
public class QueryOrderParam extends BaseQueryParam {
    @ApiModelProperty(value = "是否支付(0:未支付;1:已支付)")
    Integer paymentState;

    @ApiModelProperty(value = "发货状态(0:未支付;1:已发货)")
    Integer driverState;

    @ApiModelProperty(value = "收货状态(0:未支付;1:已发货)")
    Integer receiveState;

    @ApiModelProperty(value = "是否已经评价(0：未评价;1:已评价)")
    Integer evaluateState;

    @ApiModelProperty(value = "是否退款（0：未退款，1：退款中 2 ：退款完成）")
    Integer refundsState;

    public QueryOrderParam(Integer paymentState, Integer driverState, Integer receiveState, Integer evaluateState, Integer refundsState) {
        this.paymentState = paymentState;
        this.driverState = driverState;
        this.receiveState = receiveState;
        this.evaluateState = evaluateState;
        this.refundsState = refundsState;
    }
}
