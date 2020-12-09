package com.yangwang.application.pet.market.service.spring.service;

import com.yangwang.application.pet.market.common.utils.CollectionUtils;
import com.yangwang.application.pet.market.dao.service.ServiceInfoMapper;
import com.yangwang.application.pet.market.model.service.Service;
import com.yangwang.application.pet.market.model.service.ServicePrice;
import com.yangwang.application.pet.market.model.service.ServiceScenePic;
import com.yangwang.application.pet.market.service.facade.service.ServiceInfoService;
import com.yangwang.application.pet.market.service.facade.service.ServicePriceService;
import com.yangwang.application.pet.market.service.facade.service.ServiceScenePicService;
import com.yangwang.application.pet.market.service.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @TODO
 * @Description
 * @Author Administrator
 * @Date 2020-03-30 15:47
 * @Version 1.0
 */
@org.springframework.stereotype.Service
public class ServiceInfoServiceImpl implements ServiceInfoService {

    @Autowired
    ServiceInfoMapper serviceInfoMapper;

    @Autowired
    ServicePriceService servicePriceService;

    @Autowired
    ServiceScenePicService serviceScenePicService;

    @Resource
    BusinessService businessService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertServiceInfo(Service service) {
        service.setState(Boolean.TRUE);
        serviceInfoMapper.insertServiceInfo(service);
        if (CollectionUtils.isNotEmpty(service.getPrices())) {
            for (ServicePrice price : service.getPrices()) {
                price.setService(service);
            }
        }
        if (CollectionUtils.isNotEmpty(service.getPics())) {
            for (ServiceScenePic pic : service.getPics()) {
                pic.setService(service);
            }
        }
        servicePriceService.insertServicePrice(service.getPrices());
        serviceScenePicService.insertServiceImage(service.getPics());
        businessService.updateHaveService(service.getBusiness().getBusinessNo(), true);
        return 1;
    }


    @Override
    public int updateServiceInfo(Service service) {
        serviceInfoMapper.updateServiceInfo(service);
        if (service.getPics() != null && service.getPics().size() > 0) {
            // 先删除图片
            serviceScenePicService.deleteServiceImage(service.getServiceID());
            List<ServiceScenePic> pics = service.getPics();
            for (ServiceScenePic pic : pics) {
                pic.setService(service);
            }
            serviceScenePicService.insertServiceImage(service.getPics());
        }

        if (service.getPrices() != null && service.getPrices().size() > 0) {
            // 先删除价格
            servicePriceService.deleteServicePrice(service.getServiceID());
            List<ServicePrice> prices = service.getPrices();
            for (ServicePrice price : prices) {
                price.setService(service);
            }
            servicePriceService.insertServicePrice(service.getPrices());
        }


        return 1;
    }

    @Override
    public List<Service> listServiceByBusinessNo(String businessNo, int offset, int limit, int state) {
        return serviceInfoMapper.listServiceByBusinessNo(businessNo, offset, limit, state);
    }

    @Override
    public int updateServiceState(long serviceId, Boolean state) {
        return serviceInfoMapper.updateState(serviceId, state);
    }

    @Override
    public List<Service> listByBusinessNoAndType(String businessNo, long serviceTypeNo) {
        return serviceInfoMapper.listByBusinessNoAndType(businessNo, serviceTypeNo);
    }
}
