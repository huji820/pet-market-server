package com.yangwang.application.pet.market.service.spring.service;

import com.yangwang.application.pet.market.dao.market.item.ItemAppraiseListMapper;
import com.yangwang.application.pet.market.dao.service.ServiceAppraiseListMapper;
import com.yangwang.application.pet.market.model.params.QueryItemAppraiseListParam;
import com.yangwang.application.pet.market.model.service.QueryServiceAppraiseListParam;
import com.yangwang.application.pet.market.model.vo.ItemAppraiseVo;
import com.yangwang.application.pet.market.model.vo.ServiceAppraiseVo;
import com.yangwang.application.pet.market.service.facade.customer.ItemAppraiseListService;
import com.yangwang.application.pet.market.service.facade.service.ServiceAppraiseListService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className ItemAppraiseListServiceImpl
 * @date 2020/3/24 13:51
 **/
@Service
public class ServiceAppraiseListServiceImpl implements ServiceAppraiseListService {
    @Resource
    ServiceAppraiseListMapper serviceAppraiseListMapper;

    @Override
    public List<ServiceAppraiseVo> list(QueryServiceAppraiseListParam queryServiceAppraiseListParam) {
        return serviceAppraiseListMapper.listByParam(queryServiceAppraiseListParam);
    }
}
