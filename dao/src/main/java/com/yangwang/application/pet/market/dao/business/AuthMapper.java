package com.yangwang.application.pet.market.dao.business;

import com.yangwang.application.pet.market.model.business.Auth;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


/**
 * <p>
 * 商家认证
 * </p>
 *
 * @author LiuXiangLin
 * @date 15:53 2020/3/14
 **/
@Mapper
public interface AuthMapper {
    /**
     * <p>
     * 新增一条商家认证
     * </p>
     *
     * @param auth 商家认证对象
     * @return int
     * @author LiuXiangLin
     * @date 15:55 2020/3/14
     **/
    int save(@Param("auth") Auth auth);

    /**
     * <p>
     * 更新商家认证
     * </p>
     *
     * @param auth 商家认证对象
     * @return int
     * @author LiuXiangLin
     * @date 15:57 2020/3/14
     **/
    int update(@Param("auth") Auth auth);

    /**
     * <p>
     * 通过商家编号删除数据
     * </p>
     *
     * @param businessNo 认证编号
     * @return int
     * @author LiuXiangLin
     * @date 16:01 2020/3/14
     **/
    int delete(@Param("businessNo") String businessNo);

    /**
     * <p>
     * 通过商家编号查询认证记录
     * </p>
     *
     * @param businessNo 商家编号
     * @return com.yangwang.application.pet.market.model.business.Auth
     * @author LiuXiangLin
     * @date 15:58 2020/3/14
     **/
    Auth getByBusinessNo(@Param("businessNo") String businessNo);

    /**
     * <p>
     * 新增或者更新认证
     * </p>
     *
     * @param auth 认证对象
     * @return int
     * @author LiuXiangLin
     * @date 18:30 2020/3/19
     **/
    int saveOrUpdate(@Param("auth") Auth auth);


}
