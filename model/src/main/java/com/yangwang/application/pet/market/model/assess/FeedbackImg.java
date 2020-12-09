package com.yangwang.application.pet.market.model.assess;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @TODO
 * @Description
 * @Author Administrator
 * @Date 2020-05-17 15:34
 * @Version 1.0
 */
@ApiModel(value = "回复图片")
@Data
public class FeedbackImg {
    @ApiModelProperty(value = "图片主键")
    Long feedbackImgNo;

    @ApiModelProperty(value = "反馈")
    Feedback feedback;

    @ApiModelProperty(value = "图片地址")
    String fileAddress;

    @ApiModelProperty(value = "文件类型")
    String type;
}
