package com.yangwang.application.pet.market.service.spring.business;

import com.yangwang.application.pet.market.common.enums.AppTypeEnum;
import com.yangwang.application.pet.market.common.enums.AuthTypeEnum;
import com.yangwang.application.pet.market.common.enums.BusinessStateEnum;
import com.yangwang.application.pet.market.common.enums.BondStateEnum;
import com.yangwang.application.pet.market.common.utils.StringUtils;
import com.yangwang.application.pet.market.model.business.Business;
import com.yangwang.application.pet.market.model.common.Customer;
import com.yangwang.application.pet.market.model.common.CustomerOpenId;
import com.yangwang.application.pet.market.model.common.LoginInfo;
import com.yangwang.application.pet.market.service.facade.business.BusinessPowerService;
import com.yangwang.application.pet.market.service.facade.common.CustomerOpenIdService;
import com.yangwang.application.pet.market.service.service.BusinessService;
import com.yangwang.application.pet.market.service.facade.business.LoginService;
import com.yangwang.application.pet.market.service.facade.customer.CustomerService;
import com.yangwang.sysframework.utils.DateUtil;
import com.yangwang.sysframework.utils.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

/**
 * <p>
 * 登录
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className LoginServiceImpl
 * @date 2020/3/16 16:45
 **/
@Service
public class LoginServiceImpl implements LoginService {
    @Resource
    CustomerService customerService;

    @Resource
    BusinessService businessService;

    @Resource
    BusinessPowerService businessPowerService;

    @Resource
    CustomerOpenIdService customerOpenIdService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Customer weApp(LoginInfo loginInfo, String phone) {
        // 用户
        Customer result = customerService.getByPhone(phone);
        if (result == null) {
            result = customerService.insertCustomer(newCustomer(loginInfo, phone));
        }

        // 商家
        Business business = businessService.getByUnionId(loginInfo.getWxUserInfo().getUnionId());
        if (business == null) {
            business = new Business.Builder()
                    .businessName(result.getCustomerName())
                    .headImg(result.getHeaderImage())
                    .businessNo(StringUtils.getUuid())
                    .registerTime(DateUtil.formatFull(new Date()))
                    .contact(result.getCustomerName())
                    .contactPhone(result.getPhone())
                    .password(Business.PASSWORD)
                    .payBond(BondStateEnum.UNPAID.getState())
                    .state(BusinessStateEnum.UNAUDITED.getType())
                    .authType(AuthTypeEnum.UN_AUTH.getType())
                    .fans(0)
                    .followQty(0)
                    .unionId(result.getUnionId())
                    .complete(0)
                    .credit(0)
                    .level("一级铲屎官")
                    .customerNo(result.getCustomerNo())
                    .buildBusiness();
            business.setPower(businessPowerService.get(business));
            businessService.save(business);
        }

        // 更新用户openid
        customerOpenIdService.saveOrUpdate(new CustomerOpenId(result, AppTypeEnum.WE_APP_MARKET.getType(), loginInfo.getWxUserInfo().getOpenid()));

        result.setBusiness(business);

        return result;
    }

    /**
     * <p>
     * 新建一个用户对象
     * </p>
     *
     * @param loginInfo 登录信息
     * @param phone     电话号码
     * @return com.yangwang.application.pet.market.model.common.Customer
     * @author LiuXiangLin
     * @date 9:43 2020/3/16
     **/
    private Customer newCustomer(LoginInfo loginInfo, String phone) {
        Customer customer;
        customer = new Customer();
        customer.setCustomerNo(phone);
        customer.setUnionId(loginInfo.getWxUserInfo().getUnionId());
        customer.setOpenid(loginInfo.getWxUserInfo().getOpenid());
        customer.setCustomerName(loginInfo.getWxUserInfo().getNickname());
        customer.setHeaderImage(loginInfo.getWxUserInfo().getHeadImgUrl());
        customer.setSex(loginInfo.getWxUserInfo().getSex());
        customer.setPhone(phone);
        customer.setCustomerNo(phone);

        if (StringUtil.isNotNull(loginInfo.getShareOpenId())) {
            if (customer.getShareBusiness() == null) {
                customer.setShareBusiness(businessService.getByOpenId(loginInfo.getShareOpenId()));
            }
        }

        return customer;
    }
}
