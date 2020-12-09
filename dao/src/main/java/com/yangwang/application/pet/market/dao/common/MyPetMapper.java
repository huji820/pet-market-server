package com.yangwang.application.pet.market.dao.common;

import com.yangwang.application.pet.market.model.common.MyPet;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 我的爱宠
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className MyPetMapper
 * @date 2020/3/24 17:40
 **/
public interface MyPetMapper {
    /**
     * <p>
     * 新增爱宠
     * </p>
     *
     * @param myPet 宠物对象
     * @return int
     * @author LiuXiangLin
     * @date 17:42 2020/3/24
     **/
    int save(@Param("myPet") MyPet myPet);

    /**
     * <p>
     * 删除宠物
     * </p>
     *
     * @param petNo 宠物编号
     * @return int
     * @author LiuXiangLin
     * @date 17:43 2020/3/24
     **/
    int delete(@Param("petNo") int petNo);

    /**
     * <p>
     * 更新宠物
     * </p>
     *
     * @param myPet 爱宠
     * @return int
     * @author LiuXiangLin
     * @date 、 2020/3/24
     **/
    int update(@Param("myPet") MyPet myPet);

    /**
     * <p>
     * 通过宠物编号获取宠物
     * </p>
     *
     * @param petNo 宠物编号
     * @return com.yangwang.application.pet.market.model.common.MyPet
     * @author LiuXiangLin
     * @date 17:44 2020/3/24
     **/
    MyPet get(@Param("petNo") int petNo);

    /**
     * <p>
     * 通过商家获取爱宠列表
     * </p>
     *
     * @param businessNo 商家编号
     * @return java.util.List<com.yangwang.application.pet.market.model.common.MyPet>
     * @author LiuXiangLin
     * @date 17:45 2020/3/24
     **/
    List<MyPet> listByBusinessNo(@Param("businessNo") String businessNo);

    /**
     * <p>
     * 通过商家主键获取爱宠的总数量
     * </p>
     *
     * @param businessNo 商家编号
     * @return int
     * @author LiuXiangLin
     * @date 10:41 2020/4/30
     **/
    int countByBusinessNo(@Param("businessNo") String businessNo);
}
