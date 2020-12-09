package com.yangwang.application.pet.market.service.spring.common;

import com.yangwang.application.pet.market.dao.market.pet.PetMapper;
import com.yangwang.application.pet.market.model.business.Business;
import com.yangwang.application.pet.market.model.common.Pet;
import com.yangwang.application.pet.market.service.facade.common.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;


/**
 * <p>
 *
 * </p>
 *
 * @author LiuXiangLin
 * @date 9:28 2020/3/13
 **/
@Service
public class PetServiceImpl implements PetService {
    @Resource
    PetMapper petMapper;

    @Resource
    PetIssuedBehalfService petIssuedBehalfService;

    @Override
    public int save(Pet pet) {
        return petMapper.save(pet);
    }

    @Override
    public int updatePetState(String petNo, int state) {
        Pet pet = petMapper.get(petNo);
        if(pet.getSourcePetNo()==null){
            //如果宠物是源头宠物，所有代发它的商家店铺内的全部同步更新状态
            petIssuedBehalfService.updatePetState(petNo, state);
        }else{
            //如果宠物是代发宠物，上架前要判断源头宠物状态，源头宠物是下架状态不允许上架
            Pet sourcePet = petMapper.get(pet.getSourcePetNo());
            if(sourcePet.getPetState().equals(0)){ //下架状态
                return 0;
            }
        }
        return petMapper.updateState(petNo, state);
    }

    @Override
    public int update(Pet pet) {
        return petMapper.update(pet);
    }

    @Override
    public int updatePetIsSell(String petNo, int petIsSell) {
        return petMapper.updatePetIsSell(petNo, petIsSell);
    }

    @Override
    public String newPetNo(Business business) {
        return business.getBusinessNo() + System.currentTimeMillis();
    }

    @Override
    public int updateCollectionAdd(String petNo, int collection) {
        return petMapper.addCollectionQty(petNo, collection);
    }

    @Override
    public int updateCollectionSub(String petNo, int collection) {
        return petMapper.addCollectionQty(petNo, -collection);
    }

    @Override
    public int updateEvaluationQtyAdd(String petNo, int evaluation) {
        return petMapper.addEvaluationQty(petNo, evaluation);
    }

    @Override
    public int updateEvaluationQtySub(String petNo, int evaluation) {
        return petMapper.addEvaluationQty(petNo, -evaluation);
    }

    @Override
    public int updateFavorableRate(String petNo, BigDecimal favorableRate) {
        return petMapper.updateFavorableRate(petNo, favorableRate);
    }

    @Override
    public int updateSalesVolumeAdd(String petNo, int salesVolume) {
        return petMapper.addSalesVolume(petNo, salesVolume);
    }

    @Override
    public Pet get(String petNo) {
        return petMapper.get(petNo);
    }
}
