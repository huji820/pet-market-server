package com.yangwang.application.pet.market.controller.market.wiki;

import com.yangwang.application.pet.market.service.facade.wiki.WikiService;
import com.yangwang.sysframework.utils.JsonResult;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @TODO
 * @Description
 * @Author Administrator
 * @Date 2020-05-17 16:58
 * @Version 1.0
 */
@RestController
@RequestMapping("/api/wiki/info")
@Api(description = "百科")
public class WikiController {

    @Autowired
    WikiService wikiService;

    @GetMapping("list")
    @ApiOperation(value = "百科列表")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "宠物类型编号", name = "petGenreNo", defaultValue = "0", required = false),
            @ApiImplicitParam(value = "百科分类(1:养宠技巧,2:宠物知识,3:宠物疾病)", name = "wikiType", defaultValue = "0", required = false),
            @ApiImplicitParam(value = "从第X数据", name = "offset", defaultValue = "0", required = false),
            @ApiImplicitParam(value = "分页数量", name = "limit", defaultValue = "0", required = false),
    })
    public JsonResult list(int petGenreNo, int wikiType,int offset, int limit) {
        return JsonResult.success(wikiService.list(petGenreNo, wikiType, offset, limit));
    }

    @GetMapping("get")
    @ApiOperation(value = "百科详情")
    @ApiImplicitParams({
        @ApiImplicitParam(value = "百科主键", name = "wikiId", defaultValue = "0", required = false)
    })
    public JsonResult get(long wikiId) {
        return JsonResult.success(wikiService.get(wikiId));
    }
}
