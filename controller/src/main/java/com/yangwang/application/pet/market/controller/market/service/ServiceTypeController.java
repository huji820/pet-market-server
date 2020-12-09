package com.yangwang.application.pet.market.controller.market.service;

import com.yangwang.application.pet.market.common.enums.RespondCodeEnum;
import com.yangwang.application.pet.market.model.params.QueryPetGenreListParam;
import com.yangwang.application.pet.market.model.params.QueryServiceBusinessParam;
import com.yangwang.application.pet.market.model.service.ServiceType;
import com.yangwang.application.pet.market.model.vo.ServiceBusinessVO;
import com.yangwang.application.pet.market.service.facade.common.PetGenreService;
import com.yangwang.application.pet.market.service.facade.service.ServiceTypeService;
import com.yangwang.sysframework.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 宠物二级分类
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className PetGenreController
 * @date 2020/3/22 14:01
 **/
@RestController
@RequestMapping("/api/service/type")
@Api(description = "服务分类")
public class ServiceTypeController {

    //洗澡
    public final static int BATH = 1;

    //美容
    public final static int BEAUTY = 2;

    //寄养
    public final static int CARE = 4;

    //医疗
    public final static int MEDICAL = 5;

    @Resource
    ServiceTypeService serviceTypeService;

    @GetMapping("/list")
    @ApiOperation(value = "查询服务分类")
    public JsonResult list() {
        return JsonResult.success(serviceTypeService.listServiceType());
    }


    @GetMapping("/list/business/{businessNo:\\w+}")
    @ApiOperation(value = "获取商家所有的服务类型")
    public JsonResult listBusinessServiceType(@PathVariable String businessNo) {
        return JsonResult.success(serviceTypeService.listByBusinessNo(businessNo));
    }

    /**
     * 根据服务类型和用户经纬度,查询最近的6家门店
     *
     * @param queryServiceBusinessParam
     * @param bindingResult
     * @return com.yangwang.sysframework.utils.JsonResult
     * @author yang hituzi
     * @date 10:22 2020/4/10
     */
    @PutMapping("/listBusiness")
    @ApiOperation(value = "根据服务类型搜索最近的6家商家")
    public JsonResult listBusiness(@Validated @RequestBody QueryServiceBusinessParam queryServiceBusinessParam,
                                   BindingResult bindingResult) {

        //判断用户位置经纬度是否在一个合理的范围
        if (bindingResult.hasErrors()) {
            return JsonResult.fail(RespondCodeEnum.PARAM_ERROR.getCode(), "用户经纬度错误!");
        }

        //分页数据
        queryServiceBusinessParam.dealWithParam();

        switch (queryServiceBusinessParam.getServiceTypeName()) {
            case "洗澡":
                queryServiceBusinessParam.setServiceTypeNo(1);
                break;
            case "美容":
                queryServiceBusinessParam.setServiceTypeNo(2);
                break;
            case "寄养":
                queryServiceBusinessParam.setServiceTypeNo(4);
                break;
            case "医疗":
                queryServiceBusinessParam.setServiceTypeNo(5);
                break;
            default:
                return JsonResult.fail(RespondCodeEnum.PARAM_ERROR.getCode(), "服务类型错误!");
        }
        return JsonResult.success(serviceTypeService.listServiceBusiness(queryServiceBusinessParam));
    }
}
