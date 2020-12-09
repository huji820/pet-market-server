package com.yangwang.application.pet.market.model.assess;

import com.yangwang.application.pet.market.model.business.Business;
import com.yangwang.application.pet.market.model.common.Item;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 申请评测
 *
 * @Description
 * @Author Administrator
 * @Date 2020-05-15 2:53
 * @Version 1.0
 */
@ApiModel(value = "申请商品评测")
@Data
public class AssessApply {

    @ApiModelProperty("申请评测主键")
    Long applyNo;

    @ApiModelProperty("申请人")
    Business business;

    @ApiModelProperty("评测商品")
    Assess assess;

    @ApiModelProperty("申请时间")
    String applyTime;

    @ApiModelProperty("申请状态")
    int applyStatus;

    @ApiModelProperty("测评是否回复")
    boolean assessFeedBack;

    public AssessApply(Long applyNo, Business business, Assess assess, String applyTime, int applyStatus, boolean assessFeedBack) {
        this.applyNo = applyNo;
        this.business = business;
        this.assess = assess;
        this.applyTime = applyTime;
        this.applyStatus = applyStatus;
        this.assessFeedBack = assessFeedBack;
    }

    public AssessApply() {
    }
}
