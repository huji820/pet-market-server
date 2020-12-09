package com.yangwang.application.pet.market.service.spring.service;

import com.yangwang.application.pet.market.dao.service.ServicePetHairMapper;
import com.yangwang.application.pet.market.model.common.PetGenre;
import com.yangwang.application.pet.market.model.common.PetHair;
import com.yangwang.application.pet.market.service.facade.common.PetGenreService;
import com.yangwang.application.pet.market.service.facade.service.ServicePetHairService;
import com.yangwang.application.pet.market.service.facade.service.ServicePetWeightService;
import com.yangwang.sysframework.utils.TypeConvertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @TODO
 * @Description
 * @Author Administrator
 * @Date 2020-03-24 22:29
 * @Version 1.0
 */
@Service
public class ServicePetHairServiceImpl implements ServicePetHairService {

    @Autowired
    ServicePetHairMapper servicePetHairMapper;
    @Autowired
    PetGenreService petGenreService;
    @Override
    public List<PetHair> listServicePetHair(long serviceID, String petGenreNo) {
        PetGenre petGenre = petGenreService.get(TypeConvertUtil.$int(petGenreNo));
        return servicePetHairMapper.listServicePetHair(serviceID, petGenre.getPetSort().getPetSortNo());
    }

    @Override
    public List<PetHair> listAllServicePetHair() {
        return servicePetHairMapper.listAllServicePetHair();
    }
}
