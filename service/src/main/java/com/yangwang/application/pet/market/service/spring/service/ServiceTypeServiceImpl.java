package com.yangwang.application.pet.market.service.spring.service;

import com.yangwang.application.pet.market.dao.service.ServiceTypeMapper;
import com.yangwang.application.pet.market.model.params.QueryServiceBusinessParam;
import com.yangwang.application.pet.market.model.service.ServiceType;
import com.yangwang.application.pet.market.model.vo.ServiceBusinessVO;
import com.yangwang.application.pet.market.service.facade.service.ServiceTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

/**
 * 服务分类实现
 *
 * @Description
 * @Author Administrator
 * @Date 2020-03-30 14:09
 * @Version 1.0
 */
@Service
public class ServiceTypeServiceImpl implements ServiceTypeService {

    @Resource
    ServiceTypeMapper serviceTypeMapper;

    @Override
    public List<ServiceType> listServiceType() {
        return serviceTypeMapper.listServiceType();
    }

    @Override
    public List<ServiceBusinessVO> listServiceBusiness(QueryServiceBusinessParam queryServiceBusinessParam) {
        List<ServiceBusinessVO> list = serviceTypeMapper.listServiceBusiness(queryServiceBusinessParam);
        for (ServiceBusinessVO vo : list) {
            vo.setDistance(vo.getDistance().divide(BigDecimal.valueOf(1000), 1, BigDecimal.ROUND_HALF_UP));
        }
        return list;
    }

    @Override
    public List<ServiceType> listByBusinessNo(String businessNo) {
        return serviceTypeMapper.listByBusinessNo(businessNo);
    }
}
