package com.yangwang.application.pet.market.model.assess;

import com.yangwang.application.pet.market.model.common.Item;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 评测
 *
 * @Description
 * @Author Administrator
 * @Date 2020-05-15 2:53
 * @Version 1.0
 */
@ApiModel(value = "商品评测")
@Data
public class Assess {
    @ApiModelProperty("评测主键")
    Long assessNo;

    @ApiModelProperty("标题")
    String title;

    @ApiModelProperty("封面图片")
    String coverImg;

    @ApiModelProperty("商品")
    Item item;

    @ApiModelProperty("评测数量")
    Integer num;

    @ApiModelProperty(value = "申请数量")
    Integer applyNum;

    @ApiModelProperty(value = "市场价格")
    BigDecimal price;

    @ApiModelProperty("推荐状态")
    Integer recommendState;

    @ApiModelProperty("1:正常;2:结束")
    Integer state;

    @ApiModelProperty("回复奖励积分")
    Integer credit;

    @ApiModelProperty("采纳奖品说明")
    String acceptPrizeExplain;

    @ApiModelProperty("发布时间")
    String releaseTime;
}
