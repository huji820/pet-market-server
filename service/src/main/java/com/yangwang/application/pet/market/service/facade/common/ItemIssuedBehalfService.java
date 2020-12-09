package com.yangwang.application.pet.market.service.facade.common;

import com.yangwang.application.pet.market.model.common.Item;
import com.yangwang.application.pet.market.model.common.Pet;

import java.util.List;

/***
 * <p>
 * 一键代发商家商品
 * </p>
 *
 **/
public interface ItemIssuedBehalfService {


    /**
     * 一键代发商品
     * @param itemNo
     * @param businessNo
     * @return
     */
    int save(String itemNo, String businessNo);

    /**
     * 获取商家所有一键代发的商品
     * @param businessNo
     * @return
     */
    List<Item> listByBusinessNo(String businessNo);

    /**
     * 移除一键代发的商品
     * @param itemNo
     * @return
     */
    int removeItemByItemNo(String itemNo);

    /**
     * 根据源头商品修改商品状态（上架与下架）
     * @param sourceItemNo
     * @param state
     * @return
     */
    int updateItemState(String sourceItemNo, int state);

}
