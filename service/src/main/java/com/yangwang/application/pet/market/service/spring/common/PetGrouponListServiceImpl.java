package com.yangwang.application.pet.market.service.spring.common;

import com.yangwang.application.pet.market.dao.market.pet.PetGrouponListMapper;
import com.yangwang.application.pet.market.model.params.QueryPetMarketListParam;
import com.yangwang.application.pet.market.model.vo.PetVo;
import com.yangwang.application.pet.market.service.facade.common.PetGrouponListService;
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
 * @className PetGrouponListServiceImpl
 * @date 2020/3/25 16:27
 **/
@Service
public class PetGrouponListServiceImpl implements PetGrouponListService {
    @Resource
    PetGrouponListMapper petGrouponListMapper;

    @Override
    public List<PetVo> listByParam(QueryPetMarketListParam queryPetMarketListParam) {
        return petGrouponListMapper.listByParam(queryPetMarketListParam);
    }
}
