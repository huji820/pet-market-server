package com.yangwang.application.pet.market.service.spring.chain.order.pet;

import com.yangwang.application.pet.market.model.common.ReceivingAddress;
import com.yangwang.application.pet.market.model.market.PetOrderVo;
import com.yangwang.application.pet.market.service.facade.common.PetOrderCheckChainService;
import com.yangwang.application.pet.market.service.facade.common.ReceivingAddressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className ReceivingChainServiceImpl
 * @date 2020/3/28 11:00
 **/
@Service
public class ReceivingChainServiceImpl implements PetOrderCheckChainService {
    private PetOrderCheckChainService next;

    @Resource
    ReceivingAddressService receivingAddressService;

    @Override
    public void check(PetOrderVo petOrderVo) {
        if (petOrderVo.isCheckState()) {
            ReceivingAddress receivingAddress = receivingAddressService.get(petOrderVo.getReceivingAddress().getReceivingNo());
            if (receivingAddress != null) {
                petOrderVo.setReceivingAddress(receivingAddress);
                if (next != null) {
                    next.check(petOrderVo);
                }
            } else {
                petOrderVo.setCheckState(false);
            }
        }
    }

    @Override
    public void setNext(PetOrderCheckChainService petOrderCheckChainService) {
        this.next = petOrderCheckChainService;
    }
}
