package com.yangwang.application.pet.market.controller.market.pet;

import com.yangwang.application.pet.market.common.enums.BusinessStateEnum;
import com.yangwang.application.pet.market.common.enums.MessageTypeEnum;
import com.yangwang.application.pet.market.common.enums.RespondCodeEnum;
import com.yangwang.application.pet.market.common.utils.CollectionUtils;
import com.yangwang.application.pet.market.common.utils.WeChatCheckUtils;
import com.yangwang.application.pet.market.model.params.IssuingPetParam;
import com.yangwang.application.pet.market.model.vo.PetVo;
import com.yangwang.application.pet.market.service.facade.business.BusinessIssuingService;
import com.yangwang.application.pet.market.service.facade.common.MessagePushService;
import com.yangwang.application.pet.market.service.service.BusinessService;
import com.yangwang.application.pet.market.service.facade.common.PetPutOnSaleService;
import com.yangwang.sysframework.utils.DateUtil;
import com.yangwang.sysframework.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

/**
 * <p>
 * 宠物发布
 * </p>
 *
 * @author LiuXiangLin
 * @date 15:16 2020/3/21
 **/
@RestController
@RequestMapping("/api/pet/put-on-sale")
@Api(description = "宠物发布")
public class PetPutOnSaleController {
    @Resource
    BusinessService businessService;

    @Resource
    PetPutOnSaleService petPutOnSaleService;

    @Resource(name = "MessagePetService")
    MessagePushService messagePushService;

    @Resource
    BusinessIssuingService businessIssuingService;

    @Resource
    WeChatCheckUtils weChatCheckUtils;

    @PostMapping("/new-put-on-sale")
    @ApiOperation("发布宠物")
    public JsonResult save(@RequestBody PetVo petVo) {
        // 参数校验
        if (!checkParam(petVo)) {
            return JsonResult.err(RespondCodeEnum.CHECK_ERROR.getCode(), "参数错误！");
        }
        if((!weChatCheckUtils.checkMsg(petVo.getPet().getPetName())||
                (!weChatCheckUtils.checkMsg(petVo.getPet().getPetDescription())))){
            return JsonResult.err(RespondCodeEnum.CONTENT_VIOLATIONS.getCode(),"参数中包含违规字符");
        }
        // 商家身份身份校验
        if (businessService.getByBusinessNoAndState(petVo.getPet().getBusiness().getBusinessNo(), BusinessStateEnum.NORMAL.getType()) == null) {
            return JsonResult.err(RespondCodeEnum.CHECK_ERROR.getCode(), "商家不存在");
        }

        // 设置时间参数
        petVo.getPet().setCreateDate(DateUtil.format(new Date(), DateUtil.FORMAT_SIMPLE));
        petVo.getPet().setCreateTime(DateUtil.format(new Date(), DateUtil.FORMAT_TIME));

        // 团购商品
        petVo.getPet().setGroupon(petVo.getPet().getGroupon() == null ? 0 : petVo.getPet().getGroupon());

        // 插入数据
        return petPutOnSaleService.newPutOnSale(petVo) > 0 ? JsonResult.success() : JsonResult.err(RespondCodeEnum.INSERT_ERROR.getCode(), "新增数据失败！");
    }

    @PutMapping("/for-sale/{petNo:\\w+}")
    @ApiOperation("宠物上架")
    public JsonResult petForSale(@PathVariable("petNo") String petNo) {
        return petPutOnSaleService.putOnSale(petNo) > 0 ? JsonResult.success() : JsonResult.err(RespondCodeEnum.UPDATE_ERROR.getCode(), "上架失败！");
    }

    @PutMapping("/off-sale/{petNo:\\w+}")
    @ApiOperation("宠物下架")
    public JsonResult petOffSale(@PathVariable("petNo") String petNo) {
        if(petPutOnSaleService.pullOffShelves(petNo) > 0){
            //给关注该宠物的用户发送站内信消息
            messagePushService.messagePush(petNo, MessageTypeEnum.COMMODITY_REMOVE.getType());
            return JsonResult.success();
        }
        return JsonResult.err(RespondCodeEnum.UPDATE_ERROR.getCode(), "下架失败！");
    }

    @PostMapping("/update")
    @ApiOperation("编辑宠物")
    public JsonResult update(@RequestBody PetVo petVo) {
        // 参数校验
        if (!checkParam(petVo)) {
            return JsonResult.err(RespondCodeEnum.CHECK_ERROR.getCode(), "参数错误！");
        }
        if((!weChatCheckUtils.checkMsg(petVo.getPet().getPetName())||
                (!weChatCheckUtils.checkMsg(petVo.getPet().getPetDescription())))){
            return JsonResult.err(RespondCodeEnum.CONTENT_VIOLATIONS.getCode(),"参数中包含违规字符");
        }
        return JsonResult.success(petPutOnSaleService.update(petVo));
    }



    /**
     * <p>
     * 检查参数是否正确
     * </p>
     *
     * @param petVo 宠物VO
     * @return boolean
     * @author LiuXiangLin
     * @date 11:38 2020/3/26
     **/
    private boolean checkParam(PetVo petVo) {
        return petVo != null
                && petVo.getPet() != null
                && petVo.getPet().getPetSort() != null
                && petVo.getPet().getPetSort().getPetSortNo() != null
                && petVo.getPet().getPetGenre() != null
                && petVo.getPet().getPetGenre().getPetGenreNo() != null
                && petVo.getPet().getBusiness() != null
                && petVo.getPet().getBusiness().getBusinessNo() != null
                && (petVo.getPet().getGroupon() == null
                || petVo.getPet().getGroupon() == 0
                || (petVo.getPet().getGroupon() == 1
                && CollectionUtils.isNotEmpty(petVo.getPetGrouponList())));
    }

}

