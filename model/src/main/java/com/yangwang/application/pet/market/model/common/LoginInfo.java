package com.yangwang.application.pet.market.model.common;

import com.yangwang.sysframework.wechat.boot.model.WxUserInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 登录信息
 * </p>
 *
 * @author LiuXiangLin
 * @date 14:05 2020/3/25
 **/
@Data
@ApiModel(description = "登录信息")
public class LoginInfo {
    @ApiModelProperty(value = "微信登入code")
    String code;

    @ApiModelProperty(value = "加密数据")
    String encryptedData;

    @ApiModelProperty(value = "偏移量")
    String iv;

    @ApiModelProperty(value = "微信用户信息")
    WxUserInfo wxUserInfo;

    @ApiModelProperty(value = "分享人openid")
    String shareOpenId;
}
