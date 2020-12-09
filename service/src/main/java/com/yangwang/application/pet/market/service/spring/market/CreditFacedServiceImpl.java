package com.yangwang.application.pet.market.service.spring.market;

import com.yangwang.application.pet.market.model.business.Business;
import com.yangwang.application.pet.market.model.market.CreditFlow;
import com.yangwang.application.pet.market.service.facade.market.CreditFacedService;
import com.yangwang.application.pet.market.service.facade.market.CreditFlowService;
import com.yangwang.application.pet.market.service.service.BusinessService;
import com.yangwang.sysframework.utils.DateUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className CreditFacedServiceImpl
 * @date 2020/4/2 13:49
 **/
@Service
public class CreditFacedServiceImpl implements CreditFacedService {
    @Resource
    BusinessService businessService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int addCredit(String businessNo, int credit) {
        Business business = businessService.getByBusinessNoWithOutState(businessNo);
        if (business == null) {
            throw new RuntimeException("用户不存在");
        }

        // 修改商家积分
        businessService.updateCreditAdd(businessNo, credit);

        // 添加流水
        CreditFlow creditFlow = new CreditFlow();
        creditFlow.setBusiness(business);
        creditFlow.setDateTime(DateUtil.formatFull(new Date()));
        creditFlow.setCredit(credit);
        creditFlow.setTotalCredit(credit + business.getCredit());

        return 0;
    }
}
