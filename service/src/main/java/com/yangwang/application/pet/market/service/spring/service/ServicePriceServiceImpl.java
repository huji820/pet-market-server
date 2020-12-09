package com.yangwang.application.pet.market.service.spring.service;

import com.yangwang.application.pet.market.common.utils.CollectionUtils;
import com.yangwang.application.pet.market.dao.service.ServicePriceMapper;
import com.yangwang.application.pet.market.model.common.PetGenre;
import com.yangwang.application.pet.market.model.service.ServicePrice;
import com.yangwang.application.pet.market.service.facade.common.PetGenreService;
import com.yangwang.application.pet.market.service.facade.service.ServicePriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @TODO
 * @Description
 * @Author Administrator
 * @Date 2020-03-24 23:06
 * @Version 1.0
 */
@Service
public class ServicePriceServiceImpl implements ServicePriceService {

    @Autowired
    ServicePriceMapper servicePriceMapper;

    @Autowired
    PetGenreService petGenreService;

    @Override
    public int insertServicePrice(List<ServicePrice> prices) {
        if (!CollectionUtils.isNotEmpty(prices)) {
            return 0;
        }
        return servicePriceMapper.insertServicePrice(prices);
    }

    @Override
    public void deleteServicePrice(long serviceId) {
        servicePriceMapper.deleteServicePrice(serviceId);
    }

    @Override
    public ServicePrice getServicePrice(Integer petGenreNo, Integer serviceId, Integer hairLength, Integer weight, Integer age) {
        PetGenre petGenre = petGenreService.get(petGenreNo);
        return servicePriceMapper.getServicePrice(petGenre.getPetSort().getPetSortNo(), serviceId, hairLength, weight, age);
    }
}
