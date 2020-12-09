package com.yangwang.application.pet.market.dao.assess;

import com.yangwang.application.pet.market.model.assess.Feedback;
import com.yangwang.application.pet.market.model.assess.FeedbackImg;
import com.yangwang.application.pet.market.model.vo.FeedbackVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 评测反馈图片
 * </p>
 *
 **/
@Mapper
public interface AssessFeedbackImgMapper {

    int save(@Param("feedbackImg")FeedbackImg feedbackImg);
}
