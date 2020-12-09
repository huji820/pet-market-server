package com.yangwang.application.pet.market.model.params;

import com.yangwang.sysframework.utils.JsonUtil;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 * <p>
 * 宠物二级分类
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className QueryPetGenreListParam
 * @date 2020/3/22 14:11
 **/
@Data
public class QueryPetGenreListParam extends BaseQueryParam {
    @ApiModelProperty(value = "宠物一级分类编号")
    Integer petSortNo;

    @ApiModelProperty(value = "关键字")
    String keyWord;

    /**
     * <p>
     * 将json串转换为对象
     * </p>
     *
     * @param jsonStr json串
     * @return com.yangwang.application.pet.market.model.params.QueryPetGenreListParam
     * @author LiuXiangLin
     * @date 14:14 2020/3/22
     **/
    public static QueryPetGenreListParam toObject(String jsonStr) {
        if (StringUtils.isNotBlank(jsonStr)) {
            try {
                return JsonUtil.formObject(jsonStr, QueryPetGenreListParam.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
