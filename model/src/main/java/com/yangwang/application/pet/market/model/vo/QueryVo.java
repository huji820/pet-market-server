package com.yangwang.application.pet.market.model.vo;

import com.yangwang.application.pet.market.model.business.Business;
import com.yangwang.application.pet.market.model.common.Item;
import com.yangwang.application.pet.market.model.common.ItemBrand;
import com.yangwang.application.pet.market.model.common.PetGenre;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * <p>
 * 搜索VO
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className QueryVo
 * @date 2020/3/25 9:54
 **/
@Data
@ApiModel(value = "搜索VO")
public class QueryVo {
    @ApiModelProperty(value = "商品列表")
    List<Item> itemList;

    @ApiModelProperty(value = "宠物类别列表")
    List<PetGenre> petGenreList;

    @ApiModelProperty(value = "商家列表")
    List<Business> businesses;
}
