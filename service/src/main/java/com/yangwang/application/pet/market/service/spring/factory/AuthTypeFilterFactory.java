package com.yangwang.application.pet.market.service.spring.factory;

import com.yangwang.application.pet.market.model.business.Auth;
import com.yangwang.application.pet.market.service.spring.business.BusinessAuthTypeFilter;
import com.yangwang.application.pet.market.service.spring.business.IndividualAuthTypeFilter;
import com.yangwang.application.pet.market.service.spring.business.PlatformAuthTypeFilter;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * <p>
 *
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className AuthTypeFilterFactory
 * @date 2020/3/19 16:46
 **/
@Component
public class AuthTypeFilterFactory {
    @Resource
    IndividualAuthTypeFilter individualAuthTypeFilter;

    @Resource
    BusinessAuthTypeFilter businessAuthTypeFilter;

    @Resource
    PlatformAuthTypeFilter platformAuthTypeFilter;

    /**
     * <p>
     * 校验认证类型
     * </p>
     *
     * @param auth 认证对象
     * @return boolean
     * @author LiuXiangLin
     * @date 16:53 2020/3/19
     **/
    public boolean check(Auth auth) {
        switch (auth.getBusinessAuthType()) {
            case 1:
                return individualAuthTypeFilter.check(auth);
            case 2:
                return businessAuthTypeFilter.check(auth);
            case 3:
                return platformAuthTypeFilter.check(auth);
            default:
                return false;
        }
    }

    /**
     * @Description:  根据传入参数的不同返回对应的认证类型
     * @Author: zxj
     * @Date: 2020/10/8 14:14
     * @param auth:
     * @return: java.lang.Integer
     **/
    public Integer getAuthType(Auth auth) {
        if(platformAuthTypeFilter.check(auth)){  //平台认证
            return 3;
        }else if(businessAuthTypeFilter.check(auth)){  //商家认证
            return 2;
        }else if(individualAuthTypeFilter.check(auth)){  //个人认证
            return 1;
        }else{      //认证失败
            return 0;
        }
    }
}
