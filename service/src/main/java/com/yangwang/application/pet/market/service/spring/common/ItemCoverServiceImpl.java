package com.yangwang.application.pet.market.service.spring.common;

import com.yangwang.application.pet.market.common.utils.CollectionUtils;
import com.yangwang.application.pet.market.dao.market.item.ItemCoverMapper;
import com.yangwang.application.pet.market.model.common.Item;
import com.yangwang.application.pet.market.model.common.ItemCover;
import com.yangwang.application.pet.market.service.facade.common.ItemCoverService;
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
 * @className ItemCoverServiceImpl
 * @date 2020/4/9 10:34
 **/
@Service
public class ItemCoverServiceImpl implements ItemCoverService {
    @Resource
    ItemCoverMapper itemCoverMapper;

    @Override
    public int saveList(List<ItemCover> itemCoverList) {
        if (CollectionUtils.isNotEmpty(itemCoverList)) {
            return itemCoverMapper.saveList(itemCoverList);
        }
        return 0;
    }

    @Override
    public int deleteByItemNo(int itemNo) {
        return itemCoverMapper.deleteByItemNo(itemNo);
    }

    @Override
    public int update(List<ItemCover> itemCoverList, Item item) {
        itemCoverMapper.deleteByItemNo(item.getItemNo());
        if (CollectionUtils.isNotEmpty(itemCoverList)) {
            saveList(itemCoverList);
        }
        return 0;
    }
}
