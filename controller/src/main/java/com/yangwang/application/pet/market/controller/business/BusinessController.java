package com.yangwang.application.pet.market.controller.business;


import com.yangwang.application.pet.market.model.business.Business;
import com.yangwang.application.pet.market.service.facade.business.NearBusinessService;
import com.yangwang.application.pet.market.service.facade.customer.CustomerService;
import com.yangwang.application.pet.market.service.service.BusinessService;
import com.yangwang.sysframework.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;
import java.util.List;

/**
 * @Author LSY
 * @Description 商家
 */
@Api(description = "商家")
@RestController
@RequestMapping("/api/business")
public class BusinessController {
    @Resource
    NearBusinessService nearBusinessService;

    @Resource
    BusinessService businessService;

    @Resource
    CustomerService customerService;

    @ApiOperation(value = "根据条件筛选查询商家")
    @GetMapping("/list")
    public JsonResult listBusiness(String city, String area, double lng, double lat, int offset, Integer limit) {
        return JsonResult.success(nearBusinessService.getBusinessNearResultVo(city, area, lng, lat, offset, limit));
    }

    @GetMapping("/city")
    public JsonResult listAllCity() {
        return JsonResult.success(nearBusinessService.listAllCity());
    }

    @ApiOperation("分页获取所有商家")
    @GetMapping("/getAllBusiness")
    public JsonResult getAllBusiness(@RequestParam("offset")int offset, @RequestParam("limit") int limit){
        List<Business> allBusiness = businessService.getAllBusiness(offset, limit);
        return JsonResult.success(allBusiness);
    }

    @ApiOperation("通过商家编号添加商家积分")
    @PostMapping("/updateCreditAdd")
    public JsonResult updateCreditAdd(@RequestParam("businessNo")String businessNo,@RequestParam("credit")Integer credit){
        int i = businessService.updateCreditAdd(businessNo, credit);
        return JsonResult.success(i);
    }

    @ApiOperation("通过商家编号查看商家是否领取新客礼包 true未领取  false已领取")
    @GetMapping("/getNewGiftBag")
    public JsonResult getNewGiftBag(@RequestParam("businessNo")String businessNo){
        boolean newGiftBag = businessService.getNewGiftBag(businessNo);
        return JsonResult.success(newGiftBag);
    }

    @ApiOperation("获取商家的推荐人")
    @GetMapping("/getBusinessReferee")
    public JsonResult getBusinessReferee(@RequestParam("customerNo")String customerNo){
        String businessReferee = customerService.getBusinessReferee(customerNo);
        return JsonResult.success(businessReferee);
    }
}
