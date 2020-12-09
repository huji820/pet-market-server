package com.yangwang.application.pet.market.controller.market.common;

import com.yangwang.application.pet.market.common.enums.RespondCodeEnum;
import com.yangwang.application.pet.market.model.business.Follow;
import com.yangwang.application.pet.market.model.params.QueryFollowParam;
import com.yangwang.application.pet.market.service.facade.business.FollowFacadeService;
import com.yangwang.sysframework.utils.DateUtil;
import com.yangwang.sysframework.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

/**
 * <p>
 * 商家关注
 * </p>
 *
 * @author YuZhengZhi
 * @date 15:39 2020/3/20
 **/
@Api(description = "关注")
@RestController
@RequestMapping("/api/business/follow")
public class FollowController {
    @Resource
    FollowFacadeService followFacadeService;

    @GetMapping("/list")
    @ApiOperation(value = "获取列表")
    public JsonResult list(@RequestParam("queryParam") String queryParam) {
        QueryFollowParam queryFollowParam = QueryFollowParam.toObject(queryParam);
        if (queryFollowParam == null || !queryFollowParam.checkUsefulType()) {
            return JsonResult.err(RespondCodeEnum.CHECK_ERROR.getCode(), "参数错误");
        }
        queryFollowParam.dealWithParam();
        return JsonResult.success(followFacadeService.list(queryFollowParam));
    }

    @PutMapping("/follow")
    @ApiOperation(value = "添加关注")
    public JsonResult follow(@RequestParam("paramStr") String paramStr) {
        Follow follow = Follow.toObject(paramStr);
        if (follow == null || !follow.checkUsefulType()) {
            return JsonResult.err(RespondCodeEnum.CHECK_ERROR.getCode(), "参数错误");
        }
        follow.setFollowDate(DateUtil.formatFull(new Date()));
        return followFacadeService.follow(follow) > 0 ? JsonResult.success() : JsonResult.err(RespondCodeEnum.INSERT_ERROR.getCode(), "添加关注失败！");
    }

    @PutMapping("/unfollow")
    @ApiOperation(value = "取消关注")
    public JsonResult unFollow(@RequestParam("paramStr") String paramStr) {
        Follow follow = Follow.toObject(paramStr);
        if (follow == null || !follow.checkUsefulType()) {
            return JsonResult.err(RespondCodeEnum.CHECK_ERROR.getCode(), "参数错误");
        }
        follow.setFollowDate(DateUtil.formatFull(new Date()));
        return followFacadeService.unFollow(follow) > 0 ? JsonResult.success() : JsonResult.err(RespondCodeEnum.INSERT_ERROR.getCode(), "取消关注失败！");
    }

    @GetMapping()
    @ApiOperation(value = "获取关注对象")
    public JsonResult get(@RequestParam("paramStr") String paramStr) {
        Follow follow = Follow.toObject(paramStr);
        if (follow == null || !follow.checkUsefulType()) {
            return JsonResult.err(RespondCodeEnum.CHECK_ERROR.getCode(), "参数错误");
        }
        follow.setFollowDate(DateUtil.formatFull(new Date()));
        return JsonResult.success(followFacadeService.getByFollow(follow));
    }
}
