package com.yangwang.application.pet.market.service.spring.common;

import com.yangwang.application.pet.market.common.utils.CollectionUtils;
import com.yangwang.application.pet.market.dao.market.pet.PetWormKillMapper;
import com.yangwang.application.pet.market.model.common.Pet;
import com.yangwang.application.pet.market.model.common.PetWormKill;
import com.yangwang.application.pet.market.service.facade.common.PetWormKillService;
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
 * @className PetWormKillServiceImpl
 * @date 2020/3/12 17:55
 **/
@Service
public class PetWormKillServiceImpl implements PetWormKillService {
    @Resource
    PetWormKillMapper petWormKillMapper;

    @Override
    public int save(PetWormKill petWormKill) {
        return petWormKillMapper.save(petWormKill);
    }

    @Override
    public int saveList(List<PetWormKill> petWormKillList) {
        if (CollectionUtils.isNotEmpty(petWormKillList)) {
            return petWormKillMapper.saveList(petWormKillList);
        }
        return 0;
    }

    @Override
    public int delete(String petNo) {
        return petWormKillMapper.delete(petNo);
    }

    @Override
    public List<PetWormKill> listByPetNo(String petNo) {
        return petWormKillMapper.listByPetNo(petNo);
    }

    @Override
    public int updateList(List<PetWormKill> petWormKillList, Pet pet) {
        delete(pet.getPetNo());
        saveList(petWormKillList);
        return 0;
    }
}
