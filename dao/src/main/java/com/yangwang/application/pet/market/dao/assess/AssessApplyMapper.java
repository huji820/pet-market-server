package com.yangwang.application.pet.market.dao.assess;

import com.yangwang.application.pet.market.model.assess.AssessApply;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 申请评测Mapper
 * </p>
 *
 **/
@Mapper
public interface AssessApplyMapper {

    /**
     * 添加商品评测申请
     * @param assessApply
     * @return
     */
    Integer save(@Param("assessApply")AssessApply assessApply);

    /**
     * 商家获取自己商品的评测申请
     * @param businessNo
     * @return
     */
    List<AssessApply> listByItemBusinessNo(@Param("businessNo")String businessNo);

    /**
     * 更新评测回复状态
     * @param assessFeedBack
     * @return
     */
    int updateAssessFeedBack(@Param("assessFeedBack")int assessFeedBack,@Param("applyNo")Long applyNo);

    /**
     * 通过申请人编号和评测编号获取申请评测信息
     * @param businessNo
     * @param assessNo
     * @return
     */
    AssessApply getByBusinessNoAndAssessNo(@Param("businessNo")String businessNo,@Param("assessNo")Long assessNo);
}
