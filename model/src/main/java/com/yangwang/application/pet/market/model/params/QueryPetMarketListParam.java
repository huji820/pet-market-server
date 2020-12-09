package com.yangwang.application.pet.market.model.params;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.yangwang.sysframework.utils.JsonUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;

/**
 * <p>
 * 跳蚤市场查询参数
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className QueryPetMarketListParam
 * @date 2020/3/14 14:43
 **/
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(description = "宠物市场查询参数")
public class QueryPetMarketListParam extends BaseQueryParam {
    @ApiModelProperty(value = "城市")
    String city;

    @ApiModelProperty(value = "起始金额")
    BigDecimal startMoney;

    @ApiModelProperty(value = "结束金额")
    BigDecimal endMoney;

    @ApiModelProperty(value = "性别")
    Short sex;

    @ApiModelProperty(value = "宠物一级分类")
    Integer petSortNo;

    @ApiModelProperty(value = "宠物二级分类")
    Integer petGenreNo;

    @ApiModelProperty(value = "搜索的关键词")
    String searchKey;

    /**
     * <p>
     * 将json串转为对象
     * </p>
     *
     * @param jsonStr json串
     * @return com.yangwang.application.pet.market.model.params.QueryPetMarketListParam
     * @author LiuXiangLin
     * @date 10:23 2020/3/17
     **/
    public static QueryPetMarketListParam toObject(String jsonStr) {
        QueryPetMarketListParam result = null;
        if (StringUtils.isNotBlank(jsonStr)) {
            try {
                result = JsonUtil.formObject(jsonStr, QueryPetMarketListParam.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
