package com.yangwang.application.pet.market.service.spring.business;

import com.yangwang.application.pet.market.common.enums.BalanceFlowTypeEnum;
import com.yangwang.application.pet.market.dao.business.BusinessBalanceMapper;
import com.yangwang.application.pet.market.model.business.Business;
import com.yangwang.application.pet.market.model.business.BusinessBalance;
import com.yangwang.application.pet.market.model.market.BaseOrder;
import com.yangwang.application.pet.market.service.facade.business.BusinessBalanceFlowService;
import com.yangwang.application.pet.market.service.facade.business.BusinessBalanceService;
import com.yangwang.sysframework.utils.DateUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author LiuXiangLin
 * @version 1.0
 * @className BusinessBalanceServiceImpl
 * @description
 * @date 2019/10/12 16:38
 **/
@Service
public class BusinessBalanceServiceImpl implements BusinessBalanceService {
    @Resource
    BusinessBalanceMapper businessBalanceMapper;

    @Resource
    BusinessBalanceFlowService businessBalanceFlowService;

    @Override
    public int saveOrUpdate(BusinessBalance businessBalance) {
        return businessBalanceMapper.saveOrUpdateRebate(businessBalance);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int saveRebateAmount(String billNo,
                                Business business,
                                BigDecimal amount) {
        // 修改余额
        businessBalanceMapper.saveOrUpdateRebate(getBusinessRebate(business, amount));

        // 余额流水
        businessBalanceFlowService.save(business, amount, billNo, null, BalanceFlowTypeEnum.MARKET);

        return 1;
    }

    @Override
    public BusinessBalance getByBusinessNo(String businessNo) {
        return businessBalanceMapper.getByBusinessNo(businessNo);
    }

    @Override
    public int subtract(String businessNo, BigDecimal amount) {
        return businessBalanceMapper.subtractAmount(businessNo, amount);
    }

    /**
     * @param business , rebateAmount
     * @return com.jxywkj.application.pet.model.business.BusinessBalance
     * @author LiuXiangLin
     * @description 获取返利对象
     * @date 17:41 2019/10/12
     **/
    private BusinessBalance getBusinessRebate(Business business, BigDecimal rebateAmount) {
        BusinessBalance result = new BusinessBalance();

        result.setBusinessNo(business.getBusinessNo());
        result.setLastRebateAmount(rebateAmount);
        result.setLastRebateTime(DateUtil.format(new Date(), DateUtil.FORMAT_FULL));

        return result;
    }
}
