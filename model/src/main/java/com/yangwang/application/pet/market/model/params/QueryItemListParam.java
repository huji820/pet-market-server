package com.yangwang.application.pet.market.model.params;

import com.yangwang.sysframework.utils.JsonUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 * <p>
 *
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className QueryItemListParam
 * @date 2020/3/22 9:01
 **/
@Data
@ApiModel(description = "商品查询参数")
public class QueryItemListParam extends BaseQueryParam {
    @ApiModelProperty(value = "商家编号")
    String businessNo;

    @ApiModelProperty(value = "商品编号")
    Integer itemNo;

    @ApiModelProperty(value = "宠物类型编号")
    String petSortNo;

    @ApiModelProperty(value = "商品类型编号")
    Integer itemTypeNo;

    @ApiModelProperty(value = "商品品牌编号")
    Integer itemBrandNo;

    @ApiModelProperty(value = "商品套餐编号")
    Integer itemPackNo;

    @ApiModelProperty(value = "商品状态")
    Integer itemState;

    /**
     * <p>
     * json转对象
     * </p>
     *
     * @param jsonStr json串
     * @return com.yangwang.application.pet.market.model.params.QueryItemListParam
     * @author LiuXiangLin
     * @date 9:14 2020/3/22
     **/
    public static QueryItemListParam toObject(String jsonStr) {
        if (StringUtils.isNotBlank(jsonStr)) {
            try {
                return JsonUtil.formObject(jsonStr, QueryItemListParam.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
