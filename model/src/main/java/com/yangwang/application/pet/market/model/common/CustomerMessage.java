package com.yangwang.application.pet.market.model.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author yang hituzi
 * @description 站内信(推送消息)
 * @date 2020年4月13日 10:23:24
 */
@Data
@ApiModel(value = "站内信/推送消息")
public class CustomerMessage {

    @ApiModelProperty(value = "推送自增主键")
    Integer messageNo;

    @ApiModelProperty(value = "发送商家编号")
    String sendNo;

    @ApiModelProperty(value = "接收人/商家编号")
    String receiveNo;

    @ApiModelProperty(value = "推送消息标题")
    String messageTitle;

    @ApiModelProperty(value = "推送消息正文")
    String messageContent;

    @ApiModelProperty(value = "推送消息状态")
    String status;

    @ApiModelProperty(value = "发送时间")
    String sendTime;

    @ApiModelProperty(value = "更新时间")
    String updateTime;

    @ApiModelProperty(value = "链接")
    String link;

    public CustomerMessage() {
    }

    public CustomerMessage(String receiveNo, String messageTitle, String messageContent, String status, String sendTime, String updateTime, String link) {
        this.receiveNo = receiveNo;
        this.messageTitle = messageTitle;
        this.messageContent = messageContent;
        this.status = status;
        this.sendTime = sendTime;
        this.updateTime = updateTime;
        this.link = link;
    }
}
