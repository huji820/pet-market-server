package com.yangwang.application.pet.market.dao.service;

import com.yangwang.application.pet.market.model.params.QueryServiceBusinessParam;
import com.yangwang.application.pet.market.model.service.ServiceType;
import com.yangwang.application.pet.market.model.vo.ServiceBusinessVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

/**
 * 服务分类实现
 * @Description
 * @Author Administrator
 * @Date 2020-03-30 14:09
 * @Version 1.0
 */
@Mapper
public interface ServiceTypeMapper {
    List<ServiceType> listServiceType();

    /**
     *
     * 根据服务类型和用户经纬度,查询最近的6家门店
     * @param queryServiceBusinessParam
     * @return java.util.List<com.yangwang.application.pet.market.model.vo.ServiceBusinessVO>
     * @author yang hituzi
     * @date 16:09 2020/4/10
     */
    List<ServiceBusinessVO> listServiceBusiness(@Param("queryServiceBusinessParam") QueryServiceBusinessParam queryServiceBusinessParam);

    /**
     * <p>
     * 查询商家所有发布的服务类型
     * </p>
     *
     * @param businessNo 商家编号
     * @return java.util.List<com.yangwang.application.pet.market.model.service.ServiceType>
     * @author LiuXiangLin
     * @date 15:15 2020/6/18
     **/
    List<ServiceType> listByBusinessNo(@Param("businessNo")String businessNo);
}
