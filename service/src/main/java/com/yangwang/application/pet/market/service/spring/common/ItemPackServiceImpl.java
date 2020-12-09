package com.yangwang.application.pet.market.service.spring.common;

import com.yangwang.application.pet.market.dao.market.item.ItemPackMapper;
import com.yangwang.application.pet.market.model.common.ItemPack;
import com.yangwang.application.pet.market.model.params.PagingQueryParam;
import com.yangwang.application.pet.market.service.facade.common.ItemPackService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * <p>
 *
 * </p>
 *
 * @author LiuXiangLin
 * @date 10:17 2020/3/22
 **/
@Service
public class ItemPackServiceImpl implements ItemPackService {
    @Resource
    ItemPackMapper itemPackMapper;

    @Override
    public List<ItemPack> listAll(PagingQueryParam pagingQueryParam) {
        return itemPackMapper.listByParam(pagingQueryParam);
    }
}
