package com.yangwang.application.pet.market.model.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.yangwang.application.pet.market.model.business.Business;
import com.yangwang.application.pet.market.model.common.Customer;
import com.yangwang.application.pet.market.model.market.BaseAppraise;
import com.yangwang.application.pet.market.model.market.ServiceOrder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @TODO
 * @Description
 * @Author Administrator
 * @Date 2020-03-20 23:51
 * @Version 1.0
 */
@Data
@ApiModel(value = "评价")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ServiceAppraise extends BaseAppraise {

    @ApiModelProperty(value = "服务")
    Service service;

    @ApiModelProperty(value = "服务单据")
    ServiceOrder serviceOrder;
}
