package com.yangwang.application.pet.market.model.vo;

import com.yangwang.application.pet.market.model.business.Business;
import com.yangwang.application.pet.market.model.service.Beautician;
import com.yangwang.application.pet.market.model.service.ServiceType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @TODO
 * @Description
 * @Author Administrator
 * @Date 2020-03-26 15:40
 * @Version 1.0
 */
@Data
@ApiModel(value = "商家详情")
public class BusinessDetailVO extends Business {

    @ApiModelProperty(value = "门店拥有的服务类别")
    List<ServiceType> serverTypes;

    @ApiModelProperty(value = "美容师")
    List<Beautician> beauticians;
}
