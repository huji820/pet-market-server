package com.yangwang.application.pet.market.service.spring.common;

import com.yangwang.application.pet.market.model.business.Follow;
import com.yangwang.application.pet.market.model.params.QueryFollowParam;
import com.yangwang.application.pet.market.service.facade.business.FollowFacadeService;
import com.yangwang.application.pet.market.service.spring.factory.FollowFactory;
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
 * @className FollowFacadeServiceImpl
 * @date 2020/3/21 13:42
 **/
@Service
public class FollowFacadeServiceImpl implements FollowFacadeService {
    @Resource
    FollowFactory followFactory;

    @Override
    public List<Follow> list(QueryFollowParam queryFollowParam) {
        return followFactory.getFollowService(queryFollowParam.getQueryType()).list(queryFollowParam);
    }

    @Override
    public int follow(Follow follow) {
        return followFactory.getFollowService(follow.getFollowType()).follow(follow);
    }

    @Override
    public int unFollow(Follow follow) {
        return followFactory.getFollowService(follow.getFollowType()).unFollow(follow);
    }

    @Override
    public Follow getByFollow(Follow follow) {
        return followFactory.getFollowService(follow.getFollowType()).getByFollow(follow);
    }
}
