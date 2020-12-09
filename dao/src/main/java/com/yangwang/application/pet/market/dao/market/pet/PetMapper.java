package com.yangwang.application.pet.market.dao.market.pet;

import com.yangwang.application.pet.market.model.common.Pet;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/***
 * <p>
 * 商家宠物
 * </p>
 *
 * @author LiuXiangLin
 * @date 8:59 2020/3/13
 **/
@Mapper
public interface PetMapper {
    /**
     * <p>
     * 新增一条数据
     * </p>
     *
     * @param pet 宠物对象
     * @return int
     * @author LiuXiangLin
     * @date 9:29 2020/3/13
     **/
    int save(@Param("pet") Pet pet);

    /**
     * <p>
     * 更新宠物信息
     * </p>
     *
     * @param pet 宠物对象
     * @return int
     * @author LiuXiangLin
     * @date 9:29 2020/3/13
     **/
    int update(@Param("pet") Pet pet);

    /**
     * <p>
     * 跟新宠物状态
     * </p>
     *
     * @param petNo 宠物编号
     * @param state 宠物状态
     * @return int
     * @author LiuXiangLin
     * @date 9:30 2020/3/13
     **/
    int updateState(@Param("petNo") String petNo, @Param("state") int state);

    /**
     * 更新宠物是否售出状态
     * @param petNo  宠物编号
     * @param petIsSell  0 未售出   1 已售出
     * @return
     */
    int updatePetIsSell(@Param("petNo")String petNo,@Param("petIsSell")int petIsSell);

    /**
     * <p>
     * 修改添加宠物
     * </p>
     *
     * @param petNo         宠物编号
     * @param collectionQty 新增的收藏量
     * @return int
     * @author LiuXiangLin
     * @date 11:20 2020/3/21
     **/
    int addCollectionQty(@Param("petNo") String petNo, @Param("collectionQty") Integer collectionQty);

    /**
     * <p>
     * 修改添加评价量
     * </p>
     *
     * @param petNo      宠物编号
     * @param evaluation 销量
     * @return int
     * @author LiuXiangLin
     * @date 11:16 2020/3/23
     **/
    int addEvaluationQty(@Param("petNo") String petNo, @Param("evaluation") int evaluation);

    /**
     * <p>
     * 修改宠物好评率
     * </p>
     *
     * @param petNo         宠物编号
     * @param favorableRate 好评率
     * @return int
     * @author LiuXiangLin
     * @date 14:11 2020/3/23
     **/
    int updateFavorableRate(@Param("petNo") String petNo, @Param("favorableRate") BigDecimal favorableRate);

    /**
     * <p>
     * 给宠物添加销量
     * </p>
     *
     * @param petNo 宠物编号
     * @param salesVolume 销量
     * @return int
     * @author LiuXiangLin
     * @date 14:22 2020/4/26
     **/
    int addSalesVolume(@Param("petNo")String petNo, @Param("salesVolume") int salesVolume);

    /**
     * <p>
     * 通过主键获取宠物
     * </p>
     *
     * @param petNo 宠物主键
     * @return com.yangwang.application.pet.market.model.common.Pet
     * @author LiuXiangLin
     * @date 17:35 2020/3/26
     **/
    Pet get(@Param("petNo") String petNo);

}
