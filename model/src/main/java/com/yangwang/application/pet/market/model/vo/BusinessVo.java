package com.yangwang.application.pet.market.model.vo;


import com.yangwang.application.pet.market.model.business.Bond;
import com.yangwang.application.pet.market.model.business.Business;
import com.yangwang.application.pet.market.model.market.PetOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @program: trunk
 *
 * @description: 商品资料视图模型
 *
 * @author: LSY
 *
 * @create: 2019-10-30
 **/
@Data
@ApiModel(description = "商家")
public class BusinessVo extends Business {
    @ApiModelProperty(value = "在售宠物")
    String saleCount;

    @ApiModelProperty(value = "好评数")
    String praiseCount;

    @ApiModelProperty(value = "保证金")
    Bond bond;

    @ApiModelProperty(value = "宠物订单")
    List<PetOrder> petOrderList;

    @ApiModelProperty(value = "退款单号")
    String refundNo;
}
