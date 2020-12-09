package com.yangwang.application.pet.market.service.spring.chain.order.pet;

import com.yangwang.application.pet.market.model.market.PetOrderVo;
import com.yangwang.application.pet.market.service.facade.common.PetOrderCheckChainService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className OrderPriceChainServiceImpl
 * @date 2020/3/28 11:03
 **/
@Service
public class OrderPriceChainServiceImpl implements PetOrderCheckChainService {
    private PetOrderCheckChainService petOrderCheckChainService;

    @Override
    public void check(PetOrderVo petOrderVo) {

    }

    @Override
    public void setNext(PetOrderCheckChainService petOrderCheckChainService) {
        this.petOrderCheckChainService = petOrderCheckChainService;
    }
}
