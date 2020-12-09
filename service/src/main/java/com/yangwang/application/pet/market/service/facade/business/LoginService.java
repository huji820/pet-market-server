package com.yangwang.application.pet.market.service.facade.business;

import com.yangwang.application.pet.market.model.common.Customer;
import com.yangwang.application.pet.market.model.common.LoginInfo;

/**
 * <p>
 * 商家登录
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className LoginService
 * @date 2020/3/16 16:44
 **/
public interface LoginService {
    /**
     * <p>
     * 微信小程序登录
     * </p>
     *
     * @param loginInfo 用户信息
     * @param phone     电话号
     * @return com.yangwang.application.pet.market.model.common.Customer
     * @author LiuXiangLin
     * @date 16:44 2020/3/16
     **/
    Customer weApp(LoginInfo loginInfo, String phone);
}
