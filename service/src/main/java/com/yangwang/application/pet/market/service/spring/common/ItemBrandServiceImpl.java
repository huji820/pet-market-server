package com.yangwang.application.pet.market.service.spring.common;

import com.yangwang.application.pet.market.dao.market.item.ItemBrandMapper;
import com.yangwang.application.pet.market.model.common.ItemBrand;
import com.yangwang.application.pet.market.model.params.PagingQueryParam;
import com.yangwang.application.pet.market.service.facade.common.ItemBrandService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description: 宠粮品牌
 * @param:
 * @return:
 * @author: LuZhiQiang
 * @date: 2019/10/29
 */
@Service
public class ItemBrandServiceImpl implements ItemBrandService {
    @Resource
    ItemBrandMapper itemBrandMapper;

    @Override
    public List<ItemBrand> listByParam(PagingQueryParam pagingQueryParam) {
        return itemBrandMapper.listByParam(pagingQueryParam);
    }
}
