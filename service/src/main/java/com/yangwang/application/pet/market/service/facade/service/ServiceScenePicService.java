package com.yangwang.application.pet.market.service.facade.service;

import com.yangwang.application.pet.market.model.service.ServiceScenePic;

import java.util.List;

/**
 * @TODO
 * @Description
 * @Author Administrator
 * @Date 2020-03-31 18:23
 * @Version 1.0
 */
public interface ServiceScenePicService {

    /**
     * 批量插入服务图片
     * @param pics
     * @return
     */
    int insertServiceImage(List<ServiceScenePic> pics);

    /**
     * 服务主键
     * @param serviceID
     */
    void deleteServiceImage(long serviceID);
}
