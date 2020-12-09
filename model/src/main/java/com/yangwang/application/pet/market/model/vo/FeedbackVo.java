package com.yangwang.application.pet.market.model.vo;

import com.yangwang.application.pet.market.model.assess.Feedback;
import com.yangwang.application.pet.market.model.assess.FeedbackImg;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className FeedbackVo
 * @date 2020/5/18 15:18
 **/
@Data
@ApiModel(description = "反馈VO对象")
public class FeedbackVo {
    @ApiModelProperty(value = "反馈对象")
    Feedback feedback;

    @ApiModelProperty(value = "图片列表")
    List<FeedbackImg> feedbackImgs;
}
