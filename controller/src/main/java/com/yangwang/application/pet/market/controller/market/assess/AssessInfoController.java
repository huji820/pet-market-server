package com.yangwang.application.pet.market.controller.market.assess;

import com.yangwang.application.pet.market.model.assess.Assess;
import com.yangwang.application.pet.market.service.facade.assess.AssessService;
import com.yangwang.sysframework.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 评测的controll
 * @Description
 * @Author huji
 * @Date 2020-05-15 2:49
 * @Version 1.0
 */
@RestController
@RequestMapping("/api/assess/info")
@Api(description = "评测")
public class AssessInfoController {

    @Autowired
    AssessService assessService;

    @ApiOperation("发布商品评测")
    @PostMapping("/addItemAssess")
    public JsonResult addItemAssess(@RequestBody Assess assess){
        int save = assessService.save(assess);
        return JsonResult.success(save>0?true:false);
    }

    @ApiOperation(value = "普通的评测列表")
    @GetMapping("list")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "offset" ,value = "从第X条数据开始", defaultValue = "0", required = true),
            @ApiImplicitParam(name = "limit", value = "分页数据", defaultValue = "0", required = true)
    })
    public JsonResult list(int offset, int limit) {
        return JsonResult.success(assessService.list(offset, limit));
    }

    @ApiOperation("查看所有的评测信息")
    @GetMapping("/listAllAssess")
    public JsonResult listAllAssess(String query, String releaseTime,
                                     Integer offset, Integer limit){
        List<Assess> assesses = assessService.listAllAssess(query, releaseTime, offset, limit);
        return JsonResult.success(assesses);
    }
}
