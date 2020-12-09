package com.yangwang.application.pet.market.service.spring.chain.order.pet;

import com.yangwang.application.pet.market.model.business.Business;
import com.yangwang.application.pet.market.model.market.PetOrderVo;
import com.yangwang.application.pet.market.service.facade.common.PetOrderCheckChainService;
import com.yangwang.application.pet.market.service.service.BusinessService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * <p>
 *
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className DistributorChainServiceImpl
 * @date 2020/3/28 10:59
 **/
@Service
public class DistributorChainServiceImpl implements PetOrderCheckChainService {
    private PetOrderCheckChainService next;

    @Resource
    BusinessService businessService;

    @Override
    public void check(PetOrderVo petOrderVo) {
        if (petOrderVo.getShareBusiness() != null && petOrderVo.isCheckState()) {
            Business business = businessService.getByBusinessNoWithOutState(petOrderVo.getShareBusiness().getBusinessNo());
            if (business != null) {
                petOrderVo.setShareBusiness(business);
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
