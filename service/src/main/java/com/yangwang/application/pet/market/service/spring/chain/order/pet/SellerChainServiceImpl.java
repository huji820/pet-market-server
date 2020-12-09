package com.yangwang.application.pet.market.service.spring.chain.order.pet;

import com.yangwang.application.pet.market.model.market.PetOrderVo;
import com.yangwang.application.pet.market.service.facade.common.PetOrderCheckChainService;
import org.springframework.stereotype.Service;


/**
 * <p>
 * 卖家校验
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className SellerChainServiceImpl
 * @date 2020/3/28 10:57
 **/
@Service
public class SellerChainServiceImpl implements PetOrderCheckChainService {
    private PetOrderCheckChainService next;

    @Override
    public void check(PetOrderVo petOrderVo) {
    }

    @Override
    public void setNext(PetOrderCheckChainService petOrderCheckChainService) {
        this.next = petOrderCheckChainService;
    }
}
