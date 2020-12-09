package com.yangwang.application.pet.market.dao.market.pet;

import com.yangwang.application.pet.market.model.params.QueryPetMarketListParam;
import com.yangwang.application.pet.market.model.vo.PetVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 跳蚤市场
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className FleaMarketMapper
 * @date 2020/3/14 15:02
 **/
@Mapper
public interface FleaMarketMapper {
    /**
     * <p>
     * 通过对象查询宠物列表
     * </p>
     *
     * @param queryPetMarketListParam 查询对象
     * @return java.util.List<com.yangwang.application.pet.market.model.vo.PetVo>
     * @author LiuXiangLin
     * @date 15:03 2020/3/14
     **/
    List<PetVo> listByParam(@Param("queryPetMarketListParam") QueryPetMarketListParam queryPetMarketListParam);
}
