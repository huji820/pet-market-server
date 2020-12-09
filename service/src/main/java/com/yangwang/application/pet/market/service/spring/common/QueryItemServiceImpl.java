package com.yangwang.application.pet.market.service.spring.common;

import com.yangwang.application.pet.market.dao.common.QueryItemMapper;
import com.yangwang.application.pet.market.model.common.Item;
import com.yangwang.application.pet.market.model.common.ItemBrand;
import com.yangwang.application.pet.market.model.params.QueryQueryListParam;
import com.yangwang.application.pet.market.service.facade.common.QueryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 查询商品品牌
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className QueryItemBrandServiceImpl
 * @date 2020/3/25 10:12
 **/
@Service
public class QueryItemServiceImpl implements QueryService<Item> {
    @Resource
    QueryItemMapper queryItemBrandMapper;

    @Override
    public List<Item> query(QueryQueryListParam queryQueryListParam) {
        return queryItemBrandMapper.listByParam(queryQueryListParam);
    }
}
