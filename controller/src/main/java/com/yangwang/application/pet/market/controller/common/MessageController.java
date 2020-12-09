package com.yangwang.application.pet.market.controller.common;

import com.yangwang.application.pet.market.common.enums.RespondCodeEnum;
import com.yangwang.application.pet.market.common.utils.WeChatCheckUtils;
import com.yangwang.application.pet.market.service.facade.common.MessageService;
import com.yangwang.sysframework.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @author yang hituzi
 * @description 站内信消息
 * @date 2020年4月13日 14:20:27
 */
@RestController
@RequestMapping("/api/customer/message")
@Api(description = "站内信")
public class MessageController {

    @Resource
    MessageService messageService;

    @Resource
    WeChatCheckUtils weChatCheckUtils;

    /**
     * 用户阅读站内信,更新站内信状态
     *
     * @param messageNo
     * @return com.yangwang.sysframework.utils.JsonResult
     * @author yang hituzi
     * @date 14:26 2020/4/13
     */
    @PutMapping()
    @ApiOperation(value = "更新站内信状态")
    public JsonResult updateMessageByNo(@RequestParam("messageNo") Integer messageNo) {
        if (messageNo == null) {
            return JsonResult.fail(RespondCodeEnum.PARAM_ERROR.getCode(), RespondCodeEnum.PARAM_ERROR.getMessage());
        }
        messageService.updateMessage(messageNo);
        return JsonResult.success(RespondCodeEnum.SUCCESS.getMessage());
    }

    @GetMapping()
    @ApiOperation(value = "查询站内信列表")
    public JsonResult listMessageByBusinessNo(@RequestParam("businessNo")String businessNo, @RequestParam("offset")int offset, @RequestParam("limit")int limit) {
        return JsonResult.success(messageService.listMessageByBusinessNo(businessNo,offset,limit));
    }

    @GetMapping("/listMessageByUpdateTimeAndBusinessNo")
    @ApiOperation(value = "获取指定时间之后的站内信")
    public JsonResult listMessageByUpdateTimeAndBusinessNo(@RequestParam("businessNo")String businessNo,@RequestParam("lastGetTime")String lastGetTime){
        return JsonResult.success(messageService.listMessageByUpdateTimeAndBusinessNo(businessNo, lastGetTime));
    }
    @GetMapping("/countMsgByUpdateTimeAndBusinessNo")
    @ApiOperation(value = "获取指定时间之后的站内信数量")
    public JsonResult countMsgByUpdateTimeAndBusinessNo(@RequestParam("businessNo")String businessNo,@RequestParam("lastGetTime")String lastGetTime){
        return JsonResult.success(messageService.countMsgByUpdateTimeAndBusinessNo(businessNo, lastGetTime));
    }

}
