package com.yangwang.application.pet.market.model.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

/**
 * @program: trunk
 * @description: 退货图片
 * @author: lsy
 * @create: 2019-12-06 :
 **/
@Data
@ApiModel("退货图片")
public class InitiateRefundImg {
    @ApiModelProperty(value = "主键")
    String initiateRefundImgNo;


    @ApiModelProperty(value = "退款图片")
    String initiateRefundImg;

    @ApiModelProperty(value = "退款主键")
    String initiateRefundNo;
}
