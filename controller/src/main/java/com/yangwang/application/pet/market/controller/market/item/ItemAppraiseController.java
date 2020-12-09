package com.yangwang.application.pet.market.controller.market.item;

import com.yangwang.application.pet.market.common.enums.RespondCodeEnum;
import com.yangwang.application.pet.market.model.vo.ItemAppraiseVo;
import com.yangwang.application.pet.market.service.facade.customer.ItemAppraiseFacedService;
import com.yangwang.sysframework.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 商品评价
 * </p>
 *
 * @author LiuXiangLin
 * @date 10:41 2020/3/24
 **/
@Api(description = "商品评价")
@RestController
@RequestMapping("/api/item/appraise")
public class ItemAppraiseController {
    @Resource
    ItemAppraiseFacedService itemAppraiseFacedService;

    @PostMapping
    @ApiOperation(value = "新增商品评价")
    public JsonResult save(@RequestBody ItemAppraiseVo itemAppraiseVo) {
        if (!checkParam(itemAppraiseVo)) {
            return JsonResult.err(RespondCodeEnum.CHECK_ERROR.getCode(), "参数错误");
        }
        return itemAppraiseFacedService.addAppraise(itemAppraiseVo) > 0
                ? JsonResult.success()
                : JsonResult.err(RespondCodeEnum.INSERT_ERROR.getCode(), "添加商品评价失败！");
    }

    /**
     * <p>
     * 检查参数是否正确
     * </p>
     *
     * @param itemAppraiseVo 商品评价VO
     * @return boolean
     * @author LiuXiangLin
     * @date 10:47 2020/3/24
     **/
    private boolean checkParam(ItemAppraiseVo itemAppraiseVo) {
        return itemAppraiseVo != null
                && itemAppraiseVo.getItemAppraise() != null
                && itemAppraiseVo.getItemAppraise().getItemOrder() != null
                && itemAppraiseVo.getItemAppraise().getItemOrder().getOrderNo() != null
                && itemAppraiseVo.getItemAppraise().getBusiness().getBusinessNo() != null;
    }

    @DeleteMapping("/{appraiseNo:\\w+}")
    public JsonResult delete(@PathVariable("appraiseNo") int appraiseNo) {
        return itemAppraiseFacedService.deleteAppraise(appraiseNo) > 0
                ? JsonResult.success()
                : JsonResult.err(RespondCodeEnum.DELETE_ERROR.getCode(), "删除失败！");
    }
}
