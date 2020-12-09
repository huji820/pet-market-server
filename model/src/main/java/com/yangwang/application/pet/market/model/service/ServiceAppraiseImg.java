package com.yangwang.application.pet.market.model.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.yangwang.application.pet.market.model.common.Customer;
import com.yangwang.application.pet.market.model.market.BaseAppraiseImg;
import com.yangwang.application.pet.market.model.market.ItemAppraise;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @TODO
 * @Description
 * @Author Administrator
 * @Date 2020-03-20 23:51
 * @Version 1.0
 */
@Data
@ApiModel(value = "服务评价图片")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ServiceAppraiseImg extends BaseAppraiseImg {

    @ApiModelProperty(value = "服务评价")
    ServiceAppraise serviceAppraise;
}
