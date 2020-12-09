package com.yangwang.application.pet.market.service.spring.chain.order.pet;

import com.yangwang.application.pet.market.model.business.Business;
import com.yangwang.application.pet.market.model.market.PetOrderVo;
import com.yangwang.application.pet.market.service.facade.common.PetOrderCheckChainService;
import com.yangwang.application.pet.market.service.service.BusinessService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 买家校验
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className BuyerChainServieImpl
 * @date 2020/3/28 10:55
 **/
@Service
public class BuyerChainServiceImpl implements PetOrderCheckChainService {
    private PetOrderCheckChainService next;

    @Resource
    BusinessService businessService;

    @Override
    public void check(PetOrderVo petOrderVo) {
        Business buyer = businessService.getByBusinessNoWithOutState(petOrderVo.getBusiness().getBusinessNo());
        if (buyer != null) {
            petOrderVo.setBusiness(buyer);
            if (next != null) {
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
