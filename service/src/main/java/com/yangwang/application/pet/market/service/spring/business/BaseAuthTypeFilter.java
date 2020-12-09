package com.yangwang.application.pet.market.service.spring.business;

import com.yangwang.application.pet.market.model.business.Auth;

/**
 * <p>
 * 认证类型抽象类
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className BaseAuthTypeFilter
 * @date 2020/3/19 14:53
 **/
public abstract class BaseAuthTypeFilter {
    /**
     * <p>
     * 检查是否
     * </p>
     *
     * @param auth 认证对象
     * @return boolean
     * @author LiuXiangLin
     * @date 14:55 2020/3/19
     **/
    public abstract boolean check(Auth auth);
}
