package com.yangwang.application.pet.market.service.spring.common;

import com.yangwang.application.pet.market.dao.common.QueryPetGenreMapper;
import com.yangwang.application.pet.market.model.common.PetGenre;
import com.yangwang.application.pet.market.model.params.QueryQueryListParam;
import com.yangwang.application.pet.market.service.facade.common.QueryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 宠物分类查询
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className QueryPetGenreService
 * @date 2020/3/25 10:07
 **/
@Service
public class QueryPetGenreServiceImpl implements QueryService<PetGenre> {
    @Resource
    QueryPetGenreMapper queryPetGenreMapper;

    @Override
    public List<PetGenre> query(QueryQueryListParam queryQueryListParam) {
        return queryPetGenreMapper.listByQueryParam(queryQueryListParam);
    }
}
