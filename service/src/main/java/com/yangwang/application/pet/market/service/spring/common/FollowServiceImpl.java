package com.yangwang.application.pet.market.service.spring.common;

import com.yangwang.application.pet.market.dao.business.FollowMapper;
import com.yangwang.application.pet.market.model.business.Follow;
import com.yangwang.application.pet.market.model.params.QueryFollowParam;
import com.yangwang.application.pet.market.service.service.FollowService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/***
 * <p>
 * 关注
 * </p>
 *
 * @author YuZhengZhi
 * @date 15:43 2020/3/20
 **/
@Service
public class FollowServiceImpl implements FollowService {
    @Resource
    FollowMapper followMapper;

    @Override
    public int save(Follow follow) {
        return followMapper.save(follow);
    }

    @Override
    public int delete(int followNo) {
        return followMapper.delete(followNo);
    }

    @Override
    public int deleteByBusinessFollow(Follow follow) {
        return followMapper.deleteByBusinessFollow(follow);
    }

    @Override
    public Follow getByBusinessFollow(Follow follow) {
        return followMapper.getByBusinessFollow(follow);
    }

    @Override
    public List<Follow> list(QueryFollowParam queryFollowParam) {
        return followMapper.list(queryFollowParam);
    }
}
