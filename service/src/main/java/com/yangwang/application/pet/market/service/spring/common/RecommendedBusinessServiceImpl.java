package com.yangwang.application.pet.market.service.spring.common;

import com.yangwang.application.pet.market.dao.business.RecommendedBusinessMapper;
import com.yangwang.application.pet.market.model.business.Business;
import com.yangwang.application.pet.market.service.facade.common.RecommendedBusinessService;
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
 * @className RecommendedBusinessServiceImpl
 * @date 2020/3/17 11:24
 **/
@Service
public class RecommendedBusinessServiceImpl implements RecommendedBusinessService {
    @Resource
    RecommendedBusinessMapper recommendedBusinessMapper;

    @Override
    public List<Business> list(int offset, int limit) {
        return recommendedBusinessMapper.list(offset, limit);
    }
}
