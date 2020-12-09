package com.yangwang.application.pet.market.service.spring.common;

import com.yangwang.application.pet.market.common.utils.CollectionUtils;
import com.yangwang.application.pet.market.dao.market.pet.PetVaccineMapper;
import com.yangwang.application.pet.market.model.common.Pet;
import com.yangwang.application.pet.market.model.common.PetVaccine;
import com.yangwang.application.pet.market.service.facade.common.PetVaccineService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className PetVaccineServiceImpl
 * @date 2020/3/12 18:11
 **/
@Service
public class PetVaccineServiceImpl implements PetVaccineService {
    @Resource
    PetVaccineMapper petVaccineMapper;

    @Override
    public int save(PetVaccine petVaccine) {
        return petVaccineMapper.save(petVaccine);
    }

    @Override
    public int saveList(List<PetVaccine> petVaccineList) {
        if (CollectionUtils.isNotEmpty(petVaccineList)) {
            return petVaccineMapper.saveList(petVaccineList);
        }
        return 0;
    }

    @Override
    public int delete(String petNo) {
        return petVaccineMapper.delete(petNo);
    }

    @Override
    public List<PetVaccine> listByPetNo(String petNo) {
        return petVaccineMapper.listByPetNo(petNo);
    }

    @Override
    public int updateList(List<PetVaccine> petVaccineList, Pet pet) {
        petVaccineMapper.delete(pet.getPetNo());
        saveList(petVaccineList);
        return 1;
    }
}
