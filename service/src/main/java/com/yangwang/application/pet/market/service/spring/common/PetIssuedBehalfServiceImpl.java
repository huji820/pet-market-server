package com.yangwang.application.pet.market.service.spring.common;

import com.yangwang.application.pet.market.dao.market.pet.PetIssuedBehalfMapper;
import com.yangwang.application.pet.market.model.business.Business;
import com.yangwang.application.pet.market.model.common.Pet;
import com.yangwang.application.pet.market.service.facade.common.PetIssuedBehalfService;
import com.yangwang.application.pet.market.service.facade.common.PetService;
import com.yangwang.application.pet.market.service.service.BusinessService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/***
 * <p>
 * 一键代发商家宠物
 * </p>
 *
 **/
@Service
public class PetIssuedBehalfServiceImpl implements PetIssuedBehalfService {

    @Resource
    PetIssuedBehalfMapper petIssuedBehalfMapper;

    @Resource
    PetService petService;

    @Resource
    BusinessService businessService;

    @Override
    public int save(String petNo, String businessNo) {
        //获取要一键代发的宠物
        Pet pet = petService.get(petNo);
        //获取商家
        Business business = businessService.getByBusinessNoWithOutState(businessNo);
        if(pet.getSourcePetNo()==null){ //是源头宠物
            pet.setSourcePetNo(petNo);
        }else{
            //获取源头宠物
            Pet sourcePet = petService.get(pet.getSourcePetNo());
            pet.setSourcePetNo(sourcePet.getPetNo());
        }
        pet.setBusiness(business);
        pet.setPetNo(petService.newPetNo(business));
        int i = petIssuedBehalfMapper.save(pet);
        return i;
    }

    @Override
    public List<Pet> listByBusinessNo(String businessNo) {
        return petIssuedBehalfMapper.listByBusinessNo(businessNo);
    }

    @Override
    public int removePetByPetNo(String petNo) {
        return petIssuedBehalfMapper.removePetByPetNo(petNo);
    }

    @Override
    public int updatePetState(String sourcePetNo, int state) {
        return petIssuedBehalfMapper.updatePetState(sourcePetNo, state);
    }

    @Override
    public int updatePetIsSell(String sourcePetNo, int petIsSell) {
        return petIssuedBehalfMapper.updatePetIsSell(sourcePetNo, petIsSell);
    }
}
