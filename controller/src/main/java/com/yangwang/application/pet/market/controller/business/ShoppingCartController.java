package com.yangwang.application.pet.market.controller.business;

import com.yangwang.application.pet.market.common.enums.RespondCodeEnum;
import com.yangwang.application.pet.market.model.vo.DelShoppingCartVO;
import com.yangwang.application.pet.market.service.spring.common.ShoppingCartServiceImpl;
import com.yangwang.sysframework.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController()
@RequestMapping("/shoppingCart")
@Api(description = "购物车")
public class ShoppingCartController {

    @Resource
    ShoppingCartServiceImpl shoppingCartService;

    @PostMapping("/addShopCart")
    @ApiOperation(value = "添加购物车")
    public JsonResult addShopCart(@RequestParam("qty") int qty,
                                  @RequestParam("goodsNo") String goodsNo,
                                  @RequestParam("businessNo") String businessNo,
                                  @RequestParam("goodsType") int goodsType){

        return JsonResult.success(shoppingCartService.addShopingCart(qty, goodsNo, businessNo, goodsType));

    }

    @GetMapping("/queryShopCart")
    @ApiOperation(value = "查询购物车")
    public JsonResult queryShoppingCart(@RequestParam("businessNo") String businessNo,
                                        @RequestParam("start") int start,
                                        @RequestParam("limit")int limit){

        return JsonResult.list(shoppingCartService.queryShoppingCart(businessNo, start, limit),
                shoppingCartService.queryShoppingCart(businessNo, start, limit).size());
    }

    @DeleteMapping("/delShopCart")
    @ApiOperation(value = "删除购物车")
    public JsonResult delShoppingCart(@RequestBody List<DelShoppingCartVO> delShoppingCartVO){

        int acount=shoppingCartService.delShoppingCart(delShoppingCartVO);
        if(acount<=0){
            JsonResult.fail(RespondCodeEnum.DELETE_ERROR.getCode(),RespondCodeEnum.DELETE_ERROR.getMessage());
        }
        return JsonResult.success(RespondCodeEnum.SUCCESS.getCode(),RespondCodeEnum.SUCCESS.getMessage());
    }

    @PutMapping("updateShopCart")
    @ApiOperation(value = "修改购物车")
    public JsonResult updateShoppingCart(@RequestParam("qty")int qty,
                                         @RequestParam("goodsType")int goodsType,
                                         @RequestParam("businessNo")String businessNo,
                                         @RequestParam("goodsNo")String goodsNo){

        return JsonResult.success(shoppingCartService.updateShoppingCartQty(qty, goodsType, businessNo, goodsNo));
    }

}
