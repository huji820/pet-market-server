package com.yangwang.application.pet.market.service.facade.common;

import com.yangwang.application.pet.market.model.common.Pet;
import java.util.List;

/***
 * <p>
 * 一键代发商家宠物
 * </p>
 *
 **/
public interface PetIssuedBehalfService {


    /**
     * 一键代发宠物
     * @param petNo
     * @param businessNo
     * @return
     */
    int save(String petNo,String businessNo);

    /**
     * 获取商家所有一键代发的宠物
     * @param businessNo
     * @return
     */
    List<Pet> listByBusinessNo(String businessNo);

    /**
     * 移除一键代发的宠物
     * @param petNo
     * @return
     */
    int removePetByPetNo(String petNo);

    /**
     * 根据源头宠物修改宠物状态（上架与下架）
     * @param sourcePetNo
     * @param state
     * @return
     */
    int updatePetState(String sourcePetNo, int state);

    /**
     * 根据源头宠物修改宠物状态（是否售出）
     * @param sourcePetNo
     * @param petIsSell
     * @return
     */
    int updatePetIsSell(String sourcePetNo,int petIsSell);

}
