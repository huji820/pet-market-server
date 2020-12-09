package com.yangwang.application.pet.market.service.facade.common;


import com.yangwang.application.pet.market.model.common.Item;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 * 商品
 * </p>
 *
 * @author LiuXiangLin
 * @date 8:56 2020/3/22
 **/
public interface ItemService {
    /**
     * <p>
     * 新增商品
     * </p>
     *
     * @param item 商品对象
     * @return int
     * @author LiuXiangLin
     * @date 16:14 2020/3/22
     **/
    int save(Item item);

    /**
     * <p>
     * 通过商品编号获取商品
     * </p>
     *
     * @param itemNo 商品编号
     * @return com.yangwang.application.pet.market.model.common.Item
     * @author LiuXiangLin
     * @date 16:14 2020/3/22
     **/
    Item get(int itemNo);

    /**
     * <p>
     * 商品更新
     * </p>
     *
     * @param item 商品对象
     * @return int
     * @author LiuXiangLin
     * @date 16:14 2020/3/22
     **/
    int update(Item item);

    /**
     * <p>
     * 更新商品状态
     * </p>
     *
     * @param itemNo 商品编号
     * @param state  状态
     * @return int
     * @author LiuXiangLin
     * @date 16:31 2020/3/22
     **/
    int updateState(int itemNo, int state);

    /**
     * <p>
     * 添加商品的收藏量
     * </p>
     *
     * @param itemNo     商品编号
     * @param collection 需要添加的收藏量
     * @return int
     * @author LiuXiangLin
     * @date 9:56 2020/3/24
     **/
    int updateCollectionAdd(int itemNo, int collection);

    /**
     * <p>
     * 减少商品的收藏量
     * </p>
     *
     * @param itemNo     商品编号
     * @param collection 需要减少的收藏量
     * @return int
     * @author LiuXiangLin
     * @date 9:56 2020/3/24
     **/
    int updateCollectionSub(int itemNo, int collection);

    /**
     * <p>
     * 添加商品的评价数量
     * </p>
     *
     * @param itemNo     商品编号
     * @param evaluation 需要添加的评价数量
     * @return int
     * @author LiuXiangLin
     * @date 9:57 2020/3/24
     **/
    int updateEvaluationAdd(int itemNo, int evaluation);

    /**
     * <p>
     * 减少商品的评价数量
     * </p>
     *
     * @param itemNo     商品编号
     * @param evaluation 需要减少的评价数量
     * @return int
     * @author LiuXiangLin
     * @date 9:58 2020/3/24
     **/
    int updateEvaluationSub(int itemNo, int evaluation);

    /**
     * <p>
     * 更新商品的好评率
     * </p>
     *
     * @param itemNo        商品编号
     * @param favorableRate 好评率
     * @return int
     * @author LiuXiangLin
     * @date 9:58 2020/3/24
     **/
    int updateFavorableRate(int itemNo, BigDecimal favorableRate);

    /**
     * <p>
     * 添加销量
     * </p>
     *
     * @param itemNo      商品主键
     * @param salesVolume 销量
     * @return int
     * @author LiuXiangLin
     * @date 15:28 2020/4/28
     **/
    int updateSalesVolumeAdd(int itemNo, int salesVolume);

    /**
     * <p>
     * 给商品减销量
     * </p>
     *
     * @param itemNo      商品编号
     * @param salesVolume 销量
     * @return int
     * @author LiuXiangLin
     * @date 15:28 2020/4/28
     **/
    int updateSalesVolumeSub(int itemNo, int salesVolume);

    /**
     * <p>
     * 给商品减库存
     * </p>
     *
     * @param itemNo      商品编号
     * @param qty 库存
     * @return int
     * @author zhouxiaojian
     * @date 8:45 2020/7/25
     **/
    int updateQty(int itemNo, int qty);

    /**
     * 通过商品名称模糊查询获取商品编号
     * @param keyWord
     * @return
     */
    List<Integer> listItemNoByName(String keyWord);
}
