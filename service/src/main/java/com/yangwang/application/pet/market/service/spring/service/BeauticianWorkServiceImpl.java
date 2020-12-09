package com.yangwang.application.pet.market.service.spring.service;

import com.yangwang.application.pet.market.dao.service.BeauticianWorkMapper;
import com.yangwang.application.pet.market.service.facade.service.BeauticianWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BeauticianWorkServiceImpl implements BeauticianWorkService {

    @Autowired
    BeauticianWorkMapper beauticianWorkMapper;

    @Override
    public int insertWorkLiked(long workId, String businessNo) {
        return beauticianWorkMapper.insertWorkLiked(workId, businessNo);
    }
}
