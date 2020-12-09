package com.yangwang.application.pet.market.service.spring.common;

import com.yangwang.application.pet.market.dao.common.MessageMapper;
import com.yangwang.application.pet.market.model.common.CustomerMessage;
import com.yangwang.application.pet.market.model.params.QueryMessageParam;
import com.yangwang.application.pet.market.service.facade.common.MessageService;
import com.yangwang.sysframework.utils.DateUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author yang hituzi
 * @description 站内信/推送消息`
 * @date 2020年4月13日 11:11:20
 */
@Service
public class MessageServiceImpl implements MessageService {

    @Resource
    MessageMapper messageMapper;

    @Override
    public int insertMessage(CustomerMessage customerMessage) {
        return messageMapper.insertMessage(customerMessage);
    }

    @Override
    public int updateMessage(Integer messageNo) {
        String updateTime = DateUtil.format(new Date(),DateUtil.FORMAT_FULL);
        return messageMapper.updateMessage(messageNo,updateTime);
    }

    @Override
    public CustomerMessage getMessageByNo(Integer messageNo) {
        return messageMapper.getMessageByNo(messageNo);
    }

    @Override
    public List<CustomerMessage> listMessageByBusinessNo(String businessNo,Integer offset,Integer limit) {
        if(offset==null){
            offset = 0;
        }
        if(limit==null){
            limit = 10;
        }
        return messageMapper.listMessageByBusinessNo(businessNo, offset, limit);
    }

    @Override
    public List<String> listFollowBusinessNo(String keyNo, Integer queryType) {
        return messageMapper.listFollowBusinessNo(keyNo, queryType);
    }

    @Override
    public List<CustomerMessage> listMessageByUpdateTimeAndBusinessNo(String phone, String lastGetTime) {
        return messageMapper.listMessageByUpdateTimeAndBusinessNo(phone, lastGetTime);
    }
    @Override
    public int countMsgByUpdateTimeAndBusinessNo(String phone, String lastGetTime) {
        return messageMapper.countMsgByUpdateTimeAndBusinessNo(phone, lastGetTime);
    }
}
