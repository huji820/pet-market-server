package com.yangwang.application.pet.market.service.spring.common;

import com.yangwang.application.pet.market.dao.market.pet.PetGenreMapper;
import com.yangwang.application.pet.market.model.common.PetGenre;
import com.yangwang.application.pet.market.model.params.QueryPetGenreListParam;
import com.yangwang.application.pet.market.service.facade.common.PetGenreService;
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
 * @className PetGenreServiceImpl
 * @date 2020/3/22 14:00
 **/
@Service
public class PetGenreServiceImpl implements PetGenreService {
    @Resource
    PetGenreMapper petGenreMapper;

    @Override
    public List<PetGenre> listByParam(QueryPetGenreListParam queryPetGenreListParam) {
        return petGenreMapper.listByParam(queryPetGenreListParam);
    }

    @Override
    public PetGenre get(int petGenreNo) {
        return petGenreMapper.get(petGenreNo);
    }
}
