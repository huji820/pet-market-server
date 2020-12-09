package com.yangwang.application.pet.market.model.market;

import com.yangwang.application.pet.market.model.business.Business;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 评价
 * </p>
 *
 * @author LiuXiangLin
 * @date 10:03 2020/3/23
 **/
@Data
@ApiModel(value = "商家评价表")
public abstract class BaseAppraise {
    @ApiModelProperty(value = "评价主键")
    Integer appraiseNo;

    @ApiModelProperty(value = "评价用户")
    Business business;

    @ApiModelProperty(value = "1-5星好评，默认5星")
    Integer praiseDegree;

    @ApiModelProperty(value = "评价内容")
    String content;

    @ApiModelProperty(value = "评价日期")
    String appraiseDate;

    @ApiModelProperty(value = "被评价的商家")
    Business evaluatedBusiness;
}
