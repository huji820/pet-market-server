package com.yangwang.application.pet.market.model.params;

import com.yangwang.sysframework.utils.JsonUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 * <p>
 * 积分流水查询类
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className QueryCreditFlowParam
 * @date 2020/3/19 10:37
 **/
@Data
@ApiModel(description = "积分流水查询类")
public class QueryCreditFlowParam extends BaseQueryParam {
    @ApiModelProperty(value = "商家编号")
    String businessNo;

    @ApiModelProperty(value = "流水单号")
    String flowNo;

    @ApiModelProperty(value = "开始时间")
    String startDateTime;

    @ApiModelProperty(value = "结束时间")
    String endDateTime;

    /***
     * <p>
     * json串转对象
     * </p>
     *
     * @param jsonStr json串
     * @return com.yangwang.application.pet.market.model.params.QueryCreditFlowParam
     * @author LiuXiangLin
     * @date 11:55 2020/3/19
     **/
    public static QueryCreditFlowParam jsonToObject(String jsonStr) {
        if (StringUtils.isNotBlank(jsonStr)) {
            try {
                return JsonUtil.formObject(jsonStr, QueryCreditFlowParam.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
