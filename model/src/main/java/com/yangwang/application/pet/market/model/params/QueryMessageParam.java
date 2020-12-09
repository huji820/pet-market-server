package com.yangwang.application.pet.market.model.params;

import com.yangwang.sysframework.utils.JsonUtil;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 * @author yang hituzi
 * @description 站内信列表查询参数
 * @date 2020年4月13日 12:01:11
 */
@Data
public class QueryMessageParam extends BaseQueryParam{

    @ApiModelProperty("查询站内信用户编号")
    String businessNo;

    /**
     *
     * 将Json串转换为对象
     * @param jsonStr
     * @return com.yangwang.application.pet.market.model.params.QueryMessageParam
     * @author yang hituzi
     * @date 14:02 2020/4/13
     */
    public static QueryMessageParam toObject(String jsonStr){
        if(StringUtils.isNotBlank(jsonStr)){
            try{
               return JsonUtil.formObject(jsonStr,QueryMessageParam.class);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return null;
    }
}
