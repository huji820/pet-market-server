package com.yangwang.application.pet.market.service.spring.business;

import com.yangwang.application.pet.market.model.business.Auth;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 个人认证
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className IndividualAuthTypeFilter
 * @date 2020/3/19 14:58
 **/
@Component
public class IndividualAuthTypeFilter extends BaseAuthTypeFilter {
    @Override
    public boolean check(Auth auth) {
        // 真实姓名 身份证 手持身份证图片不为空
        return StringUtils.isNotBlank(auth.getRealName())
                && StringUtils.isNotBlank(auth.getIdCard());
//                && StringUtils.isNotBlank(auth.getLegalImg());
    }
}
