package com.yangwang.application.pet.market.service.spring.service;

import com.yangwang.application.pet.market.dao.service.ServicePetWeightMapper;
import com.yangwang.application.pet.market.model.service.ServicePrice;
import com.yangwang.application.pet.market.service.facade.service.ServicePetWeightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @TODO
 * @Description
 * @Author Administrator
 * @Date 2020-03-24 22:29
 * @Version 1.0
 */
@Service
public class ServicePetWeightServiceImpl implements ServicePetWeightService {

    @Resource
    ServicePetWeightMapper servicePetWeightMapper;

    @Override
    public List<ServicePrice> listServicePetWeight(long serviceID, int hairLength) {
        return servicePetWeightMapper.listServicePetWeight(serviceID, hairLength);
    }
}
