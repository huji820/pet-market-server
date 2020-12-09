package com.yangwang.application.pet.market.service.spring.business;

import com.yangwang.application.pet.market.model.business.Auth;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * <p>
 *
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className PlatformAuthTypeFilter
 * @date 2020/3/19 16:42
 **/
@Component
public class PlatformAuthTypeFilter extends BaseAuthTypeFilter {
    @Resource
    BusinessAuthTypeFilter businessAuthTypeFilter;

    @Override
    public boolean check(Auth auth) {
        return businessAuthTypeFilter.check(auth)
                && StringUtils.isNotBlank(auth.getLicenseImg())
                && StringUtils.isNotBlank(auth.getLicenseNo())
                && StringUtils.isNotBlank(auth.getShopName());
    }
}
