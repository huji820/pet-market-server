package com.yangwang.application.pet.market.dao.common;

import com.yangwang.application.pet.market.model.common.PetGenre;
import com.yangwang.application.pet.market.model.params.QueryQueryListParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 宠物类查询
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className QueryPetGenreMapper
 * @date 2020/3/25 10:22
 **/
public interface QueryPetGenreMapper {
    /**
     * <p>
     * 通过关键字查询宠分类列表
     * </p>
     *
     * @param queryQueryListParam 查询参数
     * @return java.util.List<com.yangwang.application.pet.market.model.common.PetGenre>
     * @author LiuXiangLin
     * @date 10:22 2020/3/25
     **/
    List<PetGenre> listByQueryParam(@Param("queryQueryListParam") QueryQueryListParam queryQueryListParam);
}
