package com.yangwang.application.pet.market.dao.market.pet;

import com.yangwang.application.pet.market.model.params.QueryPetMarketListParam;
import com.yangwang.application.pet.market.model.vo.PetVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 高端宠物
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className HighQualityMapper
 * @date 2020/3/17 9:17
 **/
@Mapper
public interface HighQualityMapper {
    /**
     * <p>
     * 通过参数查询宠物列表
     * </p>
     *
     * @param queryPetMarketListParam 宠物列表查询对象
     * @return java.util.List<com.yangwang.application.pet.market.model.vo.PetVo>
     * @author LiuXiangLin
     * @date 9:19 2020/3/17
     **/
    List<PetVo> listByQueryParam(@Param("queryPetMarketListParam") QueryPetMarketListParam queryPetMarketListParam);
}
