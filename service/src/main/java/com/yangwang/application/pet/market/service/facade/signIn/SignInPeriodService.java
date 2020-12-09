package com.yangwang.application.pet.market.service.facade.signIn;

import com.yangwang.application.pet.market.model.common.signIn.SignInPeriod;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 签到周期Service
 * @Date 2020/08/20
 */
public interface SignInPeriodService {

    /**
     * 获取签到周期天数
     * @return
     */
    int countList();

    /**
     * 获取所有签到周期数据
     * @return
     */
    List<SignInPeriod> listAll();

    /**
     * 通过主键获取一条签到周期数据
     * @param signInPeriodNo
     * @return
     */
    SignInPeriod getBySignInPeriodNo(Integer signInPeriodNo);

    /**
     * 通过sn获取签到周期数据
     * @param sn
     * @return
     */
    SignInPeriod getBySn(Integer sn);
}
