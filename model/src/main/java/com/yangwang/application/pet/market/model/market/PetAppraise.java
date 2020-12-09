package com.yangwang.application.pet.market.model.market;

import com.yangwang.application.pet.market.model.common.Pet;
import com.yangwang.sysframework.utils.DateUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className PetAppraise
 * @date 2020/3/23 13
 **/
@Data
@ApiModel(value = "宠物评价")
public class PetAppraise extends BaseAppraise {
    @ApiModelProperty(value = "宠物")
    Pet pet;

    @ApiModelProperty(value = "宠物订单")
    PetOrder petOrder;

    /**
     * <p>
     * 设置默认数据
     * </p>
     *
     * @return com.yangwang.application.pet.market.model.market.PetAppraise
     * @author LiuXiangLin
     * @date 10:51 2020/3/23
     **/
    public PetAppraise defaultData() {
        appraiseDate = DateUtil.formatFull(new Date());
        return this;
    }
}
