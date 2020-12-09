package com.yangwang.application.pet.market.model.params;

import com.yangwang.sysframework.utils.JsonUtil;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 * <p>
 * 宠物列表查询参数
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className QueryPetAppraiseListParam
 * @date 2020/3/23 17:35
 **/
@Data
public class QueryPetAppraiseListParam extends BaseQueryParam {
    @ApiModelProperty(value = "宠物编号")
    String petNo;

    @ApiModelProperty(value = "商家编号")
    String businessNo;

    @ApiModelProperty(value = "被评价的商家编号")
    String evaluatedBusinessNo;

    public static QueryPetAppraiseListParam toObject(String jsonStr) {
        if (StringUtils.isNotBlank(jsonStr)) {
            try {
                return JsonUtil.formObject(jsonStr, QueryPetAppraiseListParam.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
