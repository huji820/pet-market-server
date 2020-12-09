package com.yangwang.application.pet.market.service.facade.signIn;

import com.yangwang.application.pet.market.model.common.signIn.SignIn;
import com.yangwang.application.pet.market.model.common.signIn.SignInHistory;
import com.yangwang.sysframework.utils.JsonResult;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 签到信息service
 */
public interface SignInService {

    /**
     * 签到
     * @param businessNo
     * @return
     */
    int signIn(String businessNo);

    /**
     * 通过签到人获取本人的签到信息记录
     * @param businessNo
     * @return
     */
    SignIn getByBusinessNo(String businessNo);

    /**
     * 判断当前日期用户是否签到
     * @param businessNo 用户
     * @return
     */
    boolean signInOrNot(String businessNo);

}
