package com.yangwang.application.pet.market.controller.market.pet;

import com.yangwang.application.pet.market.common.enums.RespondCodeEnum;
import com.yangwang.application.pet.market.service.facade.common.PetDetailService;
import com.yangwang.sysframework.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * <p>
 * 宠物明细
 * </p>
 *
 * @author LiuXiangLin
 * @date 10:54 2020/3/24
 **/
@Api(description = "宠物明细")
@RestController
@RequestMapping("/api/market/pet/detail")
public class PetDetailController {
    @Resource
    PetDetailService petDetailService;

    @GetMapping("/{petNo:\\w+}")
    @ApiOperation("宠物明细")
    public JsonResult getPetBaseByPetNo(@PathVariable("petNo") String petNo) {
        if (petNo == null) {
            return JsonResult.err(RespondCodeEnum.CHECK_ERROR.getCode(), "参数为空");
        }
        return JsonResult.success(petDetailService.get(petNo));
    }

}
