package com.yangwang.application.pet.market.service.facade.business;

import com.yangwang.application.pet.market.model.business.Follow;
import com.yangwang.application.pet.market.model.params.QueryFollowParam;

import java.util.List;

/**
 * <p>
 * 关注门面接口
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className FollowFacadeService
 * @date 2020/3/21 13:40
 **/
public interface FollowFacadeService {
    /**
     * <p>
     * 查询关注列表
     * </p>
     *
     * @param queryFollowParam 查询对象
     * @return int
     * @author LiuXiangLin
     * @date 13:41 2020/3/21
     **/
    List<Follow> list(QueryFollowParam queryFollowParam);

    /**
     * <p>
     * 添加关注
     * </p>
     *
     * @param follow 门面对象
     * @return int
     * @author LiuXiangLin
     * @date 13:42 2020/3/21
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
     * @date 13:42 2020/3/21
     **/
    int unFollow(Follow follow);

    /**
     * <p>
     * 通过对象中的参数获取数据
     * </p>
     *
     * @param follow follow对象
     * @return com.yangwang.application.pet.market.model.business.Follow
     * @author LiuXiangLin
     * @date 14:12 2020/3/21
     **/
    Follow getByFollow(Follow follow);
}
