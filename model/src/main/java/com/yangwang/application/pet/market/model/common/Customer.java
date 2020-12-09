package com.yangwang.application.pet.market.model.common;

import com.yangwang.application.pet.market.model.business.Business;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @description:
 * @param:
 * @return:
 * @author: LuZhiQiang
 * @date: 2019/10/16
 */

@Data
@ApiModel(value = "用户表")
public class Customer implements Serializable {

    @ApiModelProperty(value = "用户主键")
    String customerNo;

    @ApiModelProperty(value = "用户名称")
    String customerName;

    @ApiModelProperty(value = "手机")
    String phone;

    @ApiModelProperty(value = "图标")
    String headerImage;

    @ApiModelProperty(value = "性别")
    String sex;

    @ApiModelProperty(value = "openId")
    String openid;

    @ApiModelProperty(value = "unionId")
    String unionId;

    @ApiModelProperty(value = "最后登录时间")
    String lastLoginTime;

    @ApiModelProperty(value = "注册日期")
    String registrationDate;

    @ApiModelProperty(value = "注册时间")
    String registrationTime;

    @ApiModelProperty(value = "积分")
    BigDecimal points;

    @ApiModelProperty(value = "余额")
    BigDecimal balance;

    @ApiModelProperty(value = "分享商家")
    Business shareBusiness;

    @ApiModelProperty(value = "分享站")
    String shareStationNo;

    @ApiModelProperty(value = "验证码")
    String verifyCode;

    @ApiModelProperty(value = "是否开启商家")
    Business business;

    String sessionKey;

    public Customer(String customerNo, String customerName, String phone, String headerImage, String sex, String openid, String lastLoginTime, String registrationDate, String registrationTime, BigDecimal points, BigDecimal balance, String verifyCode, Business business) {
        this.customerNo = customerNo;
        this.customerName = customerName;
        this.phone = phone;
        this.headerImage = headerImage;
        this.sex = sex;
        this.openid = openid;
        this.lastLoginTime = lastLoginTime;
        this.registrationDate = registrationDate;
        this.registrationTime = registrationTime;
        this.points = points;
        this.balance = balance;
        this.verifyCode = verifyCode;
        this.business = business;
    }

    public Customer(String customerNo, String customerName, String phone, String headerImage, String sex, String openid, String lastLoginTime, String registrationDate, String registrationTime, BigDecimal points, BigDecimal balance, String verifyCode) {
        this.customerNo = customerNo;
        this.customerName = customerName;
        this.phone = phone;
        this.headerImage = headerImage;
        this.sex = sex;
        this.openid = openid;
        this.lastLoginTime = lastLoginTime;
        this.registrationDate = registrationDate;
        this.registrationTime = registrationTime;
        this.points = points;
        this.balance = balance;
        this.verifyCode = verifyCode;
    }

    public Customer() {
    }

    public Customer(String customerNo, String customerName, String phone, String headerImage, String sex, String openid,String unionId, String lastLoginTime, String registrationDate, String registrationTime, BigDecimal points, BigDecimal balance, Business shareBusiness) {
        this.customerNo = customerNo;
        this.customerName = customerName;
        this.phone = phone;
        this.headerImage = headerImage;
        this.unionId = unionId;
        this.sex = sex;
        this.openid = openid;
        this.lastLoginTime = lastLoginTime;
        this.registrationDate = registrationDate;
        this.registrationTime = registrationTime;
        this.points = points;
        this.balance = balance;
        this.shareBusiness = shareBusiness;
    }

    public Customer(String customerNo) {
        this.customerNo = customerNo;
    }
}
