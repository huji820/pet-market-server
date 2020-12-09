package com.yangwang.application.pet.market.controller.common;

import com.yangwang.application.pet.market.common.enums.RespondCodeEnum;
import com.yangwang.application.pet.market.common.utils.RequestUtils;
import com.yangwang.application.pet.market.service.facade.business.BondFacedService;
import com.yangwang.application.pet.market.service.facade.common.ItemOrderFacedService;
import com.yangwang.application.pet.market.service.facade.common.PetOrderFacedService;
import com.yangwang.application.pet.market.service.facade.service.ServiceOrderService;
import com.yangwang.sysframework.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author LiuXiangLin
 * @version 1.0
 * @className WeChatPayController
 * @date 2019/10/29 14:59
 **/
@RestController
@Api(description = "微信安全检测接口")
@RequestMapping("/check/weChat")
public class WeChatCheckController {
    @Resource
    PetOrderFacedService petOrderFacedService;

    @Resource
    ItemOrderFacedService itemOrderFacedService;

    @Resource
    BondFacedService bondFacedService;

    @Resource
    ServiceOrderService serviceOrderService;


}
