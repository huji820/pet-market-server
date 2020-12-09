package com.yangwang.application.pet.market.service.spring.common;

import com.yangwang.application.pet.market.dao.common.PetNearMapper;
import com.yangwang.application.pet.market.model.params.QueryPetMarketListParam;
import com.yangwang.application.pet.market.model.vo.PetVo;
import com.yangwang.application.pet.market.service.facade.common.PetNearService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yang hituzi
 * @description 二级页面 搜索附近的宠物
 * @date 2020年4月10日 14:53:55
 */
@Service
public class PetNearServiceImpl implements PetNearService {

    @Resource
    PetNearMapper petNearMapper;

    @Override
    public List<PetVo> list(QueryPetMarketListParam queryPetMarketListParam) {
        queryPetMarketListParam.dealWithParam();
        return petNearMapper.listByQueryParam(queryPetMarketListParam);
    }
}
