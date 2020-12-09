package com.yangwang.application.pet.market.service.spring.customer;

import com.yangwang.application.pet.market.common.utils.CollectionUtils;
import com.yangwang.application.pet.market.common.utils.StringUtils;
import com.yangwang.application.pet.market.dao.customer.CustomerMapper;
import com.yangwang.application.pet.market.model.common.Customer;
import com.yangwang.application.pet.market.service.facade.customer.CustomerService;
import com.yangwang.sysframework.utils.DateUtil;
import com.yangwang.sysframework.utils.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author LiuXiangLin
 * @version 1.0
 * @className CustomerServiceImpl
 * @date 2019/10/26 10:27
 **/
@Service
public class CustomerServiceImpl implements CustomerService {
    @Resource
    CustomerMapper customerMapper;

    @Override
    public Customer getByUnionId(String unionId) {
        return customerMapper.getByUnionId(unionId);
    }


    @Override
    public Customer insertCustomer(Customer customer) {
        //获取注册日期,时间,最后登入时间
        String registerDate = DateUtil.format(new Date(), DateUtil.FORMAT_SIMPLE);
        String registerTime = DateUtil.format(new Date(), DateUtil.FORMAT_TIME);
        String lastLoginTime = DateUtil.format(new Date(), DateUtil.FORMAT_FULL);

        //将用户积分和余额定义为0
        BigDecimal points = BigDecimal.valueOf(0);
        BigDecimal balance = BigDecimal.valueOf(0);

        Customer newCustomer = new Customer(customer.getPhone(),
                customer.getCustomerName(),
                customer.getPhone(),
                customer.getHeaderImage(),
                customer.getSex(),
                customer.getOpenid(),
                customer.getUnionId(),
                lastLoginTime,
                registerDate,
                registerTime,
                points,
                balance, customer.getShareBusiness());

        int result = customerMapper.insertCustomer(newCustomer);
        if (result > 0) {
            return newCustomer;
        }

        return null;
    }

    @Override
    public Customer getByPhone(String phone) {
        return customerMapper.getByPhone(phone);
    }

    @Override
    public String getBusinessReferee(String customerNo) {
        //获取用户的推荐商家编号
        String shareBusinessNo = customerMapper.getCustomerRecommendBusinessNo(customerNo);
        if(!StringUtil.isNotNull(shareBusinessNo)){  //如果没有推荐商家
            //获取用户的推荐站点的主号商家编号
            String shareStationNo = customerMapper.getCustomerRecommendStationNo(customerNo);
            if(!StringUtil.isNotNull(shareStationNo)){
                return null;
            }
            return shareStationNo;
        }
        return shareBusinessNo;
    }
}
