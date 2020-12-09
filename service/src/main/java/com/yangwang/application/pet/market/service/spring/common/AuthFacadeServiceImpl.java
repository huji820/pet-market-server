package com.yangwang.application.pet.market.service.spring.common;

import com.yangwang.application.pet.market.common.enums.BusinessStateEnum;
import com.yangwang.application.pet.market.model.business.Auth;
import com.yangwang.application.pet.market.model.business.Business;
import com.yangwang.application.pet.market.model.params.LonAndLat;
import com.yangwang.application.pet.market.model.vo.AuthVo;
import com.yangwang.application.pet.market.service.service.AuthService;
import com.yangwang.application.pet.market.service.service.BusinessService;
import com.yangwang.application.pet.market.service.facade.common.AuthFacadeService;
import com.yangwang.application.pet.market.service.spring.consign.GaoDeMapUtils;
import com.yangwang.application.pet.market.service.spring.factory.AuthTypeFilterFactory;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * <p>
 *
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className AuthFacadeServiceImpl
 * @date 2020/3/19 14:45
 **/
@Service
public class AuthFacadeServiceImpl implements AuthFacadeService {
    @Resource
    AuthTypeFilterFactory authTypeFilterFactory;

    @Resource
    BusinessService businessService;

    @Resource
    AuthService authService;

    @Resource
    GaoDeMapUtils gaoDeMapUtils;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int save(AuthVo authVo) {
        if(authVo == null){
            return 0;
        }
        //根据参数获取认证类型
        Integer authType = authTypeFilterFactory.getAuthType(authVo);
        if(authType.equals(0)){
            return 0;
        }else{
            authVo.setBusinessAuthType(authType);
        }
        /*
         * 认证类型之间的区别
         * 1、平台认证数据最多，需要营业执照
         * 2、商家认证其次，需要添加门头照片
         * 3、个人认证数据最少，需要填写身份证号即可
         * */
        if (authTypeFilterFactory.check(authVo.setDefaultDateTime())) {

            // 修改商家认证类型
            businessService.updateAuthType(authVo.getBusiness().getBusinessNo(), authVo.getBusinessAuthType());
            // 保存认证数据
            authService.saveOrUpdate(authVo);

            LonAndLat lonAndLat = null;
            try {
                lonAndLat = gaoDeMapUtils.getLonAndLat(authVo.getProvince() + authVo.getCity() + authVo.getArea() + authVo.getDetailAddress());
            } catch (Exception e) {
                e.printStackTrace();
            }

            // 修改商家数据
            businessService.update(new Business.Builder()
                    .businessNo(authVo.getBusiness().getBusinessNo())
                    .startHours(authVo.getStartHours())
                    .endHours(authVo.getEndHours())
                    .contact(authVo.getContact())
                    .describe(authVo.getDescribe())
                    .province(authVo.getProvince())
                    .city(authVo.getCity())
                    .area(authVo.getArea())
                    .shopImg(authVo.getShopImages())
                    .detailAddress(authVo.getDetailAddress())
                    .latitude(lonAndLat == null ? 0.0 : Double.valueOf(lonAndLat.getLatitude()))
                    .longitude(lonAndLat == null ? 0.0 : Double.valueOf(lonAndLat.getLongitude()))
                    .state(BusinessStateEnum.NORMAL.getType())
                    .weChatImg(authVo.getWeChatImg())
                    .complete(1)
                    .buildBusiness()
            );

            return 1;
        }
        return 0;
    }

    /**
     * <p>
     * 获取经纬度
     * </p>
     *
     * @param auth 认证对象
     * @return void
     * @author LiuXiangLin
     * @date 17:49 2020/3/19
     **/
    private LonAndLat getAuthLonAndLat(Auth auth) {
        if (StringUtils.isNotBlank(auth.getProvince()) && StringUtils.isNotBlank(auth.getCity()) && StringUtils.isNotBlank(auth.getArea())) {
            try {
                return gaoDeMapUtils.getLonAndLat(auth.getProvince() + auth.getCity() + auth.getArea());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}
