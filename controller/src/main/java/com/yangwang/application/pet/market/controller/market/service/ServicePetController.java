package com.yangwang.application.pet.market.controller.market.service;

import com.yangwang.application.pet.market.common.enums.RespondCodeEnum;
import com.yangwang.application.pet.market.model.common.MyPet;
import com.yangwang.application.pet.market.service.facade.common.MyPetService;
import com.yangwang.sysframework.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 我的爱宠
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className MyPetController
 * @date 2020/3/24 17:50
 **/
@RestController
@RequestMapping("/api/business/my-pet")
@Api(description = "爱宠")
public class ServicePetController {
    @Resource
    MyPetService myPetService;

    @PostMapping()
    @ApiOperation(value = "新增宠物")
    public JsonResult save(@RequestBody MyPet myPet) {
        if (!checkParam(myPet)) {
            return JsonResult.err(RespondCodeEnum.CHECK_ERROR.getCode(), "参数错误！");
        }
        return myPetService.save(myPet) > 0
                ? JsonResult.success()
                : JsonResult.err(RespondCodeEnum.INSERT_ERROR.getCode(), "添加失败！");
    }

    @PutMapping()
    @ApiOperation(value = "编辑宠物")
    public JsonResult edit(@RequestBody MyPet myPet) {
        if (!checkParam(myPet)) {
            return JsonResult.err(RespondCodeEnum.CHECK_ERROR.getCode(), "参数错误！");
        }
        return myPetService.update(myPet) > 0
                ? JsonResult.success()
                : JsonResult.err(RespondCodeEnum.INSERT_ERROR.getCode(), "添加失败！");
    }

    @GetMapping("/{petNo:\\w+}")
    @ApiOperation(value = "获取宠物")
    public JsonResult get(@PathVariable("petNo") int petNo) {
        return JsonResult.success(myPetService.get(petNo));
    }

    @GetMapping("/list/{businessNo:\\w+}")
    @ApiOperation(value = "获取爱宠列表")
    public JsonResult list(@PathVariable("businessNo") String businessNo) {
        return JsonResult.success(myPetService.listByBusinessNo(businessNo));
    }

    @DeleteMapping("/{petNo:\\w+}")
    @ApiOperation(value = "删除宠物")
    public JsonResult delete(@PathVariable("petNo") int petNo) {
        return myPetService.delete(petNo) > 0
                ? JsonResult.success()
                : JsonResult.err(RespondCodeEnum.DELETE_ERROR.getCode(), "删除失败！");
    }

    @GetMapping("/count/{businessNo:\\w+}")
    @ApiOperation(value = "通过商家编号查询爱宠总数")
    public JsonResult count(@PathVariable("businessNo") String businessNo) {
        return JsonResult.success(myPetService.countByBusinessNo(businessNo));
    }

    private boolean checkParam(MyPet myPet) {
        return myPet != null
                && myPet.getBusiness() != null
                && myPet.getBusiness().getBusinessNo() != null;
    }
}
