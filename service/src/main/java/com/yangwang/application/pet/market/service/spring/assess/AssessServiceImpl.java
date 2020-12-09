package com.yangwang.application.pet.market.service.spring.assess;

import com.yangwang.application.pet.market.dao.assess.AssessMapper;
import com.yangwang.application.pet.market.model.assess.Assess;
import com.yangwang.application.pet.market.service.facade.assess.AssessService;
import com.yangwang.application.pet.market.service.facade.common.ItemService;
import com.yangwang.sysframework.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @TODO
 * @Description
 * @Author Administrator
 * @Date 2020-05-17 14:23
 * @Version 1.0
 */
@Service
public class AssessServiceImpl implements AssessService {

    @Resource
    AssessMapper assessMapper;

    @Resource
    ItemService itemService;

    @Override
    public int save(Assess assess) {
        Date now = new Date();
        String time = DateUtil.format(now, DateUtil.FORMAT_SIMPLE);
        assess.setReleaseTime(time);
        return assessMapper.save(assess);
    }

    @Override
    public List<Assess> listReCommend() {
        return assessMapper.listReCommend();
    }

    @Override
    public List<Assess> list(int offset, int limit) {
        return assessMapper.list(offset, limit);
    }

    @Override
    public Assess getByAssessNo(Long assessNo) {
        return assessMapper.getByAssessNo(assessNo);
    }

    @Override
    public List<Assess> listAllAssess(String query, String releaseTime, Integer offset, Integer limit) {
        List<Assess> allAssess;
        if(offset==null){
            offset = 0;
        }
        if (limit==null){
            limit = 6;
        }
        if(query!=null){
            List<Integer> list = itemService.listItemNoByName(query);
            allAssess = assessMapper.listAllAssess(query, releaseTime, list, offset, limit);
        }else{
            allAssess = assessMapper.listAllAssess(null, releaseTime, null, offset, limit);
        }
        return allAssess;
    }
}
