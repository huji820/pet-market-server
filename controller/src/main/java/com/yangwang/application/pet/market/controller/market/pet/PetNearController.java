package com.yangwang.application.pet.market.controller.market.pet;

import com.yangwang.application.pet.market.common.enums.RespondCodeEnum;
import com.yangwang.application.pet.market.model.params.QueryPetMarketListParam;
import com.yangwang.application.pet.market.service.facade.common.PetNearService;
import com.yangwang.sysframework.utils.JsonResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author yang hituzi
 * @description 二级页面 附近 搜索
 * @date 2020年4月10日 14:46:20
 */
@RestController
@RequestMapping("/api/market/near")
public class PetNearController {

    @Resource
    PetNearService petNearService;

    /**
     *
     * 通过参数查询 附近宠物列表
     * @param queryParam
     * @return com.yangwang.sysframework.utils.JsonResult
     * @author yang hituzi
     * @date 16:13 2020/4/10
     */
    @GetMapping()
    @ApiOperation(value = "列表查询")
    public JsonResult list(@RequestParam("queryParam") String queryParam){
        //参数校验
        QueryPetMarketListParam queryPetMarketListParam = QueryPetMarketListParam.toObject(queryParam);
        if (queryPetMarketListParam == null) {
            return JsonResult.err(RespondCodeEnum.CHECK_ERROR.getCode(), "参数缺失！");
        }
        return JsonResult.success(petNearService.list(queryPetMarketListParam));
    }
}
