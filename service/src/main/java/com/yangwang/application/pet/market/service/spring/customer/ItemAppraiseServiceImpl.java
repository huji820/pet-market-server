package com.yangwang.application.pet.market.service.spring.customer;

import com.yangwang.application.pet.market.dao.market.item.ItemAppraiseMapper;
import com.yangwang.application.pet.market.model.market.*;
import com.yangwang.application.pet.market.service.facade.customer.ItemAppraiseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * <p>
 *
 * </p>
 *
 * @author LiuXiangLin
 * @date 9:27 2020/3/24
 **/
@Service
public class ItemAppraiseServiceImpl implements ItemAppraiseService {
    @Resource
    ItemAppraiseMapper itemAppraiseMapper;

    @Override
    public int save(ItemAppraise itemAppraise) {
        return itemAppraiseMapper.save(itemAppraise);

    }

    @Override
    public int delete(int itemAppraiseNo) {
        return itemAppraiseMapper.delete(itemAppraiseNo);
    }

    @Override
    public ItemAppraise getByAppraise(ItemAppraise itemAppraise) {
        return itemAppraiseMapper.getByAppraise(itemAppraise);
    }

    @Override
    public ItemAppraise get(int itemAppraiseNo) {
        return itemAppraiseMapper.get(itemAppraiseNo);
    }

    @Override
    public int countByItemNo(int itemNo) {
        return itemAppraiseMapper.countByItemNo(itemNo);
    }

    @Override
    public int countByItemNoAndUpPraiseDegree(int itemNo, int praiseDegree) {
        return itemAppraiseMapper.countByItemNoAndUpPraiseDegree(itemNo, praiseDegree);
    }
}
