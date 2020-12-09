package com.yangwang.application.pet.market.service.spring.customer;

import com.yangwang.application.pet.market.common.enums.OrderStateEnum;
import com.yangwang.application.pet.market.model.market.PetAppraise;
import com.yangwang.application.pet.market.model.vo.PetAppraiseVo;
import com.yangwang.application.pet.market.service.facade.common.PetService;
import com.yangwang.application.pet.market.service.facade.customer.*;
import com.yangwang.sysframework.utils.DateUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 宠物评价
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className PetAppraiseFacedServiceImpl
 * @date 2020/3/23 10:55
 **/
@Service
public class PetAppraiseFacedServiceImpl implements PetAppraiseFacedService {
    @Resource
    PetAppraiseService petAppraiseService;

    @Resource
    PetService petService;

    @Resource
    PetFavorableRateService petFavorableRateService;

    @Resource
    PetAppraiseImgService petAppraiseImgService;

    @Resource
    PetOrderService petOrderService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int addAppraise(PetAppraiseVo petAppraiseVo) {
        // 查询评价是否已经存在
        if (petAppraiseService.getByPetAppraise(petAppraiseVo.getPetAppraise()) == null) {
            petAppraiseVo.getPetAppraise().setAppraiseDate(DateUtil.formatFull(new Date()));

            // 修改宠物的评价数量
            petService.updateEvaluationQtyAdd(petAppraiseVo.getPetAppraise().getPet().getPetNo(), 1);

            // 计算好评率并修改
            BigDecimal favorableRate = petFavorableRateService.calcFavorableRate(petAppraiseVo.getPetAppraise().getPet().getPetNo());
            petService.updateFavorableRate(petAppraiseVo.getPetAppraise().getPet().getPetNo(), favorableRate);

            // 保存一条评价
            petAppraiseService.save(petAppraiseVo.getPetAppraise());

            // 保存评图片列表
            petAppraiseImgService.saveList(petAppraiseVo.addAppraiseToList().getPetAppraiseImgList());

            // 回写订单状态
            petOrderService.updateEvaluateState(petAppraiseVo.getPetAppraise().getPetOrder().getOrderNo(), OrderStateEnum.EVALUATE_EVALUATED.getState());

            return 1;
        }
        return 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteAppraise(int petAppraiseNo) {
        // 获取评价
        PetAppraise petAppraise = petAppraiseService.get(petAppraiseNo);
        if (petAppraise != null) {
            // 删减一个评价
            petService.updateEvaluationQtySub(petAppraise.getPet().getPetNo(), 1);

            // 计算好评率并修改
            BigDecimal favorableRate = petFavorableRateService.calcFavorableRate(petAppraise.getPet().getPetNo());
            petService.updateFavorableRate(petAppraise.getPet().getPetNo(), favorableRate);

            // 删除评论图片列表
            petAppraiseImgService.delete(petAppraiseNo);

            // 删除评价
            petAppraiseService.delete(petAppraiseNo);

            return 1;
        }

        return 0;
    }
}
