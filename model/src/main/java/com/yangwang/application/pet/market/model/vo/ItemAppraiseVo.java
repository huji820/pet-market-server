package com.yangwang.application.pet.market.model.vo;

import com.yangwang.application.pet.market.common.utils.CollectionUtils;
import com.yangwang.application.pet.market.model.market.ItemAppraise;
import com.yangwang.application.pet.market.model.market.ItemAppraiseImg;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * <p>
 * 宠物评价VO
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className ItemAppraiseVo
 * @date 2020/3/24 9:14
 **/
@Data
@ApiModel(value = "宠物评价VO")
public class ItemAppraiseVo {
    @ApiModelProperty(value = "宠物评价")
    ItemAppraise itemAppraise;

    @ApiModelProperty(value = "宠物评价图片")
    List<ItemAppraiseImg> itemAppraiseImgList;

    public ItemAppraiseVo addAppraiseToList() {
        if (CollectionUtils.isNotEmpty(itemAppraiseImgList)) {
            for (ItemAppraiseImg itemAppraiseImg : itemAppraiseImgList) {
                itemAppraiseImg.setItemAppraise(itemAppraise);
            }
        }
        return this;
    }
}
