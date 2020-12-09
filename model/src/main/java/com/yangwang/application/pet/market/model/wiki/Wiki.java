package com.yangwang.application.pet.market.model.wiki;

import com.yangwang.application.pet.market.model.common.PetGenre;
import com.yangwang.application.pet.market.model.common.PetSort;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @TODO
 * @Description
 * @Author Administrator
 * @Date 2020-05-17 16:41
 * @Version 1.0
 */
@Data
@ApiModel(value = "百科文章")
public class Wiki {

    @ApiModelProperty(value = "文章标题")
    long wikiId;

    @ApiModelProperty(value = "宠物类型")
    PetGenre petGenre;

    @ApiModelProperty(value = "1:养宠技巧,2:宠物知识,3:宠物疾病")
    int wikiType;

    @ApiModelProperty(value = "创建时间")
    String createAt;

    @ApiModelProperty(value = "文章标题")
    String wikiTitle;

    @ApiModelProperty(value = "文章内容")
    String wikiContent;
}
