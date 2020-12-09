package com.yangwang.application.pet.market.controller.market.assess;

import com.yangwang.application.pet.market.model.assess.AssessApply;
import com.yangwang.application.pet.market.service.facade.assess.AssessApplyService;
import com.yangwang.application.pet.market.service.facade.assess.AssessFeedbackService;
import com.yangwang.sysframework.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


/**
 * <p>
 * 申请评测
 * </p>
 **/
@RestController
@Api(description = "申请评测")
@RequestMapping("/api/assess/apply")
public class AssessApplyApiController {

    @Resource
    AssessApplyService assessApplyService;

    @ApiOperation("申请评测")
    @PostMapping("")
    public JsonResult applyAssess(@RequestParam("businessNo")String businessNo, @RequestParam("assessNo")Long assessNo){
        Integer save = assessApplyService.save(businessNo,assessNo);
        return JsonResult.success(save>0?true:false);
    }

    @ApiOperation("活动商家获取商品评测申请")
    @GetMapping("/listByItemBusinessNo")
    public JsonResult listByItemBusinessNo(@RequestParam("businessNo")String businessNo){
        List<AssessApply> assessApplies = assessApplyService.listByItemBusinessNo(businessNo);
        return JsonResult.success(assessApplies);
    }
}
