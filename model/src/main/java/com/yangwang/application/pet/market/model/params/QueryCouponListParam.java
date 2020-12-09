package com.yangwang.application.pet.market.model.params;

import com.yangwang.sysframework.utils.JsonUtil;
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
 * @className QueryCouponListParam
 * @date 2020/3/27 15:31
 **/
@Data
public class QueryCouponListParam extends BaseQueryParam {
    @ApiModelProperty(value = "商家编号")
    String businessNo;

    @ApiModelProperty(value = "优惠券主键")
    Long couponId;

    @ApiModelProperty(value = "优惠券类别")
    Long couponTypeId;

    @ApiModelProperty(value = "是否已经使用过")
    Integer used;

    @ApiModelProperty(value = "是否已经失效")
    Integer invalid;

    public QueryCouponListParam(String businessNo, Long couponId, Long couponTypeId, Integer used, Integer invalid) {
        this.businessNo = businessNo;
        this.couponId = couponId;
        this.couponTypeId = couponTypeId;
        this.used = used;
        this.invalid = invalid;
    }

    public QueryCouponListParam() {
    }

    public static QueryCouponListParam toObject(String jsonStr) {
        if (StringUtils.isNotBlank(jsonStr)) {
            try {
                return JsonUtil.formObject(jsonStr, QueryCouponListParam.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
