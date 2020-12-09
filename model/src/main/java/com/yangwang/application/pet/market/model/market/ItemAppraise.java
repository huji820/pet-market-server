package com.yangwang.application.pet.market.model.market;

/**
 * <p>
 * 商品评价
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className ItemAppraise
 * @date 2020/3/23 10:28
 **/

import com.yangwang.application.pet.market.model.common.Item;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 商品评价
 * </p>
 *
 * @author LiuXiangLin
 * @date 10:28 2020/3/23
 **/
@Data
public class ItemAppraise extends BaseAppraise {

    @ApiModelProperty(value = "商品")
    Item item;

    @ApiModelProperty(value = "商品订单")
    ItemOrder itemOrder;
}
