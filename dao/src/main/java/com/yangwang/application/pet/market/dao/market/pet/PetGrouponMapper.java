package com.yangwang.application.pet.market.dao.market.pet;

import com.yangwang.application.pet.market.model.common.PetGroupon;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 宠物团购
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className PetGrouponMapper
 * @date 2020/3/25 14:21
 **/
public interface PetGrouponMapper {
    /**
     * <p>
     * 新增一条数据
     * </p>
     *
     * @param petGroupon 宠物团购
     * @return int
     * @author LiuXiangLin
     * @date 14:23 2020/3/25
     **/
    int save(@Param("petGroupon") PetGroupon petGroupon);

    /**
     * <p>
     * 新增多条数据
     * </p>
     *
     * @param petGrouponList 宠物团购列表
     * @return int
     * @author LiuXiangLin
     * @date 14:29 2020/3/25
     **/
    int saveList(@Param("petGrouponList") List<PetGroupon> petGrouponList);

    /**
     * <p>
     * 通过宠物主键删除数据
     * </p>
     *
     * @param petNo 宠物主键
     * @return int
     * @author LiuXiangLin
     * @date 14:24 2020/3/25
     **/
    int deleteByPetNo(@Param("petNo") String petNo);
}
