package com.yangwang.application.pet.market.service.spring.assess;

import com.yangwang.application.pet.market.dao.assess.AssessFeedbackImgMapper;
import com.yangwang.application.pet.market.dao.assess.AssessFeedbackMapper;
import com.yangwang.application.pet.market.model.assess.Assess;
import com.yangwang.application.pet.market.model.assess.AssessApply;
import com.yangwang.application.pet.market.model.assess.Feedback;
import com.yangwang.application.pet.market.model.assess.FeedbackImg;
import com.yangwang.application.pet.market.model.vo.FeedbackVo;
import com.yangwang.application.pet.market.service.facade.assess.AssessApplyService;
import com.yangwang.application.pet.market.service.facade.assess.AssessFeedbackService;
import com.yangwang.application.pet.market.service.facade.assess.AssessService;
import com.yangwang.application.pet.market.service.service.BusinessService;
import com.yangwang.sysframework.utils.DateUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className AssessFeedbackServiceImpl
 * @date 2020/5/18 15:47
 **/
@Service
public class AssessFeedbackServiceImpl implements AssessFeedbackService {
    @Resource
    AssessFeedbackMapper assessFeedbackMapper;

    @Resource
    AssessFeedbackImgMapper assessFeedbackImgMapper;

    @Resource
    AssessService assessService;

    @Resource
    AssessApplyService assessApplyService;

    @Resource
    BusinessService businessService;

    @Override
    public List<FeedbackVo> listByAssessNo(long assessNo, int offset, int limit) {
        return assessFeedbackMapper.listByAssessNo(assessNo, offset, limit);
    }

    @Override
    public int replyAssess(FeedbackVo feedbackVo) {
        //添加测评回复
        Feedback feedback = feedbackVo.getFeedback();
        Date now = new Date();
        String date = DateUtil.format(now, DateUtil.FORMAT_FULL);
        feedback.setCreateAt(date);
        feedback.setAdopted(false);
        assessFeedbackMapper.save(feedback);
        //添加测评回复图片
        List<FeedbackImg> feedbackImgs = feedbackVo.getFeedbackImgs();
        for(FeedbackImg feedbackImg : feedbackImgs){
            feedbackImg.setFeedback(feedback);
            assessFeedbackImgMapper.save(feedbackImg);
        }
        //获取测评回复奖励积分
        Assess assess = assessService.getByAssessNo(feedback.getAssess().getAssessNo());
        businessService.updateCreditAdd(feedback.getBusiness().getBusinessNo(), assess.getCredit());

        //获取申请评测信息
        AssessApply assessApply = assessApplyService.getByBusinessNoAndAssessNo(feedback.getBusiness().getBusinessNo(), feedback.getAssess().getAssessNo());
        //更新测评回复状态
        assessApplyService.updateAssessFeedBack(1,assessApply.getApplyNo());
        return 1;
    }

    @Override
    public int adoptOrCancelAdoptApply(Long feedbackNo, boolean isAdopted) {
        int i = assessFeedbackMapper.adoptOrCancelAdoptApply(feedbackNo, isAdopted);
        return i;
    }
}
