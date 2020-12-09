package com.yangwang.application.pet.market.model.business;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * <p>
 *    厂家和分仓关联实体类
 * </p>
 *
 * @Author zhouxiaojian
 * @Date 2020/8/21 15:27
 * @Version 1.0
 */
@Data
@ApiModel("厂家和分仓关联实体类")
public class SupplyRelation {

    @ApiModelProperty("关联主键")
    Integer relationNo;

    @ApiModelProperty("厂家")
    Business manufactor;

    @ApiModelProperty("分仓")
    List<Business> subWarehouse;


}
