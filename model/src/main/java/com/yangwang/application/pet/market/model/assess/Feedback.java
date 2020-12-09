package com.yangwang.application.pet.market.model.assess;

import com.yangwang.application.pet.market.model.business.Business;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

/**
 * @TODO
 * @Description
 * @Author Administrator
 * @Date 2020-05-17 15:20
 * @Version 1.0
 */
@ApiModel(value = "回复")
@Data
public class Feedback {
    @ApiModelProperty("回复的主键")
    Long feedbackNo;

    @ApiModelProperty(value = "测评对象")
    Assess assess;

    @ApiModelProperty("标题")
    String title;

    @ApiModelProperty("创建时间")
    String createAt;

    @ApiModelProperty("反馈内容")
    String content;

    @ApiModelProperty("商家对象")
    Business business;

    @ApiModelProperty("是否采纳")
    boolean adopted;
}
