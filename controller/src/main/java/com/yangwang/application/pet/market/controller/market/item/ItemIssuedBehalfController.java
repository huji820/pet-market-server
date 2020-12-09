package com.yangwang.application.pet.market.controller.market.item;

import com.yangwang.application.pet.market.model.common.Item;
import com.yangwang.application.pet.market.model.common.Pet;
import com.yangwang.application.pet.market.service.facade.common.ItemIssuedBehalfService;
import com.yangwang.application.pet.market.service.facade.common.PetIssuedBehalfService;
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
@RequestMapping("/api/market/item/itemIssuedBehalf")
@Api(description = "代发商品")
public class ItemIssuedBehalfController {

    @Resource
    ItemIssuedBehalfService itemIssuedBehalfService;

    @ApiOperation("一键代发商品")
    @PostMapping("/save")
    public JsonResult save(@RequestParam("itemNo")String itemNo,@RequestParam("businessNo")String businessNo){
        int save = itemIssuedBehalfService.save(itemNo, businessNo);
        return JsonResult.success(save);
    }

    @ApiOperation("获取商家所有一键代发的商品")
    @GetMapping("/listByBusinessNo")
    public JsonResult listByBusinessNo(@RequestParam("businessNo")String businessNo){
        List<Item> itemList = itemIssuedBehalfService.listByBusinessNo(businessNo);
        return JsonResult.success(itemList);
    }

    @ApiOperation("通过商品编号移除商品")
    @PostMapping("/removePetByPetNo")
    public JsonResult removePetByPetNo(@RequestParam("itemNo")String itemNo){
        int i = itemIssuedBehalfService.removeItemByItemNo(itemNo);
        return JsonResult.success(i);
    }
}
