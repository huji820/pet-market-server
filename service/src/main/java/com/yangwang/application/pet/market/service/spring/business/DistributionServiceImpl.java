package com.yangwang.application.pet.market.service.spring.business;

import com.yangwang.application.pet.market.dao.business.DistributionMapper;
import com.yangwang.application.pet.market.model.business.Distribution;
import com.yangwang.application.pet.market.service.facade.service.DistributionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @TODO
 * @Description
 * @Author Administrator
 * @Date 2020-03-25 1:40
 * @Version 1.0
 */
@Service
public class DistributionServiceImpl implements DistributionService {

    @Resource
    DistributionMapper distributionMapper;

    @Override
    public List<Distribution> listDistribution(String businessNo, String startDate, String endDate, int offset, int limit) {
        return distributionMapper.listDistribution(businessNo, startDate, endDate, offset, limit);
    }

    @Override
    public int save(Distribution distribution) {
        return distributionMapper.save(distribution);
    }
}
