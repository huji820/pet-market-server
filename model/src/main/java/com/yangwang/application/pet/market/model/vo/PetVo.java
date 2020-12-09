package com.yangwang.application.pet.market.model.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.yangwang.application.pet.market.common.utils.CollectionUtils;
import com.yangwang.application.pet.market.model.common.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Collections;
import java.util.List;

/**
 * <p>
 * 宠物vo对象
 * </p>
 *
 * @author LiuXiangLin
 * @date 14:09 2020/3/12
 **/
@Data
@ApiModel(description = "宠物")
@JsonIgnoreProperties(ignoreUnknown = true)
public class PetVo {
    @ApiModelProperty(value = "宠物")
    Pet pet;

    @ApiModelProperty(value = "宠物疫苗")
    List<PetVaccine> petVaccineList;

    @ApiModelProperty(value = "宠物除虫")
    List<PetWormKill> petWormKillList;

    @ApiModelProperty(value = "宠物图片")
    List<PetCover> petCoverList;

    @ApiModelProperty(value = "宠物价格阶梯")
    List<PetGroupon> petGrouponList;

    public void defaultPriceAndImg() {
        getPet().setBasePrice(getPet().getRetailPrice().subtract(getPet().getCommissionAmount()));
        getPet().setPetImg((getPetCoverList() != null && !getPetCoverList().isEmpty()) ? getPetCoverList().get(0).getCoverAddress() : null);
    }
}
