package com.yangwang.application.pet.market.service.spring.business;

import com.yangwang.application.pet.market.dao.business.BusinessAccountMapper;
import com.yangwang.application.pet.market.model.business.BusinessAccount;
import com.yangwang.application.pet.market.service.facade.business.BusinessAccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className BusinessAccountServiceImpl
 * @date 2020/5/20 14:01
 **/
@Service
public class BusinessAccountServiceImpl implements BusinessAccountService {
    @Resource
    BusinessAccountMapper businessAccountMapper;

    @Override
    public int save(BusinessAccount businessAccount) {
        return businessAccountMapper.save(businessAccount);
    }

    @Override
    public List<BusinessAccount> listByBusinessNo(String businessNo) {
        return businessAccountMapper.listByBusinessNo(businessNo);
    }

    @Override
    public int delete(long accountNo) {
        return businessAccountMapper.delete(accountNo);
    }
}
