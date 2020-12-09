package com.yangwang.application.pet.market.dao.service;

import com.yangwang.application.pet.market.model.service.Service;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 服务
 * </p>
 *
 * @author LiuXiangLin
 * @date 9:15 2020/4/2
 **/
public interface ServiceInfoMapper {

    /**
     * 插入服务详情
     *
     * @param service
     * @return
     */
    int insertServiceInfo(Service service);

    /**
     * 修改服务详情
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
     * @param state
     * @return
     */
    List<Service> listServiceByBusinessNo(@Param("businessNo") String businessNo,
                                          @Param("offset") int offset,
                                          @Param("limit") int limit,
                                          @Param("state") int state);

    /**
     * <p>
     * 更新服务状态
     * </p>
     *
     * @param serviceId 服务主键
     * @param state     状态
     * @return int
     * @author LiuXiangLin
     * @date 9:07 2020/6/9
     **/
    int updateState(@Param("serviceId") long serviceId, @Param("state") Boolean state);


    /**
     * <p>
     * 通过商家编号以及类型查询服务列表
     * </p>
     *
     * @param businessNo 商家编号
     * @param typeNo 服务类型
     * @return java.util.List<com.yangwang.application.pet.market.model.service.Service>
     * @author LiuXiangLin
     * @date 15:24 2020/6/18
     **/
    List<Service> listByBusinessNoAndType(@Param("businessNo")String businessNo,@Param("typeNo")long typeNo);

    /**
     * 通过服务id获取服务
     * @param serviceId 服务主键
     * @return
     */
    Service getByServiceId(@Param("serviceId")long serviceId);
}
