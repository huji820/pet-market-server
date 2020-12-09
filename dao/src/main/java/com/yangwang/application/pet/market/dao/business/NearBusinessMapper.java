package com.yangwang.application.pet.market.dao.business;

import com.yangwang.application.pet.market.model.vo.AreaBusinessVO;
import com.yangwang.application.pet.market.model.vo.BusinessNearResultVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 本地商家
 * </p>
 *
 * @author LiuXiangLin
 * @date 9:14 2020/4/2
 **/
@Mapper
public interface NearBusinessMapper {
    /**
     * 获取区域内商家
     *
     * @param city
     * @param area
     * @param lng
     * @param lat
     * @return
     */
    List<AreaBusinessVO> listAreaBusinessNearResultVo(@Param("city") String city, @Param("area") String area, @Param("lng") double lng, @Param("lat") double lat, @Param("offset") int offset, @Param("limit") int limit);

    /**
     * <p>
     * 查询所有的城市
     * </p>
     *
     * @param
     * @return java.util.List<java.lang.String>
     * @author LiuXiangLin
     * @date 10:09 2020/6/18
     **/
    List<String> listAllCity();
}
