package com.yangwang.application.pet.market.service.facade.business;

import com.yangwang.application.pet.market.model.business.BusinessBalanceFlow;

public interface BusinessDepositFlowService {

    /**
     * 插入顾客余额变动流水
     * @param businessBalanceFlow
     * @return
     */
    int insertBusinessBalanceFlow(BusinessBalanceFlow businessBalanceFlow);
}
