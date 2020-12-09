package com.yangwang.application.pet.market.model.service;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 服务分类
 * @Description
 * @Author Administrator
 * @Date 2020-03-20 21:53
 * @Version 1.0
 */
@Data
@ApiModel(value = "服务分类")
public class ServiceType {

    @ApiModelProperty(value = "服务分类的主键")
    long serviceTypeNo;

    @ApiModelProperty(value = "服务分类的名称")
    String serviceTypeName;

    @ApiModelProperty(value = "服务分类的图标")
    String icon;

    @ApiModelProperty(value = "子服务列表")
    List<ServiceType> child;

    @ApiModelProperty(value = "下面的服务")
    List<Service> services;
}
