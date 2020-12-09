package com.yangwang.application.pet.market.service.facade.common;

import com.yangwang.application.pet.market.model.common.PetGenre;
import com.yangwang.application.pet.market.model.params.QueryPetGenreListParam;

import java.util.List;

/**
 * <p>
 * 宠物二级分类
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className PetGenreService
 * @date 2020/3/22 13:59
 **/
public interface PetGenreService {
    /**
     * <p>
     * 通过参数查询二级分类
     * </p>
     *
     * @param queryPetGenreListParam 查询参数
     * @return java.util.List<com.yangwang.application.pet.market.model.common.PetGenre>
     * @author LiuXiangLin
     * @date 13:59 2020/3/22
     **/
    List<PetGenre> listByParam(QueryPetGenreListParam queryPetGenreListParam);

    /**
     * <p>
     * 通过主键获取数据
     * </p>
     *
     * @param petGenreNo 二级分类主键
     * @return com.yangwang.application.pet.market.model.common.PetGenre
     * @author LiuXiangLin
     * @date 18:04 2020/3/26
     **/
    PetGenre get(int petGenreNo);
}
