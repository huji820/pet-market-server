package com.yangwang.application.pet.market.service.spring.common;

import com.yangwang.application.pet.market.model.business.Follow;
import com.yangwang.application.pet.market.model.params.QueryFollowParam;
import com.yangwang.application.pet.market.service.service.FollowService;
import com.yangwang.application.pet.market.service.service.BaseFollowService;
import com.yangwang.application.pet.market.service.facade.common.ItemService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 商品关注
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className ItemFollowServiceImpl
 * @date 2020/3/21 11:32
 **/
@Service
public class ItemFollowServiceImpl implements BaseFollowService {
    @Resource
    FollowService followService;

    @Resource
    ItemService itemService;

    @Override
    public List<Follow> list(QueryFollowParam queryFollowParam) {
        return followService.list(queryFollowParam);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int follow(Follow follow) {
        // 获取关注状态
        if (followService.getByBusinessFollow(follow) == null) {
            // 关注数量 + 1
            itemService.updateCollectionAdd(follow.getItem().getItemNo(), 1);

            // 插入关注表
            followService.save(follow);

            return 1;
        }

        return 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int unFollow(Follow follow) {
        if (followService.getByBusinessFollow(follow) != null) {
            // 关注数量 - 1
            itemService.updateCollectionSub(follow.getItem().getItemNo(), 1);

            // 删除一条关注记录
            followService.deleteByBusinessFollow(follow);

            return 1;
        }

        return 0;
    }

    @Override
    public Follow getByFollow(Follow follow) {
        return followService.getByBusinessFollow(follow);
    }
}
