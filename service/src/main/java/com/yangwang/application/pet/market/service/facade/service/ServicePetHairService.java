package com.yangwang.application.pet.market.service.facade.service;

import com.yangwang.application.pet.market.model.common.PetHair;

import java.util.List;

/**
 * 宠物毛长的接口
 */
public interface ServicePetHairService {

    /**
     * 根据服务获取宠物毛长
     * @param serviceID
     * @param petGenreNo
     * @return
     */
    List<PetHair> listServicePetHair(long serviceID, String petGenreNo);


    /**
     * 获取系统内已有的所有的宠物毛长
     * @return
     */
    List<PetHair> listAllServicePetHair();
}
