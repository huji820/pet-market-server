package com.yangwang.application.pet.market.model.business;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * <p>
 * 商家余额vo
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className BusinessBalanceVo
 * @date 2020/4/2 9:49
 **/
@Data
public class BusinessBalanceVo {
    @ApiModelProperty(value = "金额总计")
    BigDecimal totalAmount;

    @ApiModelProperty(value = "冻结余额")
    BigDecimal bufferAmount;

    @ApiModelProperty(value = "可提现余额")
    BigDecimal useFulAmount;
}
