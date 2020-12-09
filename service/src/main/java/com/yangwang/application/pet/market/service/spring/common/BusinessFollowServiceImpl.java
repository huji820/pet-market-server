package com.yangwang.application.pet.market.service.spring.common;

import com.yangwang.application.pet.market.model.business.Follow;
import com.yangwang.application.pet.market.model.params.QueryFollowParam;
import com.yangwang.application.pet.market.service.service.FollowService;
import com.yangwang.application.pet.market.service.service.BusinessService;
import com.yangwang.application.pet.market.service.service.BaseFollowService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 商家关注
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className BusinessBaseFollowFacedServiceImpl
 * @date 2020/3/20 17:26
 **/
@Service
public class BusinessFollowServiceImpl implements BaseFollowService {

    @Resource
    FollowService followService;

    @Resource
    BusinessService businessService;

    @Override
    public List<Follow> list(QueryFollowParam queryFollowParam) {
        return followService.list(queryFollowParam);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int follow(Follow follow) {
        // 获取关注状态
        if (followService.getByBusinessFollow(follow) == null) {
            // 修改被商家粉丝数量
            businessService.updateFansAdd(follow.getFollowBusiness().getBusinessNo(), 1);
            // 修改商家的关注数
            businessService.updateFollowAdd(follow.getBusiness().getBusinessNo(), 1);
            // 添加一条关注信息
            followService.save(follow);
        }
        return 1;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int unFollow(Follow follow) {
        if (followService.getByBusinessFollow(follow) != null) {
            // 修改被关注商家粉丝数量
            businessService.updateFansSub(follow.getFollowBusiness().getBusinessNo(), 1);
            // 修改商家关注数
            businessService.updateFollowSub(follow.getBusiness().getBusinessNo(), 1);
            // 删除一条关注信息
            followService.deleteByBusinessFollow(follow);
        }
        return 1;
    }

    @Override
    public Follow getByFollow(Follow follow) {
        return followService.getByBusinessFollow(follow);
    }
}
