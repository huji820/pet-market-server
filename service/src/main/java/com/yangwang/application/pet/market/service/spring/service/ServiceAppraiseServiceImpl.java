package com.yangwang.application.pet.market.service.spring.service;

import com.yangwang.application.pet.market.dao.service.ServiceAppraiseMapper;
import com.yangwang.application.pet.market.model.service.ServiceAppraise;
import com.yangwang.application.pet.market.service.facade.service.ServiceAppraiseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className ServiceAppraiseServiceImpl
 * @date 2020/7/10 14:03
 **/
@Service
public class ServiceAppraiseServiceImpl implements ServiceAppraiseService {

    @Resource
    ServiceAppraiseMapper serviceAppraiseMapper;

    @Override
    public int save(ServiceAppraise serviceAppraise) {
        return serviceAppraiseMapper.save(serviceAppraise);
    }

    @Override
    public int delete(int serviceAppraiseNo) {
        return serviceAppraiseMapper.delete(serviceAppraiseNo);
    }

    @Override
    public ServiceAppraise getByAppraise(ServiceAppraise serviceAppraise) {
        return serviceAppraiseMapper.getByAppraise(serviceAppraise);
    }

    @Override
    public ServiceAppraise get(int serviceAppraiseNo) {
        return serviceAppraiseMapper.get(serviceAppraiseNo);
    }

    @Override
    public int countByItemNo(int itemNo) {
        return serviceAppraiseMapper.countByServiceId(itemNo);
    }

    @Override
    public int countByItemNoAndUpPraiseDegree(int serviceID, int praiseDegree) {
        return serviceAppraiseMapper.countByServiceNoAndUpPraiseDegree(serviceID, praiseDegree);
    }
}
