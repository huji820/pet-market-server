package com.yangwang.application.pet.market.service.spring.customer;

import com.yangwang.application.pet.market.service.facade.customer.ItemAppraiseService;
import com.yangwang.application.pet.market.service.facade.customer.ItemFavorableRateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * <p>
 *
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className ItemFavorableRateServiceImpl
 * @date 2020/3/24 10:23
 **/
@Service
public class ItemFavorableRateServiceImpl implements ItemFavorableRateService {
    @Resource
    ItemAppraiseService itemAppraiseService;

    @Override
    public BigDecimal calcFavorableRate(int itemNo) {
        // 获取总的数量
        int totalAppraise = itemAppraiseService.countByItemNo(itemNo);

        // 获取四星以上的评价数量
        int favorableAppraise = itemAppraiseService.countByItemNoAndUpPraiseDegree(itemNo, 4);

        return favorableAppraise != 0 ? BigDecimal.valueOf(favorableAppraise / totalAppraise) : BigDecimal.ONE;
    }
}
