package com.yangwang.application.pet.market.service.service;

import com.yangwang.application.pet.market.model.business.Follow;
import com.yangwang.application.pet.market.model.params.QueryFollowParam;

import java.util.List;

/**
 * <p>
 * 关注
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className BaseFollowService
 * @date 2020/3/21 11:00
 **/
public interface BaseFollowService {
    /**
     * <p>
     * 查询关注列表
     * </p>
     *
     * @param queryFollowParam 关注列表
     * @return int
     * @author LiuXiangLin
     * @date 11:04 2020/3/21
     **/
    List<Follow> list(QueryFollowParam queryFollowParam);

    /**
     * <p>
     * 添加关注
     * </p>
     *
     * @param follow 关注对象
     * @return int
     * @author LiuXiangLin
     * @date 11:05 2020/3/21
     **/
    int follow(Follow follow);

    /**
     * <p>
     * 取消关注
     * </p>
     *
     * @param follow 关注对象
     * @return int
     * @author LiuXiangLin
     * @date 11:05 2020/3/21
     **/
    int unFollow(Follow follow);

    /**
     * <p>
     * 通过follow对象中的参数获取对象
     * </p>
     *
     * @param follow follow对象
     * @return int
     * @author LiuXiangLin
     * @date 14:13 2020/3/21
     **/
    Follow getByFollow(Follow follow);
}
