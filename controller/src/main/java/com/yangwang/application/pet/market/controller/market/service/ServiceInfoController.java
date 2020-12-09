package com.yangwang.application.pet.market.controller.market.service;

import com.yangwang.application.pet.market.common.enums.RespondCodeEnum;
import com.yangwang.application.pet.market.common.utils.WeChatCheckUtils;
import com.yangwang.application.pet.market.model.service.Service;
import com.yangwang.application.pet.market.service.facade.service.ServiceInfoService;
import com.yangwang.sysframework.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @TODO
 * @Description
 * @Author Administrator
 * @Date 2020-03-30 15:19
 * @Version 1.0
 */
@RestController
@RequestMapping("/api/service/info")
@Api(description = "服务")
public class ServiceInfoController {

    @Autowired
    ServiceInfoService serviceInfoService;

    @Resource
    WeChatCheckUtils weChatCheckUtils;

    @ApiOperation("新增服务")
    @PostMapping("insert")
    public JsonResult insertServiceInfo(@RequestBody Service service) {
        if(service == null){
            return JsonResult.err(RespondCodeEnum.CHECK_ERROR.getCode(), "参数错误！");
        }
        if(!weChatCheckUtils.checkMsg(service.getServiceName())){
            return JsonResult.err(RespondCodeEnum.CONTENT_VIOLATIONS.getCode(),"参数中包含违规字符");
        }
        serviceInfoService.insertServiceInfo(service);
        return JsonResult.success("新增服务成功");
    }

    @ApiOperation("修改服务")
    @PostMapping("update")
    public JsonResult updateServiceInfo(@RequestBody Service service) {
        if(!weChatCheckUtils.checkMsg(service.toString())){
            return JsonResult.err(RespondCodeEnum.CONTENT_VIOLATIONS.getCode(),"参数中包含违规字符");
        }
        serviceInfoService.updateServiceInfo(service);
        return JsonResult.success("修改服务成功");
    }

    @ApiOperation(value = "已发布的服务列表")
    @GetMapping("list")
    public JsonResult list(String businessNo, int offset, int limit, int state) {
        return JsonResult.success(serviceInfoService.listServiceByBusinessNo(businessNo, offset, limit, state));
    }

    @ApiOperation(value = "服务下架")
    @PutMapping("/out/{serviceId :\\w+}")
    public JsonResult outSale(@PathVariable(name = "serviceId ") long serviceId) {
        serviceInfoService.updateServiceState(serviceId, Boolean.FALSE);
        return JsonResult.success();
    }

    @ApiOperation(value = "服务上架")
    @PutMapping("/on/{serviceId:\\w+}")
    public JsonResult onSale(@PathVariable(name = "serviceId") long serviceId) {
        serviceInfoService.updateServiceState(serviceId, Boolean.TRUE);
        return JsonResult.success();
    }

    @GetMapping("/business/{businessNo:\\w+}/type/{typeNo:\\w+}")
    public JsonResult listServiceByTypeAndBusinessNo(@PathVariable String businessNo, @PathVariable long typeNo) {
        return JsonResult.success(serviceInfoService.listByBusinessNoAndType(businessNo, typeNo));
    }
}
