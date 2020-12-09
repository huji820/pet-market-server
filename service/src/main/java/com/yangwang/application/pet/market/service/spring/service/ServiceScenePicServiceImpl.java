package com.yangwang.application.pet.market.service.spring.service;

import com.yangwang.application.pet.market.common.utils.CollectionUtils;
import com.yangwang.application.pet.market.dao.service.ServiceScenePicMapper;
import com.yangwang.application.pet.market.model.service.ServiceScenePic;
import com.yangwang.application.pet.market.service.facade.service.ServiceScenePicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @TODO
 * @Description
 * @Author Administrator
 * @Date 2020-03-31 18:24
 * @Version 1.0
 */
@Service
public class ServiceScenePicServiceImpl implements ServiceScenePicService {

    @Autowired
    ServiceScenePicMapper serviceScenePicMapper;

    @Override
    public int insertServiceImage(List<ServiceScenePic> pics) {
        if (!CollectionUtils.isNotEmpty(pics)) {
            return 0;
        }
        return serviceScenePicMapper.insertServiceImage(pics);
    }

    @Override
    public void deleteServiceImage(long serviceID) {
        serviceScenePicMapper.deleteServiceImage(serviceID);
    }
}
