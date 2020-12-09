package com.yangwang.application.pet.market.service.spring.common;

import com.yangwang.application.pet.market.common.enums.BusinessStateEnum;
import com.yangwang.application.pet.market.model.business.Business;
import com.yangwang.application.pet.market.model.common.Pet;
import com.yangwang.application.pet.market.service.service.BusinessService;
import com.yangwang.application.pet.market.service.facade.common.PetPowerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className PetPowerServiceImpl
 * @date 2020/3/17 11:12
 **/
@Service
public class PetPowerServiceImpl implements PetPowerService {
    @Resource
    BusinessService businessService;

    @Override
    public int get(Pet pet, Business business) {
        /*权重暂时由是否其他质保以及是否已缴纳保证金为基准*/
        return pet.getSevenWarranty() + businessService.getByBusinessNoAndState(business.getBusinessNo(), BusinessStateEnum.NORMAL.getType()).getPayBond();
    }

    @Override
    public int update(String petNo, int power) {
        return 0;
    }
}
