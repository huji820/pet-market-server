package com.yangwang.application.pet.market.dao.market.pet;

import com.yangwang.application.pet.market.model.common.Pet;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/***
 * <p>
 * 一键代发商家宠物
 * </p>
 *
 **/
@Mapper
public interface PetIssuedBehalfMapper {

    /**
     * 一键代发宠物
     * @param pet
     * @return
     */
    int save(@Param("pet")Pet pet);

    /**
     * 获取商家所有一键代发的宠物
     * @param businessNo
     * @return
     */
    List<Pet> listByBusinessNo(@Param("businessNo")String businessNo);

    /**
     * 移除一键代发的宠物
     * @param petNo
     * @return
     */
    int removePetByPetNo(@Param("petNo")String petNo);

    /**
     * 根据源头宠物修改宠物状态（上架与下架）
     * @param sourcePetNo
     * @param state
     * @return
     */
    int updatePetState(@Param("sourcePetNo")String sourcePetNo,@Param("state") int state);

    /**
     * 根据源头宠物修改宠物状态（是否售出）
     * @param sourcePetNo
     * @param petIsSell
     * @return
     */
    int updatePetIsSell(@Param("sourcePetNo")String sourcePetNo,@Param("petIsSell") int petIsSell);
}
