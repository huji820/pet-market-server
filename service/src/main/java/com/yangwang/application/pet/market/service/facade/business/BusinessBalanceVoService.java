package com.yangwang.application.pet.market.service.facade.business;

import com.yangwang.application.pet.market.model.business.BusinessBalanceFlowVo;
import com.yangwang.application.pet.market.model.params.QueryBusinessBalanceVoParam;

import java.util.List;

/**
 * <p>
 * 商家余额流水vo
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className BusinessBalanceVoService
 * @date 2020/4/2 12:00
 **/
public interface BusinessBalanceVoService {
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
    List<BusinessBalanceFlowVo> listByParam(QueryBusinessBalanceVoParam queryBusinessBalanceVoParam);
}
