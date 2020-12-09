package com.yangwang.application.pet.market.model.vo;

import com.yangwang.application.pet.market.model.business.Distribution;
import com.yangwang.application.pet.market.model.market.BaseOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 分销VO
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className DistributionVo
 * @date 2020/6/4 11:24
 **/
@Data
@ApiModel(description = "分销VO")
public class DistributionVo extends Distribution {
    @ApiModelProperty(value = "所属订单")
    BaseOrder baseOrder;
}
