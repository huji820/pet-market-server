package com.yangwang.application.pet.market.service.spring.common;

import com.yangwang.application.pet.market.dao.market.item.ItemGrouponListMapper;
import com.yangwang.application.pet.market.model.params.QueryItemListParam;
import com.yangwang.application.pet.market.model.vo.ItemVo;
import com.yangwang.application.pet.market.service.facade.common.ItemGrouponListService;
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
 * @className ItemGrouponListServiceImpl
 * @date 2020/5/26 10:18
 **/
@Service
public class ItemGrouponListServiceImpl implements ItemGrouponListService {
    @Resource
    ItemGrouponListMapper itemGrouponListMapper;

    @Override
    public List<ItemVo> listByParam(QueryItemListParam queryItemListParam) {
        return itemGrouponListMapper.listByParam(queryItemListParam);
    }
}
