package com.yangwang.application.pet.market.dao.service;

import com.yangwang.application.pet.market.model.service.ServiceScenePic;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 服务图片
 * </p>
 *
 * @author LiuXiangLin
 * @date 9:19 2020/4/2
 **/
public interface ServiceScenePicMapper {

    /**
     * 批量插入服务图片
     * @param pics
     * @return
     */
    int insertServiceImage(@Param("pics") List<ServiceScenePic> pics);

    /**
     * 服务主键
     * @param serviceID
     */
    void deleteServiceImage(@Param("serviceID") long serviceID);
}
