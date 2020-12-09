package com.yangwang.application.pet.market.model.common;

import com.yangwang.application.pet.market.model.business.Business;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * <p>
 * 收货地址
 * </p>
 *
 * @author LiuXiangLin
 * @date 15:39 2020/3/27
 **/
@Data
@ApiModel(value = "收货地址")
public class ReceivingAddress {
    @ApiModelProperty(value = "主键")
    Integer receivingNo;

    @ApiModelProperty(value = "用户")
    Business business;

    @ApiModelProperty(value = "收件人姓名")
    String contacts;

    @ApiModelProperty(value = "收件人电话")
    String phone;

    @ApiModelProperty(value = "省")
    String province;

    @ApiModelProperty(value = "市")
    String city;

    @ApiModelProperty(value = "县或者区")
    String county;

    @ApiModelProperty(value = "详细地址")
    String detailedAddress;

    @ApiModelProperty(value = "经度")
    Double longitude;

    @ApiModelProperty(value = "纬度")
    Double latitude;

    @ApiModelProperty(value = "是否默认收货地址(0:否;1:是)")
    Integer isDefault;
}
