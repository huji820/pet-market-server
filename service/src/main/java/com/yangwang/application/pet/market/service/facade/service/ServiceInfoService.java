package com.yangwang.application.pet.market.service.facade.service;

import com.yangwang.application.pet.market.model.service.Service;

import java.util.List;

public interface ServiceInfoService {

    /**
     * 插入服务详情
     *
     * @param service
     * @return
     */
    int insertServiceInfo(Service service);

    /**
     * 修改服务
     *
     * @param service
     * @return
     */
    int updateServiceInfo(Service service);

    /**
     * 查询我已发布的服务列表
     *
     * @param businessNo
     * @param offset
     * @param limit
     * @return
     */
    List<Service> listServiceByBusinessNo(String businessNo, int offset, int limit, int state);

    /**
     * <p>
     * 更新服务状态
     * </p>
     *
     * @param serviceId 服务主键
     * @param state     状态
     * @return int
     * @author LiuXiangLin
     * @date 9:06 2020/6/9
     **/
    int updateServiceState(long serviceId, Boolean state);

    /**
     * <p>
     * 通过商家编号以及服务类型查询服务
     * </p>
     *
     * @param businessNo 商家编号
     * @param serviceTypeNo 服务类型主键
     * @return java.util.List<com.yangwang.application.pet.market.model.service.Service>
     * @author LiuXiangLin
     * @date 15:22 2020/6/18
     **/
    List<Service> listByBusinessNoAndType(String businessNo,long serviceTypeNo);
}
