package com.yangwang.application.pet.market.service.spring.business;

import com.yangwang.application.pet.market.model.business.Auth;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * <p>
 * 商家认证
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className BusinessAuthTypeFilter
 * @date 2020/3/19 15:04
 **/
@Component
public class BusinessAuthTypeFilter extends BaseAuthTypeFilter {
    @Resource
    IndividualAuthTypeFilter individualAuthTypeFilter;

    @Override
    public boolean check(Auth authDTO) {
        return individualAuthTypeFilter.check(authDTO) && authDTO.getShopImg() != null && authDTO.getShopImg().length > 0;
    }
}
