package com.yangwang.application.pet.market.service.facade.service;

/**
 * 美容师作品集接口
 * @Description
 * @Author huji
 * @Date 2020-03-25 17:12
 * @Version 1.0
 */
public interface BeauticianWorkService {

    /**
     * 对作品集点赞
     * @param workId 作品主键
     * @param businessNo 点赞的客户
     * @return
     */
    int insertWorkLiked(long workId, String businessNo);
}
