package com.yangwang.application.pet.market.service.spring.common;

import com.yangwang.application.pet.market.model.business.Follow;
import com.yangwang.application.pet.market.model.params.QueryFollowParam;
import com.yangwang.application.pet.market.service.service.FollowService;
import com.yangwang.application.pet.market.service.service.BaseFollowService;
import com.yangwang.application.pet.market.service.facade.common.PetService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className PetFollowServiceImpl
 * @date 2020/3/21 11:34
 **/
@Service
public class PetFollowServiceImpl implements BaseFollowService {
    @Resource
    PetService petService;

    @Resource
    FollowService followService;

    @Override
    public List<Follow> list(QueryFollowParam queryFollowParam) {
        return followService.list(queryFollowParam);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int follow(Follow follow) {
        // 未关注才修改数据
        if (followService.getByBusinessFollow(follow) == null) {
            // 修改粉丝数量
            petService.updateCollectionAdd(follow.getPet().getPetNo(), 1);
            // 添加一条数据
            followService.save(follow);
        }
        return 1;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int unFollow(Follow follow) {
        // 关注了之后才可以取关
        if (followService.getByBusinessFollow(follow) != null) {
            // 修改粉丝数量
            petService.updateCollectionSub(follow.getPet().getPetNo(), 1);
            // 删除一条数据
            followService.deleteByBusinessFollow(follow);
        }
        return 1;
    }

    @Override
    public Follow getByFollow(Follow follow) {
        return followService.getByBusinessFollow(follow);
    }
}
