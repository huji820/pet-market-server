package com.yangwang.application.pet.market.model.common.signIn;

import com.yangwang.application.pet.market.model.business.Distribution;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 签到
 */
@Data
@ApiModel("签到")
public class SignIn {

    @ApiModelProperty("签到主键")
    Integer signInNo;

    @ApiModelProperty("签到人")
    String businessNo;

    @ApiModelProperty("连续签到次数")
    Integer continueTimes;

    @ApiModelProperty("总签到次数")
    Integer signInCount;

    @ApiModelProperty("总奖励积分")
    Integer awardCount;

    @ApiModelProperty("签到周期天数")
    Integer sn;

    public SignIn(String businessNo, Integer continueTimes, Integer signInCount, Integer awardCount, Integer sn) {
        this.businessNo = businessNo;
        this.continueTimes = continueTimes;
        this.signInCount = signInCount;
        this.awardCount = awardCount;
        this.sn = sn;
    }

    public SignIn() {
    }

    public static class Builder{

        private String businessNo;
        private Integer continueTimes;
        private Integer signInCount;
        private Integer awardCount;
        private Integer sn;

        public Builder businessNo(String businessNo){
            this.businessNo = businessNo;
            return this;
        }

        public Builder continueTimes(Integer continueTimes){
            this.continueTimes = continueTimes;
            return this;
        }

        public Builder signInCount(Integer signInCount){
            this.signInCount = signInCount;
            return this;
        }

        public Builder awardCount(Integer awardCount){
            this.awardCount = awardCount;
            return this;
        }

        public Builder sn(Integer sn){
            this.sn = sn;
            return this;
        }

        public SignIn build(){
            return new SignIn(businessNo, continueTimes, signInCount, awardCount, sn);
        }
    }
}
