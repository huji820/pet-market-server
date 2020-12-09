package com.yangwang.application.pet.market.service.spring.business;

import com.yangwang.application.pet.market.common.utils.CollectionUtils;
import com.yangwang.application.pet.market.dao.business.SupplyRelationMapper;
import com.yangwang.application.pet.market.model.business.Business;
import com.yangwang.application.pet.market.service.facade.business.SupplyRelationService;
import com.yangwang.application.pet.market.service.service.BusinessService;
import com.yangwang.sysframework.utils.TypeConvertUtil;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *   厂家和分仓关联service实现类
 * </p>
 * @Author zhouxiaojian
 * @Date 2020/8/21 15:13
 * @Version 1.0
 */
@Service
public class SupplyRelationServiceImpl implements SupplyRelationService {

    @Resource
    SupplyRelationMapper supplyRelationMapper;

    @Resource
    BusinessService businessService;

    @Override
    public int addSubWarehouse(List<String> businessNoList, String manufactorNo) {
        if(CollectionUtils.isNotEmpty(businessNoList)){
            for (String businessNo : businessNoList){
                supplyRelationMapper.addSubWarehouse(businessNo, manufactorNo);
            }
        }
        return 1;
    }

    @Override
    public List<Business> listManufactor(String businessNo) {
        List<Business> businessList = new ArrayList<>();
        //获取所有厂家编号
        List<String> manufactors = supplyRelationMapper.listManufactor(businessNo);
        if(CollectionUtils.isNotEmpty(manufactors)){
            for(String manufactor : manufactors){
                Business business = businessService.getByBusinessNoWithOutState(manufactor);
                businessList.add(business);
            }
        }
        return businessList;
    }

    @Override
    public List<Business> listSubWarehouse(String businessNo) {
        List<Business> businessList = new ArrayList<>();
        //获取所有分仓编号
        List<String> subWarehouses = supplyRelationMapper.listSubWarehouse(businessNo);
        if(CollectionUtils.isNotEmpty(subWarehouses)){
            for(String subWarehouse : subWarehouses){
                Business business = businessService.getByBusinessNoWithOutState(subWarehouse);
                businessList.add(business);
            }
        }
        return businessList;
    }
}
