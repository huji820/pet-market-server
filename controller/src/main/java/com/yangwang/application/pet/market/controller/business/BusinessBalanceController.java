package com.yangwang.application.pet.market.controller.business;

import com.yangwang.application.pet.market.model.business.BusinessBalance;
import com.yangwang.application.pet.market.model.business.BusinessBalanceVo;
import com.yangwang.application.pet.market.service.facade.business.BusinessBalanceBufferService;
import com.yangwang.application.pet.market.service.facade.business.BusinessBalanceService;
import com.yangwang.sysframework.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * <p>
 * 余额
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className BusinessBalanceController
 * @date 2020/4/2 9:45
 **/
@RestController
@Api(description = "余额")
@RequestMapping("/api/balance")
public class BusinessBalanceController {
    @Resource
    BusinessBalanceService businessBalanceService;

    @Resource
    BusinessBalanceBufferService businessBalanceBufferService;

    @GetMapping("/{businessNo:\\w+}")
    @ApiOperation(value = "获取余额")
    public JsonResult get(@PathVariable String businessNo) {
        BusinessBalanceVo businessBalanceVo = new BusinessBalanceVo();

        // 获取余额总计
        BusinessBalance businessBalance = businessBalanceService.getByBusinessNo(businessNo);

        if (businessBalance == null) {
            businessBalanceVo.setBufferAmount(BigDecimal.ZERO);
            businessBalanceVo.setUseFulAmount(BigDecimal.ZERO);
            businessBalanceVo.setTotalAmount(BigDecimal.ZERO);

            return JsonResult.success(businessBalanceVo);
        }

        // 获取冻结余额
        BigDecimal totalBufferAmount = businessBalanceBufferService.getTotalAmount(businessNo);

        // 计算总余额
        BigDecimal totalAmount = businessBalance.getTotalAmount().add(totalBufferAmount == null ? BigDecimal.ZERO : totalBufferAmount);

        businessBalanceVo.setTotalAmount(totalAmount);
        businessBalanceVo.setUseFulAmount(businessBalance.getTotalAmount());
        businessBalanceVo.setBufferAmount(totalBufferAmount == null ? BigDecimal.ZERO : totalBufferAmount);

        return JsonResult.success(businessBalanceVo);
    }
}
