package com.yangwang.application.pet.market.dao.market.item;

import com.yangwang.application.pet.market.model.common.Item;
import com.yangwang.application.pet.market.model.common.Pet;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/***
 * <p>
 * 一键代发商家商品
 * </p>
 *
 **/
@Mapper
public interface ItemIssuedBehalfMapper {

    /**
     * 一键代发商品
     * @param item
     * @return
     */
    int save(@Param("item")Item item);

    /**
     * 获取商家所有一键代发的商品
     * @param businessNo
     * @return
     */
    List<Item> listByBusinessNo(@Param("businessNo") String businessNo);

    /**
     * 移除一键代发的商品
     * @param itemNo
     * @return
     */
    int removeByItemNo(@Param("itemNo") String itemNo);

    /**
     * 根据源头商品修改商品状态（上架与下架）
     * @param sourceItemNo
     * @param state
     * @return
     */
    int updateItemState(@Param("sourceItemNo") String sourceItemNo, @Param("state") int state);

}
