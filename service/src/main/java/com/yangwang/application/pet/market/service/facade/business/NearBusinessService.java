package com.yangwang.application.pet.market.service.facade.business;

import com.yangwang.application.pet.market.model.vo.AreaBusinessVO;

import java.util.List;

/**
 * 附近驿站的service
 *
 * @Description
 * @Author Administrator
 * @Date 2020-03-21 10:22
 * @Version 1.0
 */
public interface NearBusinessService {

    /**
     * 根据城市获取商家
     *
     * @param city
     * @param area
     * @param lng
     * @param lat
     * @param offset
     * @param limit
     * @return
     */
    List<AreaBusinessVO> getBusinessNearResultVo(String city, String area, double lng, double lat, int offset, int limit);

    /**
     * <p>
     * 查询所有的城市
     * </p>
     *
     * @param
     * @return java.util.List<java.lang.String>
     * @author LiuXiangLin
     * @date 10:08 2020/6/18
     **/
    List<String> listAllCity();
}
