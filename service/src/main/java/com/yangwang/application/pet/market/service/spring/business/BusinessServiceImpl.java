package com.yangwang.application.pet.market.service.spring.business;

import com.yangwang.application.pet.market.common.utils.StringUtils;
import com.yangwang.application.pet.market.dao.business.BusinessMapper;
import com.yangwang.application.pet.market.model.business.Business;
import com.yangwang.application.pet.market.model.params.LonAndLat;
import com.yangwang.application.pet.market.service.service.BusinessService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * <p>
 * 商家
 * </p>
 *
 * @author LiuXiangLin
 * @date 11:05 2020/3/16
 **/
@Service
public class BusinessServiceImpl implements BusinessService {

    @Resource
    BusinessMapper businessMapper;

    @Override
    public int save(Business business) {
        return businessMapper.save(business);
    }

    @Override
    public int delete(String businessNo) {
        return businessMapper.delete(businessNo);
    }

    @Override
    public int update(Business business) {
        return businessMapper.update(business);
    }

    @Override
    public Business getByBusinessNoWithOutState(String businessNo) {
        Business business =  businessMapper.getByBusinessNoAndNoState(businessNo);
        if (business == null) {
            return business;
        }

        String[] images;
        if (!StringUtils.isBlank(business.getShopImages())) {
            images = business.getShopImages().split(",");
            business.setShopImg(images);
        }
        return business;
    }

    @Override
    public Business getByBusinessNoAndState(String businessNo, int state) {
        return businessMapper.getByBusinessNoAndState(businessNo, state);
    }

    @Override
    public Business getByUnionId(String unionId) {
        return businessMapper.getByUnionId(unionId);
    }

    @Override
    public Business getByOpenId(String openId) {
        return businessMapper.getByOpenId(openId);
    }

    @Override
    public int updateAuthType(String businessNo, int authType) {
        return businessMapper.updateAuthType(businessNo, authType);
    }

    @Override
    public int updatePayBond(String businessNo, int payBond) {
        return businessMapper.updatePayBond(businessNo, payBond);
    }

    @Override
    public int updateLonAndLat(LonAndLat lonAndLat, String businessNo) {
        if (lonAndLat == null) {
            return 0;
        }
        return businessMapper.updateLonAndLat(lonAndLat, businessNo);
    }

    @Override
    public int updateFansAdd(String businessNo, Integer fans) {
        return businessMapper.updateFansAdd(businessNo, fans);
    }

    @Override
    public int updateFansSub(String businessNo, Integer fans) {
        return businessMapper.updateFansSub(businessNo, fans);
    }

    @Override
    public int updateFollowAdd(String businessNo, int follow) {
        return businessMapper.addFollowQty(businessNo, follow);
    }

    @Override
    public int updateFollowSub(String businessNo, int follow) {
        return businessMapper.addFollowQty(businessNo, -follow);
    }

    @Override
    public int updateCreditAdd(String businessNo, int credit) {
        return businessMapper.addCreditQty(businessNo, credit);
    }

    @Override
    public int updateCreditSub(String businessNo, int credit) {
        return businessMapper.addCreditQty(businessNo, -credit);
    }

    @Override
    public int updateHaveService(String businessNo, boolean haveService) {
        return businessMapper.updateHaveService(businessNo, haveService);
    }

    @Override
    public List<Business> getAllBusiness(int offset, int limit) {
        return businessMapper.getAllBusiness(offset, limit);
    }

    @Override
    public boolean getNewGiftBag(String businessNo) {
        Integer bag = businessMapper.getHaveNewGiftBagByBusinessNo(businessNo);
        if(bag.equals(Integer.valueOf(1))){
            return false;
        }
        return true;
    }

    @Override
    public Integer updateNewGiftBag(String businessNo) {
        return businessMapper.updateNewGiftBag(businessNo);
    }
}
