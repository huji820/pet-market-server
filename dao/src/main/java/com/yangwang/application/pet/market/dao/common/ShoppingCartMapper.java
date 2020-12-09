package com.yangwang.application.pet.market.dao.common;

import com.yangwang.application.pet.market.model.vo.DelShoppingCartVO;
import com.yangwang.application.pet.market.model.vo.ShoppingCartVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yzz
 * @date 2020/3/11 18:07
 */
@Mapper
public interface ShoppingCartMapper {

    /**
     * @author yzz
     * @explain 添加购物车
     * @date 2020/3/11
     */
    int addShopingCart(@Param("qty") int qty,
                       @Param("goodsNo") String goodsNo,
                       @Param("businessNo") String businessNo,
                       @Param("createTime") String createTime,
                       @Param("goodsType") int goodsType);

    /**
     * @author yzz
     * @explain 查询购物车
     * @date 2020/3/12
     */
    List<ShoppingCartVO> queryShoppingCart( @Param("businessNo") String businessNo,
                                            @Param("start")int start,
                                            @Param("limit")int limit);


    /**
     * @author yzz
     * @explain 修改购物车数量
     * @date 2020/3/12
     */
    int updateShoppingCartQty(@Param("qty") int qty,
                              @Param("goodsType") int goodsType,
                              @Param("businessNo") String businessNo,
                              @Param("goodsNo") String goodsNo);


    /**
     * @author yzz
     * @explain 删除购物车
     * @date 2020/3/12
     */
    int delShoppingCart(@Param("delShoppingCartVO")List<DelShoppingCartVO> delShoppingCartVO);

}
