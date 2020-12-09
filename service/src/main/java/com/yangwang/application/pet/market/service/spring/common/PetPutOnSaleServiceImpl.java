package com.yangwang.application.pet.market.service.spring.common;

import com.yangwang.application.pet.market.common.enums.MessageTypeEnum;
import com.yangwang.application.pet.market.common.enums.OnSaleStateEnum;
import com.yangwang.application.pet.market.model.common.AbstractPetAdd;
import com.yangwang.application.pet.market.model.vo.PetVo;
import com.yangwang.application.pet.market.service.facade.common.*;
import com.yangwang.sysframework.utils.DateUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className PetPutOnSaleServiceImpl
 * @date 2020/3/13 9:37
 **/
@Service
public class PetPutOnSaleServiceImpl implements PetPutOnSaleService {
    @Resource
    PetService petService;

    @Resource
    PetCoverService petCoverService;

    @Resource
    PetVaccineService petVaccineService;

    @Resource
    PetWormKillService petWormKillService;

    @Resource
    PetPowerService petPowerService;

    @Resource
    PetGrouponService petGrouponService;

    @Resource(name = "MessagePetService")
    MessagePushService messagePushService;

    @Override
    public int putOnSale(String petNo) {
        return petService.updatePetState(petNo, OnSaleStateEnum.FOR_SALE.getType());
    }

    @Override
    public int pullOffShelves(String petNo) {
        return petService.updatePetState(petNo, OnSaleStateEnum.OFF_SALE.getType());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int newPutOnSale(PetVo petVo) {
        // 基本数据
        setDefaultPet(petVo);

        // 宠物疫苗
        AbstractPetAdd.addPetToList(petVo.getPetVaccineList(), petVo.getPet());
        petVaccineService.saveList(petVo.getPetVaccineList());

        // 宠物除虫
        AbstractPetAdd.addPetToList(petVo.getPetWormKillList(), petVo.getPet());
        petWormKillService.saveList(petVo.getPetWormKillList());

        // 宠物首页图片
        AbstractPetAdd.addPetToList(petVo.getPetCoverList(), petVo.getPet());
        petCoverService.saveList(petVo.getPetCoverList());

        // 宠物价格阶梯
        AbstractPetAdd.addPetToList(petVo.getPetGrouponList(), petVo.getPet());
        petGrouponService.saveList(petVo.getPetGrouponList());

        // 宠物信息
        petService.save(petVo.getPet());

        //给关注的用户发送站内信推送
        messagePushService.messagePush(petVo.getPet().getPetNo(), MessageTypeEnum.COMMODITY_NEW.getType());

        return 1;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int update(PetVo petVo) {
        petVo.defaultPriceAndImg();

        // 更新宠物信息
        petService.update(petVo.getPet());

        // 更新疫苗信息
        petVaccineService.updateList(petVo.getPetVaccineList(), petVo.getPet());

        // 更新杀虫记录
        petWormKillService.updateList(petVo.getPetWormKillList(), petVo.getPet());

        // 更新封面信息
        petCoverService.updateList(petVo.getPetCoverList(), petVo.getPet());

        // 更新宠物价格阶梯
        petGrouponService.updateList(petVo.getPetGrouponList(), petVo.getPet());

        return 1;
    }

    /**
     * <p>
     * 设置默认值
     * </p>
     *
     * @author LiuXiangLin
     * @date 15:08 2020/3/18
     **/
    private void setDefaultPet(PetVo petVo) {
        petVo.getPet().setPetNo(petService.newPetNo(petVo.getPet().getBusiness()));
        petVo.getPet().setPower(petPowerService.get(petVo.getPet(), petVo.getPet().getBusiness()));
        petVo.getPet().setCreateDate(DateUtil.format(new Date(), DateUtil.FORMAT_SIMPLE));
        petVo.getPet().setCreateTime(DateUtil.format(new Date(), DateUtil.FORMAT_TIME));
        petVo.getPet().setCollectionQty(0);
        petVo.getPet().setEvaluationQty(0);
        petVo.getPet().setSalesVolume(0);
        petVo.getPet().setFavorableRate(BigDecimal.ZERO);
        petVo.getPet().setPetState(OnSaleStateEnum.FOR_SALE.getType());
        petVo.defaultPriceAndImg();
    }
}
