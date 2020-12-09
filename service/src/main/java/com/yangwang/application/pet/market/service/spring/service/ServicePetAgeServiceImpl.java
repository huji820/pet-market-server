package com.yangwang.application.pet.market.service.spring.service;

import com.yangwang.application.pet.market.dao.service.ServicePetAgeMapper;
import com.yangwang.application.pet.market.model.service.ServiceCatPrice;
import com.yangwang.application.pet.market.service.facade.service.ServicePetAgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @TODO
 * @Description
 * @Author Administrator
 * @Date 2020-03-30 15:17
 * @Version 1.0
 */
@Service
public class ServicePetAgeServiceImpl implements ServicePetAgeService {

    @Autowired
    ServicePetAgeMapper servicePetAgeMapper;

    @Override
    public List<ServiceCatPrice> listServicePetAge(long serviceID) {
        return servicePetAgeMapper.listServicePetAge(serviceID);
    }
}
