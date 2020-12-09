package com.yangwang.application.pet.market.controller.business;

import com.yangwang.application.pet.market.common.enums.RespondCodeEnum;
import com.yangwang.application.pet.market.model.params.QueryBusinessBalanceVoParam;
import com.yangwang.application.pet.market.service.facade.business.BusinessBalanceVoService;
import com.yangwang.sysframework.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 商家流水
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className BusinessBalanceFlowController
 * @date 2020/4/2 12:01
 **/
@RestController
@Api(description = "商家流水")
@RequestMapping("/api/business/flow")
public class BusinessBalanceFlowController {
    @Resource
    BusinessBalanceVoService businessBalanceVoService;

    @GetMapping()
    @ApiOperation(value = "获取流水")
    public JsonResult list(@RequestParam("queryParam") String queryParam) {
        QueryBusinessBalanceVoParam queryBusinessBalanceVoParam = QueryBusinessBalanceVoParam.toObject(queryParam);
        if (queryBusinessBalanceVoParam == null) {
            return JsonResult.err(RespondCodeEnum.CHECK_ERROR.getCode(), "参数错误！");
        }
        queryBusinessBalanceVoParam.dealWithParam();
        return JsonResult.success(businessBalanceVoService.listByParam(queryBusinessBalanceVoParam));
    }
}
