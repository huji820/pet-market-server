package com.yangwang.application.pet.market.service.spring.common;

import com.yangwang.application.pet.market.dao.market.item.ItemTypeMapper;
import com.yangwang.application.pet.market.model.common.ItemType;
import com.yangwang.application.pet.market.model.params.PagingQueryParam;
import com.yangwang.application.pet.market.service.facade.common.ItemTypeService;
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
 * @className ItemTypeServiceImpl
 * @date 2020/3/22 10:53
 **/
@Service
public class ItemTypeServiceImpl implements ItemTypeService {
    @Resource
    ItemTypeMapper itemTypeMapper;

    @Override
    public List<ItemType> listByParam(PagingQueryParam pagingQueryParam) {
        return itemTypeMapper.listByParam(pagingQueryParam);
    }
}
