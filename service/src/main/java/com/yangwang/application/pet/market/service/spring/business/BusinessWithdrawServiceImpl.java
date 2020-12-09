package com.yangwang.application.pet.market.service.spring.business;

import com.yangwang.application.pet.market.common.enums.BalanceFlowTypeEnum;
import com.yangwang.application.pet.market.common.enums.BusinessStateEnum;
import com.yangwang.application.pet.market.common.enums.SMSTemplateTypeEnum;
import com.yangwang.application.pet.market.common.enums.WithdrawEnum;
import com.yangwang.application.pet.market.common.utils.AliSmsUtils;
import com.yangwang.application.pet.market.common.utils.StringUtils;
import com.yangwang.application.pet.market.dao.business.BusinessWithdrawMapper;
import com.yangwang.application.pet.market.model.business.Business;
import com.yangwang.application.pet.market.model.business.BusinessBalance;
import com.yangwang.application.pet.market.model.business.BusinessWithdraw;
import com.yangwang.application.pet.market.service.facade.business.BusinessBalanceBufferService;
import com.yangwang.application.pet.market.service.facade.business.BusinessBalanceFlowService;
import com.yangwang.application.pet.market.service.facade.business.BusinessBalanceService;
import com.yangwang.application.pet.market.service.facade.business.BusinessWithdrawService;
import com.yangwang.application.pet.market.service.service.BusinessService;
import com.yangwang.sysframework.utils.DateUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 商家提现
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className BusinessWithdrawServiceImpl
 * @date 2019/12/5 14:57
 **/
@Service
public class BusinessWithdrawServiceImpl implements BusinessWithdrawService {
    @Resource
    BusinessWithdrawMapper businessWithdrawMapper;

    @Resource
    BusinessService businessService;

    @Resource
    BusinessBalanceService businessBalanceService;

    @Resource
    BusinessBalanceBufferService businessBalanceBufferService;

    @Resource
    BusinessBalanceFlowService businessBalanceFlowService;

    @Resource
    AliSmsUtils aliSmsUtils;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int saveBusinessWithdraw(String businessNo, BigDecimal amount) {
        // 商家身份校验
        Business business = businessService.getByBusinessNoWithOutState(businessNo);
        if (business == null) {
            return 0;
        }

        // 余额校验
        BusinessBalance businessBalance = businessBalanceService.getByBusinessNo(businessNo);
        if (businessBalance == null || businessBalance.getTotalAmount().compareTo(amount) < 0) {
            return 0;
        }

        // 提现
        BusinessWithdraw businessWithdraw = newBusinessWithdraw(amount, business);

        // 减扣金额
        businessBalanceService.subtract(businessNo, amount);

        // 插入临时减扣表
        businessBalanceBufferService.saveWithdraw(businessWithdraw);

        // 添加一条提现信息
        businessWithdrawMapper.save(businessWithdraw);

        // 余额流水
        businessBalanceFlowService.save(business, businessWithdraw.getAmount().negate(), businessWithdraw.getWithdrawNo(), null, BalanceFlowTypeEnum.WITHDRAW_CONFIRM);

        // 发送短信
        try {
            aliSmsUtils.sendSms(null, "18932913600", SMSTemplateTypeEnum.WITHDRAWAL_CODE.getTemplateId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1;
    }


    private int configWithdraw(String withdrawNo) {
        // 获取单据
        BusinessWithdraw businessWithdraw = businessWithdrawMapper.getByWithdrawNo(withdrawNo);
        if (businessWithdraw != null && WithdrawEnum.TO_BE_AUDITED.getState().equals(businessWithdraw.getState())) {
            // 修改状态
            businessWithdrawMapper.updateState(withdrawNo, WithdrawEnum.COMPLETED.getState());

            // 删除临时提现表
            return businessBalanceBufferService.deleteByWithdrawNo(withdrawNo);
        }
        return 0;
    }

    @Override
    public List<BusinessWithdraw> listByStationNo(String businessNo, int offset, int limit) {
        return businessWithdrawMapper.listByBusinessNo(businessNo, offset, limit);
    }

    private int rejectWithdraw(String withdrawNo) {
        // 获取提现对象
        BusinessWithdraw businessWithdraw = businessWithdrawMapper.getByWithdrawNo(withdrawNo);

        // 订单状态校验
        if (businessWithdraw == null || !WithdrawEnum.TO_BE_AUDITED.getState().equals(businessWithdraw.getState())) {
            return 0;
        }

        // 修改提现单状态
        businessWithdrawMapper.updateState(withdrawNo, WithdrawEnum.REJECT.getState());

        // 删除临时表
        businessBalanceBufferService.deleteByWithdrawNo(withdrawNo);

        // 修改商家余额
        businessBalanceService.subtract(businessWithdraw.getBusiness().getBusinessNo(), businessWithdraw.getAmount().negate());

        // 余额流水
        businessBalanceFlowService.save(businessWithdraw.getBusiness(), businessWithdraw.getAmount(), businessWithdraw.getWithdrawNo(), null, BalanceFlowTypeEnum.WITHDRAW_REJECT);

        return 1;
    }

    @Override
    public int configWithdraw(List<BusinessWithdraw> withdraws) {
        int result = 0;

        for (BusinessWithdraw businessWithdraw : withdraws) {
            result = configWithdraw(businessWithdraw.getWithdrawNo());
        }

        return result;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int rejectWithdraw(List<BusinessWithdraw> withdraws) {
        int result = 0;

        for (BusinessWithdraw businessWithdraw : withdraws) {
            result = rejectWithdraw(businessWithdraw.getWithdrawNo());
        }

        return result;
    }

    @Override
    public List<BusinessWithdraw> listBusinessWithdraw(String withdrawNo, String businessNo, String startDate, String endDate, boolean active, int start, int end) {
        return businessWithdrawMapper.listBusinessWithdraw(withdrawNo, businessNo, startDate, endDate, active, start, end);
    }

    @Override
    public int countBusinessWithdraw(String withdrawNo, String businessNo, String startDate, String endDate, boolean active) {
        return businessWithdrawMapper.countBusinessWithdraw(withdrawNo, businessNo, startDate, endDate, active);
    }


    /**
     * <p>
     * 创建一个新的提现对象
     * </p>
     *
     * @param amount   返利金额
     * @param business 商家
     * @return BusinessWithdraw 提现对象
     * @author LiuXiangLin
     * @date 16:39 2019/12/30
     **/
    private BusinessWithdraw newBusinessWithdraw(BigDecimal amount, Business business) {
        BusinessWithdraw businessWithdraw = new BusinessWithdraw();
        businessWithdraw.setAmount(amount);
        businessWithdraw.setBusiness(business);
        businessWithdraw.setState(WithdrawEnum.TO_BE_AUDITED.getState());
        businessWithdraw.setWithdrawTime(DateUtil.formatFull(new Date()));
        businessWithdraw.setWithdrawNo(StringUtils.getUuid());
        return businessWithdraw;
    }
}
