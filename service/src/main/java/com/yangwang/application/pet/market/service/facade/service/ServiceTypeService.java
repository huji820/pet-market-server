package com.yangwang.application.pet.market.service.facade.service;

import com.yangwang.application.pet.market.model.params.QueryServiceBusinessParam;
import com.yangwang.application.pet.market.model.service.ServiceType;
import com.yangwang.application.pet.market.model.vo.ServiceBusinessVO;

import java.math.BigDecimal;
import java.util.List;

/**
 * 服务分类获取
 */
public interface ServiceTypeService {

    /**
     * 获取服务的分类
     * @return
     */
    List<ServiceType> listServiceType();

    /**
     *
     * 根据服务类型和用户经纬度,查询最近的6家门店
     * @param queryServiceBusinessParam
     * @return java.util.List<com.yangwang.application.pet.market.model.vo.ServiceBusinessVO>
     * @author yang hituzi
     * @date 16:08 2020/4/10
     */
    List<ServiceBusinessVO> listServiceBusiness(QueryServiceBusinessParam queryServiceBusinessParam);

    /**
     * <p>
     * 查询商家所有的服务类型
     * </p>
     *
     * @param businessNo 商家编号
     * @return java.util.List<com.yangwang.application.pet.market.model.service.ServiceType>
     * @author LiuXiangLin
     * @date 15:14 2020/6/18
     **/
    List<ServiceType> listByBusinessNo(String businessNo);
}
