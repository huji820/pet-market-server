package com.yangwang.application.pet.market.service.spring.customer;

import com.yangwang.application.pet.market.common.utils.CollectionUtils;
import com.yangwang.application.pet.market.dao.market.item.ItemAppraiseImgMapper;
import com.yangwang.application.pet.market.model.market.ItemAppraiseImg;
import com.yangwang.application.pet.market.service.facade.customer.ItemAppraiseImgService;
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
public class ItemAppraiseImgServiceImpl implements ItemAppraiseImgService {
    @Resource
    ItemAppraiseImgMapper itemAppraiseImgMapper;

    @Override
    public int save(List<ItemAppraiseImg> appraiseImgList) {
        if (CollectionUtils.isNotEmpty(appraiseImgList)) {
            return itemAppraiseImgMapper.saveList(appraiseImgList);
        }
        return 0;
    }

    @Override
    public int deleteByAppraiseNo(int itemAppraiseNo) {
        return itemAppraiseImgMapper.deleteByAppraiseNo(itemAppraiseNo);
    }
}
