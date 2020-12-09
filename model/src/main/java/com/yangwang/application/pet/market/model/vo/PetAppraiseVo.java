package com.yangwang.application.pet.market.model.vo;

import com.yangwang.application.pet.market.common.utils.CollectionUtils;
import com.yangwang.application.pet.market.model.market.PetAppraise;
import com.yangwang.application.pet.market.model.market.PetAppraiseImg;
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
 * @className PetAppraiseVo
 * @date 2020/3/23 17:00
 **/
@Data
public class PetAppraiseVo {
    @ApiModelProperty(value = "宠物评价")
    PetAppraise petAppraise;

    @ApiModelProperty(value = "宠物图片列表")
    List<PetAppraiseImg> petAppraiseImgList;

    /***
     * <p>
     * 给集合添加评价对象
     * </p>
     *
     * @return com.yangwang.application.pet.market.model.vo.PetAppraiseVo
     * @author LiuXiangLin
     * @date 17:05 2020/3/23
     **/
    public PetAppraiseVo addAppraiseToList() {
        if (CollectionUtils.isNotEmpty(petAppraiseImgList)) {
            for (PetAppraiseImg petAppraiseImg : petAppraiseImgList) {
                petAppraiseImg.setPetAppraise(petAppraise);
            }
        }
        return this;
    }
}
