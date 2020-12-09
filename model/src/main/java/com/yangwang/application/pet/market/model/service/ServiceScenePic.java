package com.yangwang.application.pet.market.model.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 平台服务
 * @Description
 * @Author Administrator
 * @Date 2020-03-20 21:53
 * @Version 1.0
 */
@Data
@ApiModel(value = "平台服务")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ServiceScenePic {

    @ApiModelProperty(value = "所属服务")
    Service service;

    @ApiModelProperty(value = "现场图片")
    String scenePic;
}
