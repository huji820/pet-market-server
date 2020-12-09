package com.yangwang.application.pet.market.dao.assess;

import com.yangwang.application.pet.market.model.assess.Feedback;
import com.yangwang.application.pet.market.model.vo.FeedbackVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 评测反馈
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className AssessFeedbackMapper
 * @date 2020/5/18 15:06
 **/
public interface AssessFeedbackMapper {

    /**
     * 发布评测回复
     * @param feedback
     * @return
     */
   int save(Feedback feedback);

    /**
     * <p>
     * 通过测评主键获取测评列表
     * </p>
     *
     * @param assessNo 测评主键
     * @param limit    排除条数
     * @param offset   显示条数
     * @return java.util.List<com.yangwang.application.pet.market.model.assess.Feedback>
     * @author LiuXiangLin
     * @date 15:08 2020/5/18
     **/
    List<FeedbackVo> listByAssessNo(@Param("assessNo") long assessNo, @Param("offset") int offset, @Param("limit") int limit);

    /**
     * 采纳或取消采纳测评回复
     * @param feedbackNo
     * @param isAdopted
     * @return
     */
    int adoptOrCancelAdoptApply(@Param("feedbackNo")Long feedbackNo,
                         @Param("isAdopted")boolean isAdopted);
}
