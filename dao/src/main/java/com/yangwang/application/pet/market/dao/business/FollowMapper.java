package com.yangwang.application.pet.market.dao.business;

import com.yangwang.application.pet.market.model.business.Follow;
import com.yangwang.application.pet.market.model.params.QueryFollowParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 商家关注
 * </p>
 *
 * @author YuZhengZhi
 * @date 15:46 2020/3/20
 **/
@Mapper
public interface FollowMapper {
    /**
     * <p>
     * 新增一条关注
     * </p>
     *
     * @param follow 关注对象
     * @return int
     * @author LiuXiangLin
     * @date 15:55 2020/3/20
     **/
    int save(@Param("follow") Follow follow);

    /**
     * <p>
     * 删除一条关注数据
     * </p>
     *
     * @param followNo 关注编号
     * @return int
     * @author LiuXiangLin
     * @date 15:57 2020/3/20
     **/
    int delete(@Param("followNo") int followNo);

    /**
     * <p>
     * 通过两个商家编号删除数据大
     * </p>
     *
     * @param follow 商家对象
     * @return int
     * @author LiuXiangLin
     * @date 9:29 2020/3/21
     **/
    int deleteByBusinessFollow(@Param("follow") Follow follow);

    /**
     * <p>
     * 通过对象查询对象
     * </p>
     *
     * @param follow 商家关注对象
     * @return com.yangwang.application.pet.market.model.business.MarletFollow
     * @author LiuXiangLin
     * @date 9:42 2020/3/21
     **/
    Follow getByBusinessFollow(@Param("follow") Follow follow);


    /**
     * <p>
     * 查询列表
     * </p>
     *
     * @param queryFollowParam 查询对象
     * @return java.util.List<com.yangwang.application.pet.market.model.business.MarletFollow>
     * @author LiuXiangLin
     * @date 16:27 2020/3/20
     **/
    List<Follow> list(@Param("queryFollowParam") QueryFollowParam queryFollowParam);
}
