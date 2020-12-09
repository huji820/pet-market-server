package com.yangwang.application.pet.market.model.params;

import com.yangwang.sysframework.utils.JsonUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 * <p>
 * 粉丝查询对象
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className QueryFansListParam
 * @date 2020/3/25 9:16
 **/
@Data
@Api(description = "粉丝查询对象")
public class QueryFansListParam extends BaseQueryParam {
    @ApiModelProperty(value = "被关注商家编号")
    String followBusinessNo;

    @ApiModelProperty(value = "被关注宠物编号")
    String petNo;

    @ApiModelProperty(value = "被关注商品编号")
    String item;

    @ApiModelProperty(value = "关注类型")
    Integer followType;

    public static QueryFansListParam toObject(String jsonStr) {
        if (StringUtils.isNotBlank(jsonStr)) {
            try {
                return JsonUtil.formObject(jsonStr, QueryFansListParam.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
