package com.yangwang.application.pet.market.service.spring.common;

import com.yangwang.application.pet.market.dao.market.item.ItemOrderInfoMapper;
import com.yangwang.application.pet.market.model.market.ItemOrderInfo;
import com.yangwang.application.pet.market.service.facade.common.ItemOrderInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *   商品订单详情service实现类
 * </p>
 *
 * @Author zhouxiaojian
 * @Date 2020/9/5 10:08
 * @Version 1.0
 */
@Service
public class ItemOrderInfoServiceImpl implements ItemOrderInfoService {

    @Resource
    ItemOrderInfoMapper itemOrderInfoMapper;

    @Override
    public int save(ItemOrderInfo itemOrderInfo) {
        return itemOrderInfoMapper.save(itemOrderInfo);
    }

    @Override
    public List<ItemOrderInfo> listByOrderNo(String orderNo) {
        return itemOrderInfoMapper.listByOrderNo(orderNo);
    }

    @Override
    public ItemOrderInfo getByOrderInfoNo(String orderInfoNo) {
        return itemOrderInfoMapper.getByOrderInfoNo(orderInfoNo);
    }
}
