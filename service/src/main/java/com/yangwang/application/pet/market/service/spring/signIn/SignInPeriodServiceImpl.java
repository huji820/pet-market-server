package com.yangwang.application.pet.market.service.spring.signIn;

import com.yangwang.application.pet.market.dao.market.signIn.SignInPeriodMapper;
import com.yangwang.application.pet.market.model.common.signIn.SignInPeriod;
import com.yangwang.application.pet.market.service.facade.signIn.SignInPeriodService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 签到周期实现类
 * @Date 2020/08/20
 */
@Service
public class SignInPeriodServiceImpl implements SignInPeriodService {

    @Resource
    SignInPeriodMapper signInPeriodMapper;

    @Override
    public int countList() {
        return signInPeriodMapper.countList();
    }

    @Override
    public List<SignInPeriod> listAll() {
        return signInPeriodMapper.listAll();
    }

    @Override
    public SignInPeriod getBySignInPeriodNo(Integer signInPeriod) {
        return signInPeriodMapper.getBySignInPeriodNo(signInPeriod);
    }

    @Override
    public SignInPeriod getBySn(Integer sn) {
        return signInPeriodMapper.getBySn(sn);
    }
}
