package com.yangwang.application.pet.market.dao.market.signIn;

import com.yangwang.application.pet.market.model.common.signIn.SignInPeriod;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 签到周期mapper
 * @Date 2020/08/20
 */
@Mapper
public interface SignInPeriodMapper {

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
     * @param signInPeriod
     * @return
     */
    SignInPeriod getBySignInPeriodNo(@Param("signInPeriod")Integer signInPeriod);

    /**
     * 通过签到天数获取签到周期记录
     * @param sn
     * @return
     */
    SignInPeriod getBySn(@Param("sn")Integer sn);
}
