package com.yangwang.application.pet.market.model.params;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.yangwang.sysframework.utils.JsonUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author huji
 * @version 1.0
 * @className QueryUsableCouponListParam
 * @date 2020/3/27 15:31
 **/
@Data
@JsonIgnoreProperties
public class QueryUsableCouponListParam extends BaseQueryParam {

    @ApiModelProperty(value = "商家编号")
    String businessNo;

    @ApiModelProperty(value = "卖家编号")
    String shopNo;

    @ApiModelProperty(value = "本单金额")
    BigDecimal subtotalAmount;

    @ApiModelProperty(value = "优惠券主键(1.宠物;2.商品;3.服务)")
    int type;

    @ApiModelProperty(value = "关键字")
    String key;
}
