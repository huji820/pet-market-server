package com.yangwang.application.pet.market.dao.market.signIn;

import com.yangwang.application.pet.market.model.common.signIn.SignInHistory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 签到记录mapper
 */
@Mapper
public interface SignInHistoryMapper {

    /**
     * 插入一条签到记录
     * @param signInHistory
     * @return
     */
    int save(@Param("signInHistory")SignInHistory signInHistory);

    /**
     * 通过签到人获取本人的所有签到记录
     * @param businessNo
     * @return
     */
    List<SignInHistory> listByBusinessNo(@Param("businessNo")String businessNo);

    /**
     * 获取本人最近的一条签到记录
     * @param businessNo
     * @return
     */
    SignInHistory getLastByBusinessNo(@Param("businessNo")String businessNo);
}
