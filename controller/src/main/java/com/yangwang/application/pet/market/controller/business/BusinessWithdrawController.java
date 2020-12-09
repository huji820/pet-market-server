package com.yangwang.application.pet.market.controller.business;

import com.yangwang.application.pet.market.common.enums.RespondCodeEnum;
import com.yangwang.application.pet.market.model.business.BusinessWithdraw;
import com.yangwang.application.pet.market.service.facade.business.BusinessWithdrawService;
import com.yangwang.sysframework.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * <p>
 * 商家提现
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className BusinessWithdrawController
 * @date 2020/4/2 10:05
 **/
@RestController
@Api(description = "提现")
@RequestMapping("/api/withdraw")
public class BusinessWithdrawController {
    @Resource
    BusinessWithdrawService businessWithdrawService;

    @PostMapping
    @ApiOperation(value = "发起提现")
    public JsonResult save(@RequestBody BusinessWithdraw businessWithdraw) {
        if (!checkParam(businessWithdraw)) {
            return JsonResult.err(RespondCodeEnum.CHECK_ERROR.getCode(), "");
        }

        int result = businessWithdrawService.saveBusinessWithdraw(businessWithdraw.getBusiness().getBusinessNo(), businessWithdraw.getAmount());

        return result > 0 ? JsonResult.success() : JsonResult.err(RespondCodeEnum.INSERT_ERROR.getCode(), "发起失败！");
    }

    private boolean checkParam(BusinessWithdraw businessWithdraw) {
        return businessWithdraw != null
                && businessWithdraw.getAmount() != null
                && businessWithdraw.getAmount().compareTo(BigDecimal.ZERO) > 0
                && businessWithdraw.getBusiness() != null
                && businessWithdraw.getBusiness().getBusinessNo() != null;
    }
}
