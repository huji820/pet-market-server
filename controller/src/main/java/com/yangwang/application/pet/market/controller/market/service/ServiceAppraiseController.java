package com.yangwang.application.pet.market.controller.market.service;

import com.yangwang.application.pet.market.common.enums.RespondCodeEnum;
import com.yangwang.application.pet.market.model.vo.ItemAppraiseVo;
import com.yangwang.application.pet.market.model.vo.ServiceAppraiseVo;
import com.yangwang.application.pet.market.service.facade.customer.ItemAppraiseFacedService;
import com.yangwang.application.pet.market.service.facade.service.ServiceAppraiseFacedService;
import com.yangwang.sysframework.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 服务评价
 * </p>
 *
 * @author LiuXiangLin
 * @date 10:41 2020/3/24
 **/
@Api(description = "服务评价")
@RestController
@RequestMapping("/api/service/appraise")
public class ServiceAppraiseController {
    @Resource
    ServiceAppraiseFacedService serviceAppraiseFacedService;

    @PostMapping
    @ApiOperation(value = "新增商品评价")
    public JsonResult save(@RequestBody ServiceAppraiseVo serviceAppraiseVo) {
        if (!checkParam(serviceAppraiseVo)) {
            return JsonResult.err(RespondCodeEnum.CHECK_ERROR.getCode(), "参数错误");
        }
        return serviceAppraiseFacedService.addAppraise(serviceAppraiseVo) > 0
                ? JsonResult.success()
                : JsonResult.err(RespondCodeEnum.INSERT_ERROR.getCode(), "添加商品评价失败！");
    }

    /**
     * <p>
     * 检查参数是否正确
     * </p>
     *
     * @param serviceAppraiseVo 商品评价VO
     * @return boolean
     * @author LiuXiangLin
     * @date 10:47 2020/3/24
     **/
    private boolean checkParam(ServiceAppraiseVo serviceAppraiseVo) {
        return serviceAppraiseVo != null
                && serviceAppraiseVo.getServiceAppraise() != null
                && serviceAppraiseVo.getServiceAppraise().getServiceOrder() != null
                && serviceAppraiseVo.getServiceAppraise().getServiceOrder().getOrderNo() != null
                && serviceAppraiseVo.getServiceAppraise().getBusiness().getBusinessNo() != null;
    }

    @DeleteMapping("/{appraiseNo:\\w+}")
    public JsonResult delete(@PathVariable("appraiseNo") int appraiseNo) {
        return serviceAppraiseFacedService.deleteAppraise(appraiseNo) > 0
                ? JsonResult.success()
                : JsonResult.err(RespondCodeEnum.DELETE_ERROR.getCode(), "删除失败！");
    }
}
