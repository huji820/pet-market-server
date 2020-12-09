package com.yangwang.application.pet.market.model.params;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 搜索框搜索参数
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className QueryQueryListParam
 * @date 2020/3/25 10:01
 **/
@Data
@ApiModel(description = "搜索框搜索参数")
public class QueryQueryListParam extends BaseQueryParam {
    @ApiModelProperty(value = "关键字")
    String keyWord;
}
