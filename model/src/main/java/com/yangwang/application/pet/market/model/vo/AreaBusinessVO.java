package com.yangwang.application.pet.market.model.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @TODO
 * @Description
 * @Author Administrator
 * @Date 2020-03-23 20:44
 * @Version 1.0
 */
@Data
@ApiModel(value = "区域内的商家")
@JsonIgnoreProperties(ignoreUnknown = true)
public class AreaBusinessVO {
    @ApiModelProperty(value = "区域")
    String area;

    @ApiModelProperty(value = "区域内商家数量")
    Integer num;

    @ApiModelProperty(value = "区域内商家列表")
    List<NearBusinessVO> businesses;
}
