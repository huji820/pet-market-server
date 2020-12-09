package com.yangwang.application.pet.market.model.vo;

import com.yangwang.application.pet.market.model.common.InitiateRefund;
import com.yangwang.application.pet.market.model.common.InitiateRefundImg;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @program: trunk
 * @description:
 * @author: lsy
 * @create: 2019-12-06 :
 **/
@Data
@ApiModel
public class InitiateRefundVo extends InitiateRefund {


    @ApiModelProperty(value = "退款图片")
    List<InitiateRefundImg> initiateRefundImgs;

}
