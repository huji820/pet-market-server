package com.yangwang.application.pet.market.service.facade.assess;

import com.yangwang.application.pet.market.model.assess.AssessApply;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 申请评测
 * </p>
 *
 **/
public interface AssessApplyService {

    /**
     * 添加商品评测申请
     * @param businessNo
     * @param assessNo
     * @return
     */
    Integer save(String businessNo, Long assessNo);

    /**
     * 商家获取自己商品的评测申请
     * @param businessNo
     * @return
     */
    List<AssessApply> listByItemBusinessNo(String businessNo);

    /**
     * 更新评测回复状态
     * @param assessFeedBack
     * @return
     */
    int updateAssessFeedBack(int assessFeedBack, Long applyNo);

    /**
     * 通过申请人编号和评测编号获取申请评测信息
     * @param businessNo
     * @param assessNo
     * @return
     */
    AssessApply getByBusinessNoAndAssessNo(String businessNo, Long assessNo);


}
