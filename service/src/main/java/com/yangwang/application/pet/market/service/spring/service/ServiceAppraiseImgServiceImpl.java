package com.yangwang.application.pet.market.service.spring.service;

import com.yangwang.application.pet.market.common.utils.CollectionUtils;
import com.yangwang.application.pet.market.dao.market.item.ItemAppraiseImgMapper;
import com.yangwang.application.pet.market.dao.service.ServiceAppraiseImgMapper;
import com.yangwang.application.pet.market.model.market.ItemAppraiseImg;
import com.yangwang.application.pet.market.model.service.ServiceAppraiseImg;
import com.yangwang.application.pet.market.service.facade.customer.ItemAppraiseImgService;
import com.yangwang.application.pet.market.service.facade.service.ServiceAppraiseImgService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author LiuXiangLin
 * @date 9:36 2020/3/24
 **/
@Service
public class ServiceAppraiseImgServiceImpl implements ServiceAppraiseImgService {

    @Resource
    ServiceAppraiseImgMapper serviceAppraiseImgMapper;

    @Override
    public int save(List<ServiceAppraiseImg> appraiseImgList) {
        if (CollectionUtils.isNotEmpty(appraiseImgList)) {
            return serviceAppraiseImgMapper.saveList(appraiseImgList);
        }
        return 0;
    }

    @Override
    public int deleteByAppraiseNo(int itemAppraiseNo) {
        return serviceAppraiseImgMapper.deleteByAppraiseNo(itemAppraiseNo);
    }
}
