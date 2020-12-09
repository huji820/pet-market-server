package com.yangwang.application.pet.market.model.params;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import java.math.BigDecimal;

/**
 * @author yang hituzi
 * @description 按经纬度搜寻服务商家
 * @date 2020年4月9日 11:43:59
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(value = "按经纬度搜寻服务商家")
public class QueryServiceBusinessParam extends BaseQueryParam{

    @Range(min = 73, max = 135)
    @ApiModelProperty(value = "经度")
    BigDecimal longitude;

    @Range(min = 4, max = 54)
    @ApiModelProperty(value = "纬度")
    BigDecimal latitude;

    @ApiModelProperty(value = "服务类型名称")
    String serviceTypeName;

    @ApiModelProperty(value = "服务类型编号")
    Integer serviceTypeNo;
}
