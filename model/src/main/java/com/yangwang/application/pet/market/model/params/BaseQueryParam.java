package com.yangwang.application.pet.market.model.params;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 抽象查询对象
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className BaseQueryParam
 * @date 2020/3/20 10:19
 **/
@ApiModel
@Data
public abstract class BaseQueryParam {
    @ApiModelProperty(value = "排除条数")
    Integer offset;

    @ApiModelProperty(value = "显示条数")
    Integer limit;

    public void dealWithParam() {
        if (offset == null) {
            offset = 0;
        }
        if (limit == null || limit == 0) {
            limit = 6;
        }
    }
}
