package com.yangwang.application.pet.market.service.spring.customer;

import com.yangwang.application.pet.market.dao.market.pet.PetAppraiseMapper;
import com.yangwang.application.pet.market.model.market.*;
import com.yangwang.application.pet.market.service.facade.customer.PetAppraiseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *
 * </p>
 *
 * @author LiuXiangLin
 * @date 10:49 2020/3/23
 **/
@Service
public class PetAppraiseServiceImpl implements PetAppraiseService {
    @Resource
    PetAppraiseMapper petAppraiseMapper;

    @Override
    public int save(PetAppraise petAppraise) {
        return petAppraiseMapper.save(petAppraise);
    }

    @Override
    public int delete(int petAppraiseNo) {
        return petAppraiseMapper.delete(petAppraiseNo);
    }

    @Override
    public PetAppraise get(int petAppraiseNo) {
        return petAppraiseMapper.get(petAppraiseNo);
    }

    @Override
    public int countByPetNo(String petNo) {
        return petAppraiseMapper.countByPetNo(petNo);
    }

    @Override
    public int countByUpPraiseDegree(String petNo, int praiseDegree) {
        return petAppraiseMapper.countByUpPraiseDegree(petNo, praiseDegree);
    }

    @Override
    public PetAppraise getByPetAppraise(PetAppraise petAppraise) {
        return petAppraiseMapper.getByPetAppraise(petAppraise);
    }
}
