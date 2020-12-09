package com.yangwang.application.pet.market.model.common.signIn;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 签到记录实体类
 * date: 2020/08/20
 */
@Data
@ApiModel("签到记录")
public class SignInHistory {

    @ApiModelProperty("主键")
    Integer signInHistoryNo;

    @ApiModelProperty("签到人")
    String businessNo;

    @ApiModelProperty("奖励积分")
    Integer rewardPoints;

    @ApiModelProperty("签到日期 yyyy-MM-dd")
    String date;

    @ApiModelProperty("签到时间 HH:mm:ss")
    String time;

    @ApiModelProperty("签到星期")
    String week;

    public SignInHistory(String businessNo, Integer rewardPoints, String date, String time, String week) {
        this.businessNo = businessNo;
        this.rewardPoints = rewardPoints;
        this.date = date;
        this.time = time;
        this.week = week;
    }

    public SignInHistory() {
    }

    public static class Bulider{

        private String businessNo;
        private Integer rewardPoints;
        private String date;
        private String time;
        private String week;

        public Bulider businessNo(String businessNo){
            this.businessNo = businessNo;
            return this;
        }
        public Bulider rewardPoints(Integer rewardPoints){
            this.rewardPoints = rewardPoints;
            return this;
        }
        public Bulider date(String date){
            this.date = date;
            return this;
        }
        public Bulider time(String time){
            this.time = time;
            return this;
        }
        public Bulider week(String week){
            this.week = week;
            return this;
        }

        public SignInHistory build(){
            return new SignInHistory(businessNo, rewardPoints, date, time, week);
        }
    }
}
