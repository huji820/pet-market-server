package com.yangwang.application.pet.market.model.params;

import com.yangwang.sysframework.utils.JsonUtil;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 * <p>
 * 商家余额流水
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className QueryBusinessBalanceVoParam
 * @date 2020/4/2 10:39
 **/
@Data
public class QueryBusinessBalanceVoParam extends BaseQueryParam {
    @ApiModelProperty(value = "商家编号")
    String businessNo;

    public static QueryBusinessBalanceVoParam toObject(String jsonStr) {
        if (StringUtils.isNotBlank(jsonStr)) {
            try {
                return JsonUtil.formObject(jsonStr, QueryBusinessBalanceVoParam.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
