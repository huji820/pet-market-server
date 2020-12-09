package com.yangwang.application.pet.market.service.spring.business;

import com.yangwang.application.pet.market.dao.business.NearBusinessMapper;
import com.yangwang.application.pet.market.model.vo.AreaBusinessVO;
import com.yangwang.application.pet.market.service.facade.business.NearBusinessService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @TODO
 * @Description
 * @Author Administrator
 * @Date 2020-03-21 10:23
 * @Version 1.0
 */
@Service
public class NearBusinessServiceImpl implements NearBusinessService {
    @Resource
    NearBusinessMapper nearBusinessMapper;

    @Override
    public List<AreaBusinessVO> getBusinessNearResultVo(String city, String area, double lng, double lat, int offset, int limit) {
        List<AreaBusinessVO> areaBusinessVos = nearBusinessMapper.listAreaBusinessNearResultVo(city, area, lng, lat, offset, limit);
        for (AreaBusinessVO areaBusinessVO : areaBusinessVos) {
            areaBusinessVO.setNum(areaBusinessVO.getBusinesses() == null ? 0 : areaBusinessVO.getBusinesses().size());
        }
        return areaBusinessVos;
    }

    @Override
    public List<String> listAllCity() {
        return nearBusinessMapper.listAllCity();
    }
}
