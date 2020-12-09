package com.yangwang.application.pet.market.service.spring.coupon;

import com.yangwang.application.pet.market.common.utils.CollectionUtils;
import com.yangwang.application.pet.market.dao.market.coupon.CouponTypeMapper;
import com.yangwang.application.pet.market.model.common.coupon.CouponType;
import com.yangwang.application.pet.market.service.facade.coupon.CouponTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className CouponTypeServiceImpl
 * @date 2020/3/27 15:17
 **/
@Service
public class CouponTypeServiceImpl implements CouponTypeService {
    @Resource
    CouponTypeMapper couponTypeMapper;

    @Override
    public CouponType get(long couponTypeId) {
        return couponTypeMapper.get(couponTypeId);
    }

    @Override
    public List<CouponType> list(Integer preferentialType) {
        return couponTypeMapper.list(preferentialType);
    }

    @Override
    public int save(CouponType couponType) {
        return couponTypeMapper.save(couponType);
    }

    @Override
    public int addNewGuestGiftBag(List<CouponType> couponTypeList) {
        if(CollectionUtils.isNotEmpty(couponTypeList)){
            for (CouponType couponType :couponTypeList){
                couponType.setTitle("新客大礼包");
            }
        }
        return 0;
    }

    @Override
    public List<CouponType> listNewGuestGiftBag() {
        return couponTypeMapper.listByTitle("新客大礼包");
    }
}
