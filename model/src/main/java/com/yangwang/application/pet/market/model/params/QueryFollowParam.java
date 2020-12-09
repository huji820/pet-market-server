package com.yangwang.application.pet.market.model.params;

import com.yangwang.application.pet.market.model.business.Follow;
import com.yangwang.sysframework.utils.JsonUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 * <p>
 * 关注列表查询参数
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className QueryFollowParam
 * @date 2020/3/20 16:22
 **/
@Data
@Api(description = "关注列表查询参数")
public class QueryFollowParam extends BaseQueryParam {
    @ApiModelProperty(value = "商家编号")
    String businessNo;

    @ApiModelProperty(value = "查询类型")
    Integer queryType;

    /**
     * <p>
     * 校验是否是可用的类型
     * </p>
     *
     * @return boolean
     * @author LiuXiangLin
     * @date 14:09 2020/3/21
     **/
    public boolean checkUsefulType() {
        if (queryType != null) {
            return queryType == Follow.TYPE_BUSINESS || queryType == Follow.TYPE_PET || queryType == Follow.TYPE_ITEM;
        }
        return false;
    }

    public static QueryFollowParam toObject(String jsonStr) {
        if (StringUtils.isNotBlank(jsonStr)) {
            try {
                return JsonUtil.formObject(jsonStr, QueryFollowParam.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
