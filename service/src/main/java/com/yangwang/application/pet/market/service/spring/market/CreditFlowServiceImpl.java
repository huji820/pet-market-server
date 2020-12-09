package com.yangwang.application.pet.market.service.spring.market;

import com.yangwang.application.pet.market.dao.market.CreditFlowMapper;
import com.yangwang.application.pet.market.model.market.CreditFlow;
import com.yangwang.application.pet.market.model.params.QueryCreditFlowParam;
import com.yangwang.application.pet.market.service.facade.market.CreditFlowService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * <p>
 * 积分流水
 * </p>
 *
 * @author LiuXiangLin
 * @date 11:37 2020/3/19
 **/
@Service
public class CreditFlowServiceImpl implements CreditFlowService {
    @Resource
    CreditFlowMapper creditFlowMapper;

    @Override
    public int save(CreditFlow creditFlow) {
        return creditFlowMapper.save(creditFlow);
    }

    @Override
    public List<CreditFlow> list(QueryCreditFlowParam queryCreditFlowParam) {
        return creditFlowMapper.list(queryCreditFlowParam);
    }
}
