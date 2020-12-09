package com.yangwang.application.pet.market.service.spring.common;

import com.yangwang.application.pet.market.dao.market.item.ItemDetailMapper;
import com.yangwang.application.pet.market.model.vo.ItemVo;
import com.yangwang.application.pet.market.service.facade.common.ItemDetailService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className ItemDetailServiceImpl
 * @date 2020/4/27 17:55
 **/
@Service
public class ItemDetailServiceImpl implements ItemDetailService {
    @Resource
    ItemDetailMapper itemDetailMapper;

    @Override
    public ItemVo get(int itemNo) {
        ItemVo itemVo = itemDetailMapper.get(itemNo);
        return itemVo;
    }
}
