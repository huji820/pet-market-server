package com.yangwang.application.pet.market.model.params;

import com.yangwang.sysframework.utils.JsonUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 * <p>
 * 商家宠物列表
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className QueryPetBusinessListParam
 * @date 2020/3/20 9:22
 **/
@Data
@ApiModel(value = "宠物列表查询对象")
public class QueryPetBusinessListParam extends BaseQueryParam {
    @ApiModelProperty(value = "商家编号")
    String businessNo;

    @ApiModelProperty(value = "宠物编号")
    String petNo;

    @ApiModelProperty(value = "宠物状态")
    Integer petState;

    public static QueryPetBusinessListParam toObject(String jsonStr) {
        if (StringUtils.isNotBlank(jsonStr)) {
            try {
                return JsonUtil.formObject(jsonStr, QueryPetBusinessListParam.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
