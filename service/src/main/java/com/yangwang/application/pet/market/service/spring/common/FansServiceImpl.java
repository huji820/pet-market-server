package com.yangwang.application.pet.market.service.spring.common;

import com.yangwang.application.pet.market.dao.common.FansMapper;
import com.yangwang.application.pet.market.model.business.Follow;
import com.yangwang.application.pet.market.model.params.QueryFansListParam;
import com.yangwang.application.pet.market.service.service.FansService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className FansServiceImpl
 * @date 2020/3/25 9:43
 **/
@Service
public class FansServiceImpl implements FansService {
    @Resource
    FansMapper fansMapper;

    @Override
    public List<Follow> listByParam(QueryFansListParam queryFansListParam) {
        return fansMapper.listByParam(queryFansListParam);
    }
}
