package com.yangwang.application.pet.market.dao.market.signIn;

import com.yangwang.application.pet.market.model.common.signIn.SignIn;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 签到mapper
 */
@Mapper
public interface SignInMapper {

    /**
     * 添加或修改签到
     * @param signIn
     * @return
     */
    int saveOrUpdate(SignIn signIn);

    /**
     * 通过签到人获取本人的签到信息
     * @param businessNo
     * @return
     */
    SignIn getByBusinessNo(@Param("businessNo")String businessNo);


}
