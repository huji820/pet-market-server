package com.yangwang.application.pet.market.service.spring.common;

import com.yangwang.application.pet.market.dao.business.QueryBusinessMapper;
import com.yangwang.application.pet.market.model.business.Business;
import com.yangwang.application.pet.market.model.params.QueryQueryListParam;
import com.yangwang.application.pet.market.service.facade.common.QueryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 商家关键字查询
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className QueryBusinessServiceImpl
 * @date 2020/3/25 10:14
 **/
@Service
public class QueryBusinessServiceImpl implements QueryService<Business> {
    @Resource
    QueryBusinessMapper queryBusinessMapper;

    @Override
    public List<Business> query(QueryQueryListParam queryQueryListParam) {
        return queryBusinessMapper.listByQueryParam(queryQueryListParam);
    }
}
