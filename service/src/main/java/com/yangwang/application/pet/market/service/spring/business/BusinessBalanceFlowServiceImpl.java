package com.yangwang.application.pet.market.service.spring.business;

import com.yangwang.application.pet.market.common.enums.BalanceFlowTypeEnum;
import com.yangwang.application.pet.market.dao.business.BusinessBalanceFlowMapper;
import com.yangwang.application.pet.market.model.business.Business;
import com.yangwang.application.pet.market.model.business.BusinessBalance;
import com.yangwang.application.pet.market.model.business.BusinessBalanceFlow;
import com.yangwang.application.pet.market.service.facade.business.BusinessBalanceFlowService;
import com.yangwang.application.pet.market.service.facade.business.BusinessBalanceService;
import com.yangwang.sysframework.utils.DateUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 商家余额流水
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className BusinessBalanceFlowServiceImpl
 * @date 2019/12/30 11:11
 **/
@Service
public class BusinessBalanceFlowServiceImpl implements BusinessBalanceFlowService {
    @Resource
    BusinessBalanceFlowMapper businessBalanceFlowMapper;

    @Resource
    BusinessBalanceService businessBalanceService;

    @Override
    public int save(Business business, BigDecimal amount, String billNo, String linkNo, BalanceFlowTypeEnum balanceFlowTypeEnum) {
        // 获取商家余额
        BusinessBalance businessBalance = businessBalanceService.getByBusinessNo(business.getBusinessNo());

        BusinessBalanceFlow businessBalanceFlow = new BusinessBalanceFlow();
        businessBalanceFlow.setBalance(businessBalance == null ? BigDecimal.ZERO : businessBalance.getTotalAmount());
        businessBalanceFlow.setBusiness(business);
        businessBalanceFlow.setDateTime(DateUtil.formatFull(new Date()));
        businessBalanceFlow.setFlowType(balanceFlowTypeEnum.getType());
        businessBalanceFlow.setFlowAmount(amount);
        businessBalanceFlow.setLinkNo(linkNo);
        businessBalanceFlow.setBillNo(billNo);

        return businessBalanceFlowMapper.save(businessBalanceFlow);
    }

    @Override
    public List<BusinessBalanceFlow> listByBusiness(String businessNo, int offset, int limit) {
        return businessBalanceFlowMapper.listByStationNo(businessNo, offset, limit);
    }
}
