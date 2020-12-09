package com.yangwang.application.pet.market.service.spring.business;

import com.yangwang.application.pet.market.common.utils.StringUtils;
import com.yangwang.application.pet.market.dao.business.AuthMapper;
import com.yangwang.application.pet.market.model.business.Auth;
import com.yangwang.application.pet.market.service.service.AuthService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * <p>
 * 商家认证
 * </p>
 *
 * @author LiuXiangLin
 * @date 16:48 2020/3/14
 **/
@Service
public class AuthServiceImpl implements AuthService {
    @Resource
    AuthMapper authMapper;

    @Override
    public int save(Auth auth) {
        return authMapper.save(auth);
    }

    @Override
    public int delete(String businessNo) {
        return authMapper.delete(businessNo);
    }

    @Override
    public int update(Auth auth) {
        return authMapper.update(auth);
    }

    @Override
    public Auth getByBusinessNo(String businessNo) {
        Auth auth = authMapper.getByBusinessNo(businessNo);

        if (auth == null) {
            return auth;
        }
        String[] images;
        if (!StringUtils.isBlank(auth.getShopImages())) {
            images = auth.getShopImages().split(",");
            auth.setShopImg(images);
        }
        return auth;
    }

    @Override
    public int saveOrUpdate(Auth auth) {
        String[] imgs = auth.getShopImg();
        StringBuilder shopImages = new StringBuilder();

        if (imgs != null && imgs.length > 0) {
            for (String img : imgs) {
                shopImages.append(img).append(",");
            }
            //删除结尾的逗号
            shopImages.delete(shopImages.length() - 1, shopImages.length());
            auth.setShopImages(shopImages.toString());
        }
        return authMapper.saveOrUpdate(auth);
    }
}
