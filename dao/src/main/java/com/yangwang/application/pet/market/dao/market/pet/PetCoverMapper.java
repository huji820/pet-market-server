package com.yangwang.application.pet.market.dao.market.pet;

import com.yangwang.application.pet.market.model.common.PetCover;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 宠物封面
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className PetCoverMapper
 * @date 2020/3/12 16:20
 **/
public interface PetCoverMapper {
    /**
     * <p>
     * 新增一条数据
     * </p>
     *
     * @param petCover 宠物封面对象
     * @return int
     * @author LiuXiangLin
     * @date 16:21 2020/3/12
     **/
    int save(@Param("petCover") PetCover petCover);

    /**
     * <p>
     * 删除
     * </p>
     *
     * @param petNo 宠物编号
     * @return int
     * @author LiuXiangLin
     * @date 16:22 2020/3/12
     **/
    int delete(@Param("petNo") String petNo);

    /**
     * <p>
     * 通过宠物主键查询照片
     * </p>
     *
     * @param petNo
     * @return com.yangwang.application.pet.market.model.common.PetCover
     * @author LiuXiangLin
     * @date 16:44 2020/3/12
     **/
    List<PetCover> getByPetNo(@Param("petNo") String petNo);

    /**
     * <p>
     * 添加一个列表
     * </p>
     *
     * @param petCoverList 宠物图片列表
     * @return int
     * @author LiuXiangLin
     * @date 17:02 2020/3/12
     **/
    int saveList(@Param("petCoverList") List<PetCover> petCoverList);
}
