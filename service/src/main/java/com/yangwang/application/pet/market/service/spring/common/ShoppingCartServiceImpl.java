package com.yangwang.application.pet.market.service.spring.common;


import com.yangwang.application.pet.market.dao.common.ShoppingCartMapper;
import com.yangwang.application.pet.market.model.vo.DelShoppingCartVO;
import com.yangwang.application.pet.market.model.vo.ShoppingCartVO;
import com.yangwang.application.pet.market.service.facade.common.ShoppingCartService;
import com.yangwang.sysframework.utils.DateUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Resource
    ShoppingCartMapper shoppingCartMapper;

    @Override
    public int addShopingCart(int qty, String goodsNo,String businessNo,int goodsType) {
        String date= DateUtil.format(new Date(),DateUtil.FORMAT_SIMPLE);
        return shoppingCartMapper.addShopingCart(qty, goodsNo, businessNo, date, goodsType);
    }

    @Override
    public List<ShoppingCartVO> queryShoppingCart(String businessNo,int start,int limit) {
        return shoppingCartMapper.queryShoppingCart(businessNo, start, limit);
    }

    @Override
    public int updateShoppingCartQty(int qty, int goodsType, String businessNo, String goodsNo) {
        return shoppingCartMapper.updateShoppingCartQty(qty, goodsType, businessNo, goodsNo);
    }

    @Override
    public int delShoppingCart(List<DelShoppingCartVO> delShoppingCartVO) {
        return shoppingCartMapper.delShoppingCart(delShoppingCartVO);
    }
}
