package com.yangwang.application.pet.market.controller.market.assess;

import com.yangwang.application.pet.market.common.enums.RespondCodeEnum;
import com.yangwang.application.pet.market.common.utils.CollectionUtils;
import com.yangwang.application.pet.market.model.vo.FeedbackVo;
import com.yangwang.application.pet.market.service.facade.assess.AssessFeedbackService;
import com.yangwang.sysframework.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * <p>
 * 评测回馈列表
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className AssessFeedbackApiController
 * @date 2020/5/18 15:03
 **/
@RestController
@Api(description = "评测回馈列表")
@RequestMapping("/api/assess/feedback")
public class AssessFeedbackApiController {
    @Resource
    AssessFeedbackService assessFeedbackService;

    @GetMapping("/list/{assessNo:\\w+}/offset/{offset:\\w+}/limit/{limit:\\w+}")
    public JsonResult list(@PathVariable long assessNo, @PathVariable int offset, @PathVariable int limit) {
        return JsonResult.success(assessFeedbackService.listByAssessNo(assessNo, offset, limit));
    }

    @ApiOperation("评测回复")
    @PostMapping("/replyAssess")
    public JsonResult replyAssess(@RequestBody FeedbackVo feedbackVo){
        if(feedbackVo==null||
                feedbackVo.getFeedback()==null||
                feedbackVo.getFeedback().getAssess()==null||
                feedbackVo.getFeedback().getBusiness()==null
        ){
            return JsonResult.err(RespondCodeEnum.CHECK_ERROR.getCode(), "参数缺失！");
        }
        int i = assessFeedbackService.replyAssess(feedbackVo);
        return JsonResult.success(i>0?true:false);
    }

    @ApiOperation("采纳评测回复")
    @PostMapping("/adoptAssessApply")
    public JsonResult adoptAssessApply(@RequestParam("feedbackNo") Long feedbackNo){
        int i = assessFeedbackService.adoptOrCancelAdoptApply(feedbackNo,true);
        return JsonResult.success(i);
    }

    @ApiOperation("取消采纳测评回复")
    @PostMapping("/cancelAdopt")
    public JsonResult cancelAdopt(@RequestParam("feedbackNo") Long feedbackNo){
        int i = assessFeedbackService.adoptOrCancelAdoptApply(feedbackNo,false);
        return JsonResult.success(i);
    }
}
