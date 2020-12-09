package com.yangwang.application.pet.market.controller.market.pet;

import com.yangwang.application.pet.market.model.common.Pet;
import com.yangwang.application.pet.market.model.params.QueryPetMarketListParam;
import com.yangwang.application.pet.market.service.facade.common.PetIssuedBehalfService;
import com.yangwang.application.pet.market.service.facade.common.PetListService;
import com.yangwang.sysframework.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 一键代发
 **/
@RestController()
@RequestMapping("/api/market/pet/petIssuedBehalf")
@Api(description = "代发宠物")
public class PetIssuedBehalfController {

    @Resource
    PetIssuedBehalfService petIssuedBehalfService;

    @ApiOperation("一键代发宠物")
    @PostMapping("/save")
    public JsonResult save(@RequestParam("petNo")String petNo,@RequestParam("businessNo")String businessNo){
        int save = petIssuedBehalfService.save(petNo, businessNo);
        return JsonResult.success(save);
    }

    @ApiOperation("获取商家所有一键代发的宠物")
    @GetMapping("/listByBusinessNo")
    public JsonResult listByBusinessNo(@RequestParam("businessNo")String businessNo){
        List<Pet> pets = petIssuedBehalfService.listByBusinessNo(businessNo);
        return JsonResult.success(pets);
    }

    @ApiOperation("通过宠物编号移除宠物")
    @PostMapping("/removePetByPetNo")
    public JsonResult removePetByPetNo(@RequestParam("petNo")String petNo){
        int i = petIssuedBehalfService.removePetByPetNo(petNo);
        return JsonResult.success(i);
    }
}
