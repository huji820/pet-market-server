package com.yangwang.application.pet.market.service.spring.customer;

import com.yangwang.application.pet.market.dao.market.item.ItemAppraiseListMapper;
import com.yangwang.application.pet.market.model.params.QueryItemAppraiseListParam;
import com.yangwang.application.pet.market.model.vo.ItemAppraiseVo;
import com.yangwang.application.pet.market.service.facade.customer.ItemAppraiseListService;
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
 * @className ItemAppraiseListServiceImpl
 * @date 2020/3/24 13:51
 **/
@Service
public class ItemAppraiseListServiceImpl implements ItemAppraiseListService {
    @Resource
    ItemAppraiseListMapper itemAppraiseListMapper;

    @Override
    public List<ItemAppraiseVo> list(QueryItemAppraiseListParam queryItemAppraiseListParam) {
        return itemAppraiseListMapper.listByParam(queryItemAppraiseListParam);
    }
}
