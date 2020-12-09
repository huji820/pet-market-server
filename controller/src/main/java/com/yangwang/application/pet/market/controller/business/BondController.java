package com.yangwang.application.pet.market.controller.business;

import com.yangwang.application.pet.market.common.enums.RespondCodeEnum;
import com.yangwang.application.pet.market.model.business.Bond;
import com.yangwang.application.pet.market.service.facade.business.BondFacedService;
import com.yangwang.sysframework.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * <p>
 * 商家保证金
 * </p>
 *
 * @author LiuXiangLin
 * @date 16:56 2020/3/24
 **/
@Api(description = "商家保证金")
@RestController
@RequestMapping("/api/business/bond")
public class BondController {
    @Resource
    BondFacedService bondFacedService;

    @GetMapping("/{businessNo:\\w+}")
    @ApiOperation(value = "获取保证金")
    public JsonResult get(@PathVariable("businessNo") String businessNo) {
        return JsonResult.success(bondFacedService.getByBusinessNo(businessNo));
    }

    @PostMapping()
    @ApiOperation(value = "提交保证金申请")
    public JsonResult save(@RequestBody Bond bond) {
        if (!checkParam(bond)) {
            return JsonResult.err(RespondCodeEnum.CHECK_ERROR.getCode(), "参数错误！");
        }
        bondFacedService.save(bond);
        return JsonResult.success(bond.getBusiness().getBusinessNo());

    }

    @GetMapping("/amount")
    @ApiOperation(value = "获取支付金额")
    public JsonResult getPrice() {
        return JsonResult.success("0.01");
    }

    /**
     * <p>
     * 检查参数
     * </p>
     *
     * @param bond 商家保证金
     * @return boolean
     * @author LiuXiangLin
     * @date 17:04 2020/3/24
     **/
    private boolean checkParam(Bond bond) {
        return bond != null
                && bond.getBusiness() != null
                && bond.getBusiness().getBusinessNo() != null;
    }
}
