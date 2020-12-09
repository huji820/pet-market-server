package com.yangwang.application.pet.market.model.market;

import com.yangwang.application.pet.market.model.business.Business;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * <p>
 * 积分流水
 * </p>
 *
 * @author LiuXiangLin
 * @date 10:31 2020/3/19
 **/
@ApiModel(value = "积分流水表")
@Data
public class CreditFlow {
    @ApiModelProperty(value = "流水编号")
    String flowNo;

    @ApiModelProperty(value = "所属用户")
    Business business;

    @ApiModelProperty(value = "流水时间")
    String dateTime;

    @ApiModelProperty(value = "本次积分")
    Integer credit;

    @ApiModelProperty(value = "积分总计")
    Integer totalCredit;

    @ApiModelProperty(value = "单据编号")
    String billNo;

    @ApiModelProperty(value = "相关单号")
    String linkNo;

    @ApiModelProperty(value = "流水类型")
    String type;

    public CreditFlow() {
    }

    public CreditFlow(Business business,
                      String dateTime,
                      Integer credit,
                      Integer totalCredit,
                      String billNo,
                      String linkNo,
                      String type) {
        this.business = business;
        this.dateTime = dateTime;
        this.credit = credit;
        this.totalCredit = totalCredit;
        this.billNo = billNo;
        this.linkNo = linkNo;
        this.type = type;
    }
}
