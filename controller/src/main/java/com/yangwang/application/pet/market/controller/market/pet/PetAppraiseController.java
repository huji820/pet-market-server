package com.yangwang.application.pet.market.controller.market.pet;

import com.yangwang.application.pet.market.common.enums.RespondCodeEnum;
import com.yangwang.application.pet.market.model.vo.PetAppraiseVo;
import com.yangwang.application.pet.market.service.facade.customer.PetAppraiseFacedService;
import com.yangwang.sysframework.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 宠物评价
 * </p>
 *
 * @author LiuXiangLin
 * @date 10:49 2020/3/23
 **/
@Api(description = "宠物评价")
@RestController
@RequestMapping("/api/pet/appraise")
public class PetAppraiseController {
    @Resource
    PetAppraiseFacedService petAppraiseFacedService;

    @PostMapping
    @ApiOperation(value = "新增评价")
    public JsonResult saveAppraise(@RequestBody PetAppraiseVo petAppraiseVo) {
        if (!checkParam(petAppraiseVo)) {
            return JsonResult.err(RespondCodeEnum.CHECK_ERROR.getCode(), "参数错误");
        }
        return petAppraiseFacedService.addAppraise(petAppraiseVo) > 0
                ? JsonResult.success()
                : JsonResult.err(RespondCodeEnum.INSERT_ERROR.getCode(), "添加评论失败！");
    }

    @DeleteMapping("/{appraiseNo:\\w+}")
    @ApiOperation(value = "删除评价")
    public JsonResult deleteAppraise(@PathVariable("appraiseNo") int appraiseNo) {
        return petAppraiseFacedService.deleteAppraise(appraiseNo) > 0
                ? JsonResult.success()
                : JsonResult.err(RespondCodeEnum.DELETE_ERROR.getCode(), "删除评论失败！");
    }

    /**
     * <p>
     * 检查参数是否完整
     * </p>
     *
     * @param petAppraiseVo 宠物评价对象
     * @return boolean
     * @author LiuXiangLin
     * @date 14:45 2020/3/23
     **/
    private boolean checkParam(PetAppraiseVo petAppraiseVo) {
        return petAppraiseVo.getPetAppraise() != null
                && petAppraiseVo.getPetAppraise().getPet() != null
                && petAppraiseVo.getPetAppraise().getPet().getPetNo() != null
                && petAppraiseVo.getPetAppraise().getBusiness() != null
                && petAppraiseVo.getPetAppraise().getBusiness().getBusinessNo() != null
                && petAppraiseVo.getPetAppraise().getPetOrder().getOrderNo() != null
                && petAppraiseVo.getPetAppraise().getEvaluatedBusiness() != null
                && petAppraiseVo.getPetAppraise().getEvaluatedBusiness().getBusinessNo() != null;
    }
}
