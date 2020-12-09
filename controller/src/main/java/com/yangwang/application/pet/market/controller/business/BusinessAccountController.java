package com.yangwang.application.pet.market.controller.business;

import com.yangwang.application.pet.market.common.enums.RespondCodeEnum;
import com.yangwang.application.pet.market.model.business.BusinessAccount;
import com.yangwang.application.pet.market.model.check.BusinessAccountBankGroup;
import com.yangwang.application.pet.market.service.facade.business.BusinessAccountService;
import com.yangwang.sysframework.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * <p>
 *
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className BusinessAccountApiController
 * @date 2020/5/20 14:05
 **/
@RestController
@Api(description = "商家收款账户")
@RequestMapping("/api/business/account")
public class BusinessAccountController {
    @Resource
    BusinessAccountService businessAccountService;

    @PostMapping
    @ApiOperation(value = "新增一个收款账户")
    public JsonResult save(@Validated() @RequestBody BusinessAccount businessAccount, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return JsonResult.err(RespondCodeEnum.INSERT_ERROR.getCode(), bindingResult.getAllErrors().get(0).getDefaultMessage());
        }
        int result = businessAccountService.save(businessAccount);
        return result > 0 ? JsonResult.success() : JsonResult.err(RespondCodeEnum.INSERT_ERROR.getCode(), RespondCodeEnum.INSERT_ERROR.getMessage());
    }

    @DeleteMapping("/{accountNo:\\w}")
    public JsonResult delete(@PathVariable(name = "accountNo") long accountNo) {
        int result = businessAccountService.delete(accountNo);
        return result > 0 ? JsonResult.success() : JsonResult.err(RespondCodeEnum.DELETE_ERROR.getCode(), RespondCodeEnum.DELETE_ERROR.getMessage());
    }

    @GetMapping("/{businessNo:\\w+}")
    @ApiOperation(value = "获取所有的收款账户")
    public JsonResult list(@PathVariable(name = "businessNo") String businessNo) {
        return JsonResult.success(businessAccountService.listByBusinessNo(businessNo));
    }

}
