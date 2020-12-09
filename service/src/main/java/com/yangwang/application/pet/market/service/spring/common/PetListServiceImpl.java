package com.yangwang.application.pet.market.service.spring.common;

import com.yangwang.application.pet.market.dao.market.pet.PetListMapper;
import com.yangwang.application.pet.market.model.params.QueryPetBusinessListParam;
import com.yangwang.application.pet.market.model.params.QueryPetMarketListParam;
import com.yangwang.application.pet.market.model.vo.PetVo;
import com.yangwang.application.pet.market.service.facade.common.PetListService;
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
 * @className PetListServiceImpl
 * @date 2020/3/20 10:12
 **/
@Service
public class PetListServiceImpl implements PetListService {
    @Resource
    PetListMapper petListMapper;

    @Override
    public List<PetVo> listBusinessPet(QueryPetBusinessListParam queryPetBusinessListParam) {
        return petListMapper.listBusinessPet(queryPetBusinessListParam);
    }

    @Override
    public List<PetVo> listMarketPet(QueryPetMarketListParam queryPetMarketListParam) {
        return petListMapper.listMarketPet(queryPetMarketListParam);
    }
}
