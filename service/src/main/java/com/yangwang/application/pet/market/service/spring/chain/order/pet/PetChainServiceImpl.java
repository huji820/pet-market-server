package com.yangwang.application.pet.market.service.spring.chain.order.pet;

import com.yangwang.application.pet.market.model.common.Pet;
import com.yangwang.application.pet.market.model.market.PetOrderVo;
import com.yangwang.application.pet.market.service.facade.common.PetOrderCheckChainService;
import com.yangwang.application.pet.market.service.facade.common.PetService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 宠物校验
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className PetChainServiceImpl
 * @date 2020/3/28 10:22
 **/
@Service
public class PetChainServiceImpl implements PetOrderCheckChainService {
    private PetOrderCheckChainService next;

    @Resource
    PetService petService;

    @Override
    public void check(PetOrderVo petOrderVo) {
        Pet pet = petService.get(petOrderVo.getPet().getPetNo());
        if (pet != null) {
            petOrderVo.setPet(pet);
            if (null != next) {
                next.check(petOrderVo);
            }
        } else {
            petOrderVo.setCheckState(false);
        }
    }

    @Override
    public void setNext(PetOrderCheckChainService petOrderCheckChainService) {
        this.next = petOrderCheckChainService;
    }
}
