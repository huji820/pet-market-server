package com.yangwang.application.pet.market.dao.business;

import com.yangwang.application.pet.market.model.business.BusinessBalanceFlowVo;
import com.yangwang.application.pet.market.model.params.QueryBusinessBalanceVoParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 商家流水vo
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className BusinessBalanceVoMapper
 * @date 2020/4/2 10:38
 **/
public interface BusinessBalanceVoMapper {
    /**
     * <p>
     * 通过参数查询流水
     * </p>
     *
     * @param queryBusinessBalanceVoParam 查询参数对象
     * @return java.util.List<com.yangwang.application.pet.market.model.business.BusinessBalanceVo>
     * @author LiuXiangLin
     * @date 10:44 2020/4/2
     **/
    List<BusinessBalanceFlowVo> listByParam(@Param("queryBusinessBalanceVoParam") QueryBusinessBalanceVoParam queryBusinessBalanceVoParam);
}
