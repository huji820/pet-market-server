package com.yangwang.application.pet.market.controller.market.service;

import com.yangwang.application.pet.market.model.service.Beautician;
import com.yangwang.application.pet.market.model.service.Work;
import com.yangwang.application.pet.market.service.facade.service.BeauticianWorkService;
import com.yangwang.sysframework.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @TODO
 * @Description
 * @Author Administrator
 * @Date 2020-03-25 17:07
 * @Version 1.0
 */
@RestController
@Api(description = "美容师")
@RequestMapping("/api/service/work-like")
public class ServiceWorkLikedController {


    @Autowired
    BeauticianWorkService beauticianWorkService;

    @ApiOperation(value = "给作品点赞")
    @PostMapping("")
    public JsonResult addWorkLiked(@RequestBody WorkLikeBody work) {
        beauticianWorkService.insertWorkLiked(work.getWorkId(), work.getBusinessNo());
        return JsonResult.success("点赞成功");
    }

    @Data
    private static class WorkLikeBody {
        long workId;

        String businessNo;

        public WorkLikeBody() {
        }

        public WorkLikeBody(long workId, String businessNo) {
            this.workId = workId;
            this.businessNo = businessNo;
        }
    }
}
