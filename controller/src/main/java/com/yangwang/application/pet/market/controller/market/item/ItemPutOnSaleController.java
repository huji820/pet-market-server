package com.yangwang.application.pet.market.controller.market.item;

import com.yangwang.application.pet.market.common.enums.MessageTypeEnum;
import com.yangwang.application.pet.market.common.enums.RespondCodeEnum;
import com.yangwang.application.pet.market.common.utils.WeChatCheckUtils;
import com.yangwang.application.pet.market.model.common.Item;
import com.yangwang.application.pet.market.model.params.IssuingItemParam;
import com.yangwang.application.pet.market.model.vo.ItemVo;
import com.yangwang.application.pet.market.service.facade.business.BusinessIssuingService;
import com.yangwang.application.pet.market.service.facade.common.ItemPutOnSaleService;
import com.yangwang.application.pet.market.service.facade.common.MessagePushService;
import com.yangwang.sysframework.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 商品发布
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className ItemPutOnSaleController
 * @date 2020/3/22 16:59
 **/
@RestController
@RequestMapping("/api/item/pu-on-sale")
@Api(description = "商品发布")
public class ItemPutOnSaleController {

    @Resource
    ItemPutOnSaleService itemPutOnSaleService;

    @Resource(name = "PushItemService")
    MessagePushService messagePushService;

    @Resource
    BusinessIssuingService businessIssuingService;

    @Resource
    WeChatCheckUtils weChatCheckUtils;

    @ApiOperation(value = "发布商品")
    @PostMapping("/new-put-on-sale")
    public JsonResult newOnSale(@RequestBody ItemVo itemVo) {
        if (!checkParam(itemVo)) {
            return JsonResult.err(RespondCodeEnum.CHECK_ERROR.getCode(), "参数不完整");
        }
        if((!weChatCheckUtils.checkMsg(itemVo.getItem().getItemName())||
                (!weChatCheckUtils.checkMsg(itemVo.getItem().getItemDescription())))){
            return JsonResult.err(RespondCodeEnum.CONTENT_VIOLATIONS.getCode(),"参数中包含违规字符");
        }
        return itemPutOnSaleService.newPutOnSale(itemVo) > 0
                ? JsonResult.success()
                : JsonResult.err(RespondCodeEnum.INSERT_ERROR.getCode(), "发布失败！");
    }

    @PutMapping("/put-on-sale/{itemNo:\\w+}")
    @ApiOperation(value = "商品上架")
    public JsonResult putOnSale(@PathVariable("itemNo") int itemNo) {
        return itemPutOnSaleService.putOnSale(itemNo) > 0
                ? JsonResult.success()
                : JsonResult.err(RespondCodeEnum.UPDATE_ERROR.getCode(), "上架失败！");
    }

    @PutMapping("/pull-off-sale/{itemNo:\\w+}")
    @ApiOperation("商品下架")
    public JsonResult offSale(@PathVariable() int itemNo) {
        if(itemPutOnSaleService.pullOffShelves(itemNo) > 0){
            //给关注该商品的用户发送站内信推送
            messagePushService.messagePush(Integer.toString(itemNo), MessageTypeEnum.COMMODITY_REMOVE.getType());
            return JsonResult.success();
        }
        return JsonResult.err(RespondCodeEnum.UPDATE_ERROR.getCode(), "上架失败！");
    }

    @PostMapping
    @ApiOperation(value = "更新发布的商品")
    public JsonResult update(@RequestBody ItemVo itemVo) {
        if (!checkParam(itemVo)) {
            return JsonResult.err(RespondCodeEnum.CHECK_ERROR.getCode(), "参数不完整");
        }
        if((!weChatCheckUtils.checkMsg(itemVo.getItem().getItemName())||
                (!weChatCheckUtils.checkMsg(itemVo.getItem().getItemDescription())))){
            return JsonResult.err(RespondCodeEnum.CONTENT_VIOLATIONS.getCode(),"参数中包含违规字符");
        }
        return itemPutOnSaleService.update(itemVo) > 0 ? JsonResult.success() : JsonResult.err(RespondCodeEnum.UPDATE_ERROR.getCode(), "更新失败！");
    }

    @PostMapping("/purchase")
    @ApiOperation(value = "从厂家进货")
    public JsonResult purchase(@RequestParam("businessNo")String businessNo,@RequestBody ItemVo itemVo){
        if(itemVo.getItem().getRetailPrice() == null || itemVo.getItem().getCommissionAmount() == null){
            return JsonResult.err(RespondCodeEnum.CHECK_ERROR.getCode(), "参数不完整");
        }
        return businessIssuingService.purchase(businessNo, itemVo) > 0
                ? JsonResult.success("进货成功")
                : JsonResult.err(RespondCodeEnum.INSERT_ERROR.getCode(), "进货失败！");
    }

    /**
     * <p>
     * 校验参数
     * </p>
     *
     * @param itemVo 商品对象
     * @return boolean
     * @author LiuXiangLin
     * @date 17:12 2020/3/22
     **/
    private boolean checkParam(ItemVo itemVo) {
        return itemVo != null
                && itemVo.getItem() != null
                && itemVo.getItem().getBusiness() != null
                && itemVo.getItem().getBusiness().getBusinessNo() != null
                && itemVo.getItem().getPetSort() != null
                && itemVo.getItem().getPetSort().getPetSortNo() != null
                && itemVo.getItem().getItemTypes() != null
                && itemVo.getItem().getItemTypes().size() > 0;
    }
}
