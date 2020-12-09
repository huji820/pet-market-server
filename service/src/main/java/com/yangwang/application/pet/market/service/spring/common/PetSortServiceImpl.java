package com.yangwang.application.pet.market.service.spring.common;

import com.yangwang.application.pet.market.dao.market.pet.PetSortMapper;
import com.yangwang.application.pet.market.model.common.PetSort;
import com.yangwang.application.pet.market.model.params.PagingQueryParam;
import com.yangwang.application.pet.market.service.facade.common.PetSortService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * <p>
 *
 * </p>
 *
 * @author LiuXiangLin
 * @date 11:51 2020/3/22
 **/
@Service
public class PetSortServiceImpl implements PetSortService {
    @Resource
    PetSortMapper petSortMapper;

    @Override
    public List<PetSort> listByParam(PagingQueryParam pagingQueryParam) {
        return petSortMapper.listByParam(pagingQueryParam);
    }

    @Override
    public PetSort get(int petSortNo) {
        return petSortMapper.get(petSortNo);
    }
}
