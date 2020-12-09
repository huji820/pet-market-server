package com.yangwang.application.pet.market.service.facade.business;

import com.yangwang.application.pet.market.model.vo.ItemVo;

public interface BusinessIssuingService {

    /**
     *
     * 从厂家进货
     * @param businessNo
     * @param itemVo
     * @return int
     * @author yang hituzi
     * @date 17:01 2020/4/14
     */
    int purchase(String businessNo, ItemVo itemVo);

}
