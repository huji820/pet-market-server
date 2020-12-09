package com.yangwang.application.pet.market.service.service;

import com.yangwang.application.pet.market.model.business.Follow;
import com.yangwang.application.pet.market.model.params.QueryFollowParam;

import java.util.List;

/***
 * <p>
 * 商家关注
 * </p>
 *
 * @author YuZhengZhi
 * @date 15:43 2020/3/20
 **/
public interface FollowService {
    /**
     * <p>
     * 新增一个商家关注
     * </p>
     *
     * @param follow 商家关注对象
     * @return int
     * @author LiuXiangLin
     * @date 16:51 2020/3/20
     **/
    int save(Follow follow);

    /**
     * <p>
     * 删除商家关注列表
     * </p>
     *
     * @param followNo 列表编号
     * @return int
     * @author LiuXiangLin
     * @date 16:53 2020/3/20
     **/
    int delete(int followNo);

    /**
     * <p>
     * 通过两个商家编号删除数据
     * </p>
     *
     * @param follow 商家对象
     * @return int
     * @author LiuXiangLin
     * @date 9:28 2020/3/21
     **/
    int deleteByBusinessFollow(Follow follow);

    /**
     * <p>
     * 通过商家关注对象查询数据
     * </p>
     *
     * @param follow 商家关注对象
     * @return com.yangwang.application.pet.market.model.business.Follow
     * @author LiuXiangLin
     * @date 9:46 2020/3/21
     **/
    Follow getByBusinessFollow(Follow follow);

    /**
     * <p>
     * 查询关注列表
     * </p>
     *
     * @param queryFollowParam 查询参数
     * @return java.util.List<com.yangwang.application.pet.market.model.business.Follow>
     * @author LiuXiangLin
     * @date 17:08 2020/3/20
     **/
    List<Follow> list(QueryFollowParam queryFollowParam);
}
