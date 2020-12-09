package com.yangwang.application.pet.market.service.spring.common;

import com.yangwang.application.pet.market.dao.market.pet.FleaMarketMapper;
import com.yangwang.application.pet.market.model.params.QueryPetMarketListParam;
import com.yangwang.application.pet.market.model.vo.PetVo;
import com.yangwang.application.pet.market.service.facade.common.FleaMarketService;
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
 * @className FleaMarketServiceImpl
 * @date 2020/3/14 14:59
 **/
@Service
public class FleaMarketServiceImpl implements FleaMarketService {
    @Resource
    FleaMarketMapper fleaMarketMapper;

    @Override
    public List<PetVo> list(QueryPetMarketListParam queryPetMarketListParam) {
        queryPetMarketListParam.dealWithParam();
        return fleaMarketMapper.listByParam(queryPetMarketListParam);
    }
}
