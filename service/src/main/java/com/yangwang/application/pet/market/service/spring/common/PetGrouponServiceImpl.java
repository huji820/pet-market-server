package com.yangwang.application.pet.market.service.spring.common;

import com.yangwang.application.pet.market.common.utils.CollectionUtils;
import com.yangwang.application.pet.market.dao.market.pet.PetGrouponMapper;
import com.yangwang.application.pet.market.model.common.Pet;
import com.yangwang.application.pet.market.model.common.PetGroupon;
import com.yangwang.application.pet.market.service.facade.common.PetGrouponService;
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
 * @className PetGrouponServiceImpl
 * @date 2020/3/25 14:40
 **/
@Service
public class PetGrouponServiceImpl implements PetGrouponService {
    @Resource
    PetGrouponMapper petGrouponMapper;

    @Override
    public int saveList(List<PetGroupon> petGrouponList) {
        if (CollectionUtils.isNotEmpty(petGrouponList)) {
            petGrouponMapper.saveList(petGrouponList);
            return 1;
        }
        return 0;
    }

    @Override
    public int save(PetGroupon petGroupon) {
        return petGrouponMapper.save(petGroupon);
    }

    @Override
    public int deleteByPetNo(String petNo) {
        return petGrouponMapper.deleteByPetNo(petNo);
    }

    @Override
    public int updateList(List<PetGroupon> petGrouponList, Pet pet) {
        deleteByPetNo(pet.getPetNo());
        saveList(petGrouponList);
        return 1;
    }
}
