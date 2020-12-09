package com.yangwang.application.pet.market.dao.market.pet;

import com.yangwang.application.pet.market.model.common.PetGenre;
import com.yangwang.application.pet.market.model.params.QueryPetGenreListParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 宠物二级分类
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className PetGenreMapper
 * @date 2020/3/22 13:48
 **/
public interface PetGenreMapper {
    /**
     * <p>
     * 通过查询参数查询列表
     * </p>
     *
     * @param queryPetGenreListParam 查询参数对象
     * @return java.util.List<com.yangwang.application.pet.market.model.common.PetGenre>
     * @author LiuXiangLin
     * @date 13:49 2020/3/22
     **/
    List<PetGenre> listByParam(@Param("queryPetGenreListParam") QueryPetGenreListParam queryPetGenreListParam);

    /**
     * <p>
     * 通过主键获取数据
     * </p>
     *
     * @param petGenreNo 主键
     * @return com.yangwang.application.pet.market.model.common.PetGenre
     * @author LiuXiangLin
     * @date 18:04 2020/3/26
     **/
    PetGenre get(int petGenreNo);

}
