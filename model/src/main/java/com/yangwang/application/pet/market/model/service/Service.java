package com.yangwang.application.pet.market.model.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.yangwang.application.pet.market.model.business.Business;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * 平台服务
 *
 * @Description
 * @Author Administrator
 * @Date 2020-03-20 21:53
 * @Version 1.0
 */
@Data
@ApiModel(value = "平台服务")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Service {
    @ApiModelProperty(value = "服务主键")
    Long serviceID;

    @ApiModelProperty(value = "服务分类")
    ServiceType serviceType;

    @ApiModelProperty(value = "所属商家")
    Business business;

    @ApiModelProperty(value = "服务名称")
    String serviceName;

    @ApiModelProperty(value = "服务价格")
    BigDecimal servicePrice;

    @ApiModelProperty(value = "宠物价格类别")
    List<ServicePrice> prices;

    @ApiModelProperty(value = "宠物的现场图片")
    List<ServiceScenePic> pics;

    @ApiModelProperty(value = "评价集合")
    List<ServiceAppraise> serviceAppraises;

    @ApiModelProperty(value = "状态")
    Boolean state;

    public Service() {
    }

    public Service(long serviceID) {
        this.serviceID = serviceID;
    }
}
