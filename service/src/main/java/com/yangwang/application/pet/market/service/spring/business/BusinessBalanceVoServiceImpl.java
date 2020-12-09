package com.yangwang.application.pet.market.service.spring.business;

import com.yangwang.application.pet.market.dao.business.BusinessBalanceVoMapper;
import com.yangwang.application.pet.market.model.business.BusinessBalanceFlowVo;
import com.yangwang.application.pet.market.model.params.QueryBusinessBalanceVoParam;
import com.yangwang.application.pet.market.service.facade.business.BusinessBalanceVoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 商家流水VO
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className BusinessBalanceVoServiceImpl
 * @date 2020/4/2 12:00
 **/
@Service
public class BusinessBalanceVoServiceImpl implements BusinessBalanceVoService {
    @Resource
    BusinessBalanceVoMapper businessBalanceVoMapper;

    @Override
    public List<BusinessBalanceFlowVo> listByParam(QueryBusinessBalanceVoParam queryBusinessBalanceVoParam) {
        return businessBalanceVoMapper.listByParam(queryBusinessBalanceVoParam);
    }
}
