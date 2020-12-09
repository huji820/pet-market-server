package com.yangwang.application.pet.market.model.vo;

import com.yangwang.application.pet.market.model.common.Item;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 商品订单信息vo
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className ItemOrderVo
 * @date 2020/3/30 10:00
 **/
@Data
@ApiModel(description = "商品订单信息vo")
public class ItemOrderInfoVo {

    @ApiModelProperty("商品编号")
    Item item;

    @ApiModelProperty("商品数量")
    Integer qty;

}
