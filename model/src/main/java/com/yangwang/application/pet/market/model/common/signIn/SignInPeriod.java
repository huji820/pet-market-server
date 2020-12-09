package com.yangwang.application.pet.market.model.common.signIn;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("签到周期")
public class SignInPeriod {

    @ApiModelProperty("主键")
    Integer signInPeriodNo;

    @ApiModelProperty("奖励积分")
    Integer bonusPoints;

    @ApiModelProperty("周期天数")
    Integer sn;
}
