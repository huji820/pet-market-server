package com.yangwang.application.pet.market.dao.market.item;

import com.yangwang.application.pet.market.model.common.Item;
import com.yangwang.application.pet.market.model.vo.ItemVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 * 商品
 * </p>
 *
 * @author LiuXiangLin
 * @date 17:36 2020/3/21
 **/
@Mapper
public interface ItemMapper {
    /**
     * <p>
     * 保存
     * </p>
     *
     * @param item 商品
     * @return int
     * @author LiuXiangLin
     * @date 17:38 2020/3/21
     **/
    int save(@Param("item") Item item);

    /**
     * <p>
     * 通过主键获取商品
     * </p>
     *
     * @param itemNo 商品编号
     * @return com.yangwang.application.pet.market.model.common.Item
     * @author LiuXiangLin
     * @date 17:39 2020/3/21
     **/
    Item get(@Param("itemNo") int itemNo);

    /**
     * <p>
     * 更新商品
     * </p>
     *
     * @param item 商品对象
     * @return int
     * @author LiuXiangLin
     * @date 17:40 2020/3/21
     **/
    int update(@Param("item") Item item);

    /**
     * <p>
     * 修改商品状态
     * </p>
     *
     * @param itemNo 商品编号
     * @param state  商品状态
     * @return int
     * @author LiuXiangLin
     * @date 16:28 2020/3/22
     **/
    int updateState(@Param("itemNo") int itemNo, @Param("state") int state);

    /**
     * <p>
     * 添加商品的收藏量
     * </p>
     *
     * @param itemNo        商品编号
     * @param collectionQty 收藏量
     * @return int
     * @author LiuXiangLin
     * @date 10:00 2020/3/24
     **/
    int addCollectionQty(@Param("itemNo") int itemNo, @Param("collectionQty") int collectionQty);

    /**
     * <p>
     * 添加商品的评价数量
     * </p>
     *
     * @param itemNo        商品编号
     * @param evaluationQty 评价数量
     * @return int
     * @author LiuXiangLin
     * @date 10:01 2020/3/24
     **/
    int addEvaluationQty(@Param("itemNo") int itemNo, @Param("evaluationQty") int evaluationQty);

    /**
     * <p>
     * 修改商品的好评率
     * </p>
     *
     * @param itemNo        宠物编号
     * @param favorableRate 好评率
     * @return int
     * @author LiuXiangLin
     * @date 10:02 2020/3/24
     **/
    int updateFavorableRate(@Param("itemNo") int itemNo, @Param("favorableRate") BigDecimal favorableRate);

    /**
     * <p>
     * 添加商品销量
     * </p>
     *
     * @param itemNo      商品编号
     * @param salesVolume 销量
     * @return int
     * @author LiuXiangLin
     * @date 15:30 2020/4/28
     **/
    int updateSalesVolumeQty(@Param("itemNo") int itemNo, @Param("salesVolume") int salesVolume);

    /**
     * <p>
     * 减少商品库存
     * </p>
     *
     * @param itemNo      商品编号
     * @param qty 库存
     * @return int
     * @author zhouxiaojian
     * @date 8:45 2020/7/25
     **/
    int updateQty(@Param("itemNo")int itemNo,@Param("qty")int qty);

    /**
     * 通过商品名称模糊查询获取商品编号
     * @param keyWord
     * @return
     */
    List<Integer> listItemNoByName(@Param("keyWord")String keyWord);
}
