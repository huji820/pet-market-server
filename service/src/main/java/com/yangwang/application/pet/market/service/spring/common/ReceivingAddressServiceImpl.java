package com.yangwang.application.pet.market.service.spring.common;


import com.yangwang.application.pet.market.dao.common.ReceivingAddressMapper;
import com.yangwang.application.pet.market.model.common.ReceivingAddress;
import com.yangwang.application.pet.market.model.params.LonAndLat;
import com.yangwang.application.pet.market.service.facade.common.ReceivingAddressService;
import com.yangwang.application.pet.market.service.spring.consign.GaoDeMapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author LiuXiangLin
 * @date 16:10 2020/3/27
 **/
@Service
public class ReceivingAddressServiceImpl implements ReceivingAddressService {
    @Resource
    ReceivingAddressMapper receivingAddressMapper;

    @Resource
    GaoDeMapUtils gaoDeMapUtils;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int save(ReceivingAddress receivingAddress) {
        // 通过省市区获取地理位置
        LonAndLat lonAndLat = getLonAndLatByReceivingAddress(receivingAddress);
        if (lonAndLat == null) {
            return 0;
        }
        receivingAddress.setLatitude(Double.valueOf(lonAndLat.getLatitude()));
        receivingAddress.setLongitude(Double.valueOf(lonAndLat.getLatitude()));

        if (receivingAddress.getIsDefault() == 1) {
            receivingAddressMapper.updateAllToNoDefault(receivingAddress.getBusiness().getBusinessNo());
        }

        return receivingAddressMapper.save(receivingAddress);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int update(ReceivingAddress receivingAddress) {
        if (receivingAddress.getIsDefault() == 1) {
            receivingAddressMapper.updateAllToNoDefault(receivingAddress.getBusiness().getBusinessNo());
        }
        return receivingAddressMapper.update(receivingAddress);
    }

    @Override
    public int delete(int receivingNo) {
        return receivingAddressMapper.delete(receivingNo);
    }

    @Override
    public int updateDefault(ReceivingAddress receivingAddress) {
        receivingAddressMapper.updateAllToNoDefault(receivingAddress.getBusiness().getBusinessNo());
        receivingAddressMapper.updateDefault(receivingAddress.getBusiness().getBusinessNo(), receivingAddress.getReceivingNo());
        return 1;
    }

    @Override
    public List<ReceivingAddress> listByBusinessNo(String businessNo) {
        return receivingAddressMapper.listByBusinessNo(businessNo);
    }

    @Override
    public ReceivingAddress getDefault(String businessNo) {
        return receivingAddressMapper.getDefault(businessNo);
    }

    @Override
    public ReceivingAddress get(int receivingNo) {
        return receivingAddressMapper.get(receivingNo);
    }

    private LonAndLat getLonAndLatByReceivingAddress(ReceivingAddress receivingAddress) {
        if (StringUtils.isNotBlank(receivingAddress.getProvince())
                && StringUtils.isNotBlank(receivingAddress.getCity())
                && StringUtils.isNotBlank(receivingAddress.getCounty())
                && StringUtils.isNotBlank(receivingAddress.getDetailedAddress())
        ) {
            try {
                return gaoDeMapUtils.getLonAndLat(
                        receivingAddress.getProvince()
                                + receivingAddress.getCity()
                                + receivingAddress.getCounty()
                                + receivingAddress.getDetailedAddress());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}
