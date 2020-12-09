package com.yangwang.application.pet.market.controller.business;

import com.yangwang.application.pet.market.common.enums.RespondCodeEnum;
import com.yangwang.application.pet.market.model.params.QueryCreditFlowParam;
import com.yangwang.application.pet.market.service.facade.market.CreditFlowService;
import com.yangwang.sysframework.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * <p>
 * 积分流水
 * </p>
 *
 * @author LiuXiangLin
 * @date 11:53 2020/3/19
 **/
@RestController
@RequestMapping("/api/business/credit/flow")
@Api(description = "积分流水")
public class CreditFlowController {
    @Resource
    CreditFlowService creditFlowService;

    @GetMapping()
    @ApiOperation("查询积分流水")
    public JsonResult getByCustomerNo(@RequestParam("queryParam") String queryParam) {
        QueryCreditFlowParam queryCreditFlowParam = QueryCreditFlowParam.jsonToObject(queryParam);
        if (queryCreditFlowParam == null) {
            return JsonResult.err(RespondCodeEnum.CHECK_ERROR.getCode(), "参数为空");
        }
        queryCreditFlowParam.dealWithParam();
        return JsonResult.success(creditFlowService.list(queryCreditFlowParam));
    }

}
