package com.yangwang.application.pet.market.controller.business;

import com.yangwang.application.pet.market.common.enums.RespondCodeEnum;
import com.yangwang.application.pet.market.model.common.ReceivingAddress;
import com.yangwang.application.pet.market.service.facade.common.ReceivingAddressService;
import com.yangwang.sysframework.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 收货地址
 * </p>
 *
 * @author LiuXiangLin
 * @date 14:59 2020/3/24
 **/
@Api(description = "收货地址")
@RestController
@RequestMapping("/api/business/receiving-address")
public class ReceivingAddressController {
    @Resource
    ReceivingAddressService receivingAddressService;

    @GetMapping("/list/{businessNo:\\w+}")
    @ApiOperation(value = "获取收货地址列表")
    public JsonResult listByCustomerNo(@PathVariable("businessNo") String businessNo) {
        return JsonResult.success(receivingAddressService.listByBusinessNo(businessNo));
    }

    @PostMapping("")
    @ApiOperation(value = "新增收货地址")
    public JsonResult insertByCustomerReceivingAddress(@RequestBody ReceivingAddress receivingAddress) {
        if (!checkParam(receivingAddress)) {
            return JsonResult.err(RespondCodeEnum.CHECK_ERROR.getCode(), "参数错误！");
        }
        return JsonResult.success(receivingAddressService.save(receivingAddress));
    }

    @PutMapping("")
    @ApiOperation(value = "修改收货地址")
    public JsonResult updateByCustomerReceivingAddress(@RequestBody ReceivingAddress receivingAddress) {
        if (!checkParam(receivingAddress)) {
            return JsonResult.err(RespondCodeEnum.CHECK_ERROR.getCode(), "参数错误！");
        }
        return JsonResult.success(receivingAddressService.update(receivingAddress));
    }

    @DeleteMapping("{receivingNo:[\\w]+}")
    @ApiOperation(value = "删除收货地址")
    public JsonResult deleteByAddressNo(@PathVariable("receivingNo") int receivingNo) {
        return JsonResult.success(receivingAddressService.delete(receivingNo));
    }

    @GetMapping("/default/{businessNo:[\\w+]}")
    @ApiOperation(value = "获取默认的收货地址")
    public JsonResult getDefault(@PathVariable("businessNo") String businessNo) {
        return JsonResult.success(receivingAddressService.getDefault(businessNo));
    }

    private boolean checkParam(ReceivingAddress receivingAddress) {
        return receivingAddress.getBusiness() != null
                && receivingAddress.getBusiness().getBusinessNo() != null
                && receivingAddress.getProvince() != null
                && receivingAddress.getCity() != null
                && receivingAddress.getCounty() != null
                && receivingAddress.getPhone() != null
                && receivingAddress.getContacts() != null;
    }


}
