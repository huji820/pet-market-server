package com.yangwang.application.pet.market.service.spring.common;

import com.yangwang.application.pet.market.dao.market.pet.HighQualityMapper;
import com.yangwang.application.pet.market.model.params.QueryPetMarketListParam;
import com.yangwang.application.pet.market.model.vo.PetVo;
import com.yangwang.application.pet.market.service.facade.common.HighQualityService;
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
 * @className HighQualityServiceImpl
 * @date 2020/3/17 9:36
 **/
@Service
public class HighQualityServiceImpl implements HighQualityService {
    @Resource
    HighQualityMapper highQualityMapper;

    @Override
    public List<PetVo> list(QueryPetMarketListParam queryPetMarketListParam) {
        queryPetMarketListParam.dealWithParam();
        return highQualityMapper.listByQueryParam(queryPetMarketListParam);
    }
}
