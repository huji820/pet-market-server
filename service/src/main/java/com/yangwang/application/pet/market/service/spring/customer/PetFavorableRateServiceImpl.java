package com.yangwang.application.pet.market.service.spring.customer;

import com.yangwang.application.pet.market.service.facade.customer.PetAppraiseService;
import com.yangwang.application.pet.market.service.facade.customer.PetFavorableRateService;
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
 * @className PetFavorableRateServiceImpl
 * @date 2020/3/23 13:45
 **/
@Service
public class PetFavorableRateServiceImpl implements PetFavorableRateService {
    /**
     * 好评率的星级
     */
    private static final int FAVORABLE_APPRAISE = 4;

    @Resource
    PetAppraiseService petAppraiseService;

    @Override
    public BigDecimal calcFavorableRate(String petNo) {
        // 获取总的评价数量
        int totalAppraise = petAppraiseService.countByPetNo(petNo);
        // 获取好评的数量
        int favorableAppraise = petAppraiseService.countByUpPraiseDegree(petNo, FAVORABLE_APPRAISE);

        if (totalAppraise != 0) {
            return BigDecimal.valueOf(favorableAppraise / totalAppraise);
        }
        return BigDecimal.valueOf(1);
    }
}
