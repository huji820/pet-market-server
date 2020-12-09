package com.yangwang.application.pet.market.dao.common;

import com.yangwang.application.pet.market.model.params.QueryPetMarketListParam;
import com.yangwang.application.pet.market.model.vo.PetVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PetNearMapper {

    /**
     *
     * 通过参数查询 附近宠物列表
     * @param queryPetMarketListParam
     * @return java.util.List<com.yangwang.application.pet.market.model.vo.PetVo>
     * @author yang hituzi
     * @date 15:03 2020/4/10
     */
    List<PetVo> listByQueryParam(@Param("queryPetMarketListParam") QueryPetMarketListParam queryPetMarketListParam);
}
