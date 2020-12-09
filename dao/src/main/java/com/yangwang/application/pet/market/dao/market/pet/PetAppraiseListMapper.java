package com.yangwang.application.pet.market.dao.market.pet;

import com.yangwang.application.pet.market.model.params.QueryPetAppraiseListParam;
import com.yangwang.application.pet.market.model.vo.PetAppraiseVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 宠物评价列表
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className PetAppraiseListMapper
 * @date 2020/3/23 17:33
 **/
public interface PetAppraiseListMapper {
    /**
     * <p>
     * 通过宠物编号查询所有的评价
     * </p>
     *
     * @param queryPetAppraiseListParam 查询参数对象
     * @return java.util.List<com.yangwang.application.pet.market.model.vo.PetAppraiseVo>
     * @author LiuXiangLin
     * @date 17:34 2020/3/23
     **/
    List<PetAppraiseVo> list(@Param("queryPetAppraiseListParam") QueryPetAppraiseListParam queryPetAppraiseListParam);
}
