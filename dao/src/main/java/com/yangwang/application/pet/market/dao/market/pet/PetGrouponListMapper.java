package com.yangwang.application.pet.market.dao.market.pet;

import com.yangwang.application.pet.market.model.params.QueryPetMarketListParam;
import com.yangwang.application.pet.market.model.vo.PetVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 宠物团购列表
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className PetGrouponListMapper
 * @date 2020/3/25 15:58
 **/
public interface PetGrouponListMapper {
    /**
     * <p>
     * 查询团购列表
     * </p>
     *
     * @param queryPetMarketListParam 查询对象
     * @return java.util.List<com.yangwang.application.pet.market.model.vo.PetGrouponVo>
     * @author LiuXiangLin
     * @date 15:59 2020/3/25
     **/
    List<PetVo> listByParam(@Param("queryPetMarketListParam") QueryPetMarketListParam queryPetMarketListParam);
}
