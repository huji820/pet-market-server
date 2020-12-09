package com.yangwang.application.pet.market.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author yang hituzi
 * @description 短信验证码
 * @date 2019年10月31日 09:51:34
 */
@Data
@ApiModel(value = "短信验证码")
public class SmsVO implements Serializable {

    private static final long serialVersionUID = -2215322171308131962L;

    @ApiModelProperty(value = "发送短信验证码的手机号")
    String phone;

    @ApiModelProperty(value = "发送的短信验证码")
    String code;

    public SmsVO() {
    }

    public SmsVO(String phone, String code) {
        this.phone = phone;
        this.code = code;
    }
}
