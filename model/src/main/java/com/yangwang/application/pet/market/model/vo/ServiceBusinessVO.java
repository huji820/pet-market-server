package com.yangwang.application.pet.market.model.vo;

import com.yangwang.application.pet.market.model.business.Business;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author yang hituzi
 * @description 服务的商家列表
 * @date 2020年4月9日 10:03:42
 */
@Data
@ApiModel(value = "拥有该服务的商家VO")
public class ServiceBusinessVO {

    @ApiModelProperty(value = "商家编号")
    String businessNo;

    @ApiModelProperty(value = "商家名称")
    String businessName;

    @ApiModelProperty(value = "起始营业时间")
    String startHours;

    @ApiModelProperty(value = "结束营业时间")
    String endHours;

    @ApiModelProperty(value = "联系人电话")
    String contactPhone;

    @ApiModelProperty(value = "省")
    String province;

    @ApiModelProperty(value = "市")
    String city;

    @ApiModelProperty(value = "区")
    String area;

    @ApiModelProperty(value = "详细地址")
    String detailAddress;

    @ApiModelProperty(value = "头像")
    String headImg;

    @ApiModelProperty(value = "距离")
    BigDecimal distance;

    @ApiModelProperty(value = "服务名称")
    List<String> serviceNameList;
}