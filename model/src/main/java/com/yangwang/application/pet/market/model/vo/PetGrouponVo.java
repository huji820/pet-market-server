package com.yangwang.application.pet.market.model.vo;

import com.yangwang.application.pet.market.model.common.PetGroupon;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * <p>
 * 宠物团购Vo
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className PetGrouponVo
 * @date 2020/3/25 14:45
 **/
@Data
@ApiModel(description = "宠物团购VO")
public class PetGrouponVo {
    @ApiModelProperty(value = "宠物对象")
    PetVo petVo;

    @ApiModelProperty(value = "价格阶梯")
    List<PetGroupon> petGrouponList;
}
