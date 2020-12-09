package com.yangwang.application.pet.market.service.facade.common;


import com.yangwang.application.pet.market.model.vo.DelShoppingCartVO;
import com.yangwang.application.pet.market.model.vo.ShoppingCartVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShoppingCartService {

    /**
     * @author yzz
     * @explain 添加购物车
     * @date 2020/3/11
     */
    int addShopingCart(int qty, String goodsNo,String businessNo,int goodsType);

    /**
     * @author yzz
     * @explain 查询购物车
     * @date 2020/3/12
     */
    List<ShoppingCartVO> queryShoppingCart(String businessNo,int start,int limit);


    /**
     * @author yzz
     * @explain 修改购物车数量
     * @date 2020/3/12
     */
    int updateShoppingCartQty(int qty,int goodsType,String businessNo,String goodsNo);


    /**
     * @author yzz
     * @explain 删除购物车
     * @date 2020/3/12
     */
    int delShoppingCart(List<DelShoppingCartVO> delShoppingCartVO);

}
