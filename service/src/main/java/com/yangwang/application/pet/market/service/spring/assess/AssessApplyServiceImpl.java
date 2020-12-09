package com.yangwang.application.pet.market.service.spring.assess;

import com.yangwang.application.pet.market.common.enums.AssessApplyStatusEnum;
import com.yangwang.application.pet.market.dao.assess.AssessApplyMapper;
import com.yangwang.application.pet.market.model.assess.Assess;
import com.yangwang.application.pet.market.model.assess.AssessApply;
import com.yangwang.application.pet.market.model.business.Business;
import com.yangwang.application.pet.market.service.facade.assess.AssessApplyService;
import com.yangwang.sysframework.utils.DateUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 申请评测
 * </p>
 *
 **/
@Service
public class AssessApplyServiceImpl implements AssessApplyService {

    @Resource
    AssessApplyMapper assessApplyMapper;

    @Override
    public Integer save(String businessNo, Long assessNo) {
        return assessApplyMapper.save(getAssessApply(businessNo, assessNo));
    }

    @Override
    public List<AssessApply> listByItemBusinessNo(String businessNo) {
        return assessApplyMapper.listByItemBusinessNo(businessNo);
    }

    @Override
    public int updateAssessFeedBack(int assessFeedBack, Long applyNo) {
        return assessApplyMapper.updateAssessFeedBack(assessFeedBack,applyNo);
    }

    @Override
    public AssessApply getByBusinessNoAndAssessNo(String businessNo, Long assessNo) {
        return assessApplyMapper.getByBusinessNoAndAssessNo(businessNo, assessNo);
    }


    private AssessApply getAssessApply(String businessNo,Long assessNo){
        Business business = new Business();
        business.setBusinessNo(businessNo);
        Assess assess = new Assess();
        assess.setAssessNo(assessNo);
        //获取时间
        Date now = new Date();
        String date = DateUtil.format(now, DateUtil.FORMAT_FULL);
        return new AssessApply(null, business, assess, date, AssessApplyStatusEnum.APPLY_WAIT_REPLY.getType(),false);
    }
}
