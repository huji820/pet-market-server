package com.yangwang.application.pet.market.common.enums;

import lombok.Getter;

/**
 * 请求状态枚举
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className RespondCodeEnum
 * @date 2019/10/23 18:53
 **/
@Getter
public enum RespondCodeEnum {
    /*
     * 1、请求成功系列 10000
     * 2、数据校验 20000
     * 3、返回数据系列 30000
     * 4、
     * 4、系统异常系列90000
     *
     * */
    /***/
    SUCCESS(10000L, "请求成功"),
    PARAM_ERROR(20001L, "请求参数有误"),
    CHECK_ERROR(20002L, "校验错误"),
    CONTENT_VIOLATIONS(20003L,"请求参数包含违规字符"),
    IS_NULL_DATA(30001L, "数据为空"),
    INSERT_ERROR(30002L, "新增失败"),
    UPDATE_ERROR(30003L, "更新失败"),
    DELETE_ERROR(30004L, "删除失败！"),
    NOT_DISTRIBUTION(40001L, "还不属于分销商"),
    DISTRIBUTION_AUDITING(40002L, "分销商正在审核"),
    NOT_CERT_BUSINESS(40003L, "不是认证商家"),
    QUERY_ERR(30001L, "查询为空"),
    UNKNOWN_ERROR(99999L, "未知错误");

    private long code;
    private String message;


    RespondCodeEnum(long code, String message) {
        this.code = code;
        this.message = message;
    }

}