package com.yangwang.application.pet.market.model.business;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.text.Bidi;

/**
 * @TODO
 * @Description
 * @Author Administrator
 * @Date 2020-03-25 0:10
 * @Version 1.0
 */
@Data
@ApiModel(value = "分销表")
public class Distribution {

    @ApiModelProperty(value = "分销主键")
    long distributionID;

    @ApiModelProperty(value = "商家")
    Business seller;

    @ApiModelProperty(value = "购买人")
    Business buyer;

    @ApiModelProperty(value = "分销员")
    Business distributor;

    @ApiModelProperty(value = "创建时间")
    String createDate;

    @ApiModelProperty(value = "原单金额")
    BigDecimal originalAmount;

    @ApiModelProperty(value = "获得金额")
    BigDecimal getAmount;

    @ApiModelProperty(value = "相关单据")
    String linkNo;

    public Distribution() {
    }

    public Distribution(Business seller, Business buyer, Business distributor, String createDate, BigDecimal originalAmount, BigDecimal getAmount, String linkNo) {
        this.seller = seller;
        this.buyer = buyer;
        this.distributor = distributor;
        this.createDate = createDate;
        this.originalAmount = originalAmount;
        this.getAmount = getAmount;
        this.linkNo = linkNo;
    }

   public static class Builder {
        private Business seller;
        private Business buyer;
        private Business distributor;
        private String createDate;
        private BigDecimal originalAmount;
        private BigDecimal getAmount;
        private String linkNo;

        public Builder seller(Business seller) {
            this.seller = seller;
            return this;
        }

        public Builder buyer(Business buyer) {
            this.buyer = buyer;
            return this;
        }

        public Builder distributor(Business distributor) {
            this.distributor = distributor;
            return this;
        }

        public Builder createDate(String createDate) {
            this.createDate = createDate;
            return this;
        }

        public Builder originalAmount(BigDecimal originalAmount) {
            this.originalAmount = originalAmount;
            return this;
        }

        public Builder getAmount(BigDecimal getAmount) {
            this.getAmount = getAmount;
            return this;
        }

        public Builder linkNo(String linkNo) {
            this.linkNo = linkNo;
            return this;
        }

        public Distribution build() {
            return new Distribution(seller, buyer, distributor, createDate, originalAmount, getAmount, linkNo);
        }
    }
}
