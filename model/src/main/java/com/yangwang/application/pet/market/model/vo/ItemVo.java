package com.yangwang.application.pet.market.model.vo;

import com.yangwang.application.pet.market.model.common.Item;
import com.yangwang.application.pet.market.model.common.ItemCover;
import com.yangwang.application.pet.market.model.common.ItemGroupon;
import com.yangwang.application.pet.market.model.market.ItemOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * <p>
 * 商品vo
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className ItemVo
 * @date 2020/4/9 9:07
 **/
@Data
@ApiModel(description = "商品vo")
public class ItemVo {
    @ApiModelProperty(value = "商品")
    Item item;

    @ApiModelProperty(value = "商品封面图片")
    List<ItemCover> itemCoverList;

    @ApiModelProperty(value = "团购梯度")
    List<ItemGroupon> itemGrouponList;

    @ApiModelProperty(value = "销售历史记录")
    List<ItemOrder> itemOrderList;
}
