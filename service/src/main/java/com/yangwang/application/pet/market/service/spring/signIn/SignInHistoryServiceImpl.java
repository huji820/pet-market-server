package com.yangwang.application.pet.market.service.spring.signIn;

import com.yangwang.application.pet.market.dao.market.signIn.SignInHistoryMapper;
import com.yangwang.application.pet.market.model.common.signIn.SignInHistory;
import com.yangwang.application.pet.market.service.facade.signIn.SignInHistoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 签到记录实现类
 */
@Service
public class SignInHistoryServiceImpl implements SignInHistoryService{

    @Resource
    SignInHistoryMapper signInHistoryMapper;

    @Override
    public int save(SignInHistory signInHistory) {
        return signInHistoryMapper.save(signInHistory);
    }

    @Override
    public List<SignInHistory> listByBusinessNo(String businessNo) {
        return signInHistoryMapper.listByBusinessNo(businessNo);
    }

    @Override
    public SignInHistory getLastByBusinessNo(String businessNo) {
        return signInHistoryMapper.getLastByBusinessNo(businessNo);
    }
}
