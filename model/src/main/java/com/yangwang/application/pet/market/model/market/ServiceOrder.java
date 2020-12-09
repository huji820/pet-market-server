package com.yangwang.application.pet.market.model.market;

import com.yangwang.application.pet.market.model.service.Beautician;
import com.yangwang.application.pet.market.model.service.Service;
import com.yangwang.application.pet.market.model.service.ServicePrice;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * 宠物订单
 * @author LiuXiangLin
 * @version 1.0
 * @className PetOrder
 * @date 2019/10/24 15:14
 **/
@Data
@ApiModel(value = "商家服务订单表")
public class ServiceOrder extends BaseOrder {

    @ApiModelProperty(value = "预约的服务")
    Service service;

    @ApiModelProperty(value = "美容师")
    Beautician beautician;

    @ApiModelProperty(value = "预约时间")
    String visitorTime;

    @ApiModelProperty(value = "验收状态")
    Integer verifyState;

    @ApiModelProperty(value = "宠物价格")
    ServicePrice servicePrice;
}
