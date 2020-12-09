package com.yangwang.application.pet.market.model.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.yangwang.application.pet.market.model.business.Business;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @TODO
 * @Description
 * @Author Administrator
 * @Date 2020-03-23 20:45
 * @Version 1.0
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class NearBusinessVO {
    @ApiModelProperty(value = "商家")
    Business business;

    @ApiModelProperty(value = "距离")
    BigDecimal distance;
}
