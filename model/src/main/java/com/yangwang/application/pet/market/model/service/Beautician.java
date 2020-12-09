package com.yangwang.application.pet.market.model.service;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 美容师
 *
 * @Description
 * @Author Administrator
 * @Date 2020-03-20 23:29
 * @Version 1.0
 */
@Data
@ApiModel(value = "美容师")
public class Beautician {

    @ApiModelProperty(value = "美容师主键")
    long beauticianID;

    @ApiModelProperty(value = "美容师名称")
    String beauticianName;

    @ApiModelProperty(value = "职称")
    String title;

    @ApiModelProperty(value = "美容师描述 ")
    String describe;

    @ApiModelProperty(value = "擅长")
    String goodAt;

    @ApiModelProperty(value = "头像")
    String headerImg;

    @ApiModelProperty(value = "作品图片级")
    List<Work> works;

    @ApiModelProperty(value = "评价列表")
    List<ServiceAppraise> serviceAppraises;

    @ApiModelProperty(value = "服务单量")
    int serverNum;

    @ApiModelProperty(value = "好评率")
    int favorableRate;
}
