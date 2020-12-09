package com.yangwang.application.pet.market.model.service;

import com.yangwang.application.pet.market.model.params.BaseQueryParam;
import com.yangwang.sysframework.utils.JsonUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 * <p>
 * 商家评价列表查询参数
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className QueryItemAppraiseListParam
 * @date 2020/3/24 11:31
 **/
@Data
@ApiModel(description = "商家评价列表查询参数")
public class QueryServiceAppraiseListParam extends BaseQueryParam {
    @ApiModelProperty(value = "宠物编号")
    int serviceId;

    @ApiModelProperty(value = "商家编号")
    String businessNo;

    @ApiModelProperty(value = "被评价的商家编号")
    String evaluatedBusinessNo;

    public static QueryServiceAppraiseListParam toObject(String jsonStr) {
        if (StringUtils.isNotBlank(jsonStr)) {
            try {
                return JsonUtil.formObject(jsonStr, QueryServiceAppraiseListParam.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
