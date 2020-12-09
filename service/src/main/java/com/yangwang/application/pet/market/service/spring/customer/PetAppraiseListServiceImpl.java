package com.yangwang.application.pet.market.service.spring.customer;

import com.yangwang.application.pet.market.dao.market.pet.PetAppraiseListMapper;
import com.yangwang.application.pet.market.model.params.QueryPetAppraiseListParam;
import com.yangwang.application.pet.market.model.vo.PetAppraiseVo;
import com.yangwang.application.pet.market.service.facade.customer.PetAppraiseListService;
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
 * @className PetAppraiseListServiceImpl
 * @date 2020/3/23 17:58
 **/
@Service
public class PetAppraiseListServiceImpl implements PetAppraiseListService {
    @Resource
    PetAppraiseListMapper petAppraiseListMapper;

    @Override
    public List<PetAppraiseVo> list(QueryPetAppraiseListParam queryPetAppraiseListParam) {
        return petAppraiseListMapper.list(queryPetAppraiseListParam);
    }
}
