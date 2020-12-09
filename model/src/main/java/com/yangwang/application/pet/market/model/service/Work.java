package com.yangwang.application.pet.market.model.service;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 美容作品
 * @Description
 * @Author Administrator
 * @Date 2020-03-20 23:29
 * @Version 1.0
 */
@Data
@ApiModel(value = "美容作品")
public class Work {

    @ApiModelProperty(value = "美容师主键")
    long workID;

    @ApiModelProperty(value = "所属服务")
    Service server;

    @ApiModelProperty(value = "作品图片")
    String workImage;

    @ApiModelProperty(value = "赞数量")
    int likeNum;

    @ApiModelProperty(value = "是否允许点赞")
    boolean allowLike;
}
