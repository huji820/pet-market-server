package com.yangwang.application.pet.market.service.facade.signIn;

import com.yangwang.application.pet.market.model.common.signIn.SignInHistory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 签到历史记录service
 */
public interface SignInHistoryService {

    /**
     * 插入一条签到历史记录
     * @param signInHistory
     * @return
     */
    int save(SignInHistory signInHistory);

    /**
     * 通过签到人获取本人的所有签到历史记录
     * @param businessNo
     * @return
     */
    List<SignInHistory> listByBusinessNo(String businessNo);

    /**
     * 通过businessNo获取本人的最近一条签到记录
     * @param businessNo
     * @return
     */
    SignInHistory getLastByBusinessNo(String businessNo);
}
