package com.yangwang.application.pet.market.service.facade.assess;

import com.yangwang.application.pet.market.model.vo.FeedbackVo;

import java.util.List;

/**
 * <p>
 * 测评反馈
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className AssessFeedbackService
 * @date 2020/5/18 15:45
 **/
public interface AssessFeedbackService {
    /**
     * <p>
     * 通过测评主键获取反馈列表
     * </p>
     *
     * @param assessNo 测评列表
     * @param offset   排除条数
     * @param limit    显示条数
     * @return java.util.List<com.yangwang.application.pet.market.model.vo.FeedbackVo>
     * @author LiuXiangLin
     * @date 15:46 2020/5/18
     **/
    List<FeedbackVo> listByAssessNo(long assessNo, int offset, int limit);

    /**
     * 测评回复
     * @param feedbackVo
     * @return
     */
    int replyAssess(FeedbackVo feedbackVo);

    /**
     * 采纳或取消采纳测评回复
     * @param feedbackNo
     * @return
     */
    int adoptOrCancelAdoptApply(Long feedbackNo, boolean isAdopted);
}
