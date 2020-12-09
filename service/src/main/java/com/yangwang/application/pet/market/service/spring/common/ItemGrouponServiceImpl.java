package com.yangwang.application.pet.market.service.spring.common;

import com.yangwang.application.pet.market.common.utils.CollectionUtils;
import com.yangwang.application.pet.market.dao.market.item.ItemGrouponMapper;
import com.yangwang.application.pet.market.model.common.Item;
import com.yangwang.application.pet.market.model.common.ItemGroupon;
import com.yangwang.application.pet.market.service.facade.common.ItemGrouponService;
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
 * @className ItemGrouponServiceImpl
 * @date 2020/4/9 10:08
 **/
@Service
public class ItemGrouponServiceImpl implements ItemGrouponService {
    @Resource
    ItemGrouponMapper itemGrouponMapper;

    @Override
    public int saveList(List<ItemGroupon> itemGrouponList) {
        if (CollectionUtils.isNotEmpty(itemGrouponList)) {
            return itemGrouponMapper.saveList(itemGrouponList);
        }
        return 0;
    }

    @Override
    public int update(List<ItemGroupon> itemGroupons, Item item) {
        itemGrouponMapper.deleteByItemNo(item.getItemNo());
        return saveList(itemGroupons);
    }
}
