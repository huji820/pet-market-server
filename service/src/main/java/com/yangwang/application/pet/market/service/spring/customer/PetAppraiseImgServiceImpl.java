package com.yangwang.application.pet.market.service.spring.customer;

import com.yangwang.application.pet.market.common.utils.CollectionUtils;
import com.yangwang.application.pet.market.dao.market.pet.PetAppraiseImgMapper;
import com.yangwang.application.pet.market.model.market.PetAppraiseImg;
import com.yangwang.application.pet.market.service.facade.customer.PetAppraiseImgService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * <p>
 *
 * </p>
 *
 * @author LiuXiangLin
 * @date 16:58 2020/3/23
 **/
@Service
public class PetAppraiseImgServiceImpl implements PetAppraiseImgService {
    @Resource
    PetAppraiseImgMapper petAppraiseImgMapper;

    @Override
    public int saveList(List<PetAppraiseImg> petAppraiseImgList) {
        if (CollectionUtils.isNotEmpty(petAppraiseImgList)) {
            return petAppraiseImgMapper.saveList(petAppraiseImgList);
        }
        return 0;
    }

    @Override
    public int delete(int petAppraiseNo) {
        return petAppraiseImgMapper.delete(petAppraiseNo);
    }
}
