package com.yangwang.application.pet.market.dao.service;

import com.yangwang.application.pet.market.model.common.PetHair;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 服务毛长
 * </p>
 *
 * @author LiuXiangLin
 * @date 9:19 2020/4/2
 **/
@Mapper
public interface ServicePetHairMapper {

    List<PetHair> listServicePetHair(@Param("serviceID") long serviceID, @Param("petSortNo") int petGenreNo);


    /**
     * 获取系统内已有的所有的宠物毛长
     * @return
     */
    List<PetHair> listAllServicePetHair();
}
