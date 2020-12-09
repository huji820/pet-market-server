package com.yangwang.application.pet.market.service.spring.common;

import com.yangwang.application.pet.market.common.enums.MessageStateTypeEnum;
import com.yangwang.application.pet.market.common.enums.MessageTypeEnum;
import com.yangwang.application.pet.market.model.business.Business;
import com.yangwang.application.pet.market.model.business.Follow;
import com.yangwang.application.pet.market.model.common.CustomerMessage;
import com.yangwang.application.pet.market.model.common.Pet;
import com.yangwang.application.pet.market.service.facade.common.MessagePushService;
import com.yangwang.application.pet.market.service.facade.common.MessageService;
import com.yangwang.application.pet.market.service.facade.common.PetService;
import com.yangwang.application.pet.market.service.service.AuthService;
import com.yangwang.application.pet.market.service.service.BusinessService;
import com.yangwang.sysframework.utils.DateUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author yang hituzi
 * @description 宠物站内信推送
 * @date 2020年4月13日 15:19:53
 */
@Service("MessagePetService")
public class MessagePushPetServiceImpl implements MessagePushService {

    @Resource
    PetService petService;

    @Resource
    MessageService messageService;

    @Resource
    AuthService authService;

    @Resource
    BusinessService businessService;

    @Override
    public void messagePush(String commodityNo, Integer messageType) {
        //站内信类型不正确
        if(!this.judgeMessageType(messageType)){
            return;
        }

        Pet pet = petService.get(commodityNo);
        //获取关注的用户的手机号列表
        List<String> followBusinessNoList = this.listFollowBusinessNo(pet,messageType);

        String messageTitle = MessageTypeEnum.getMsgByType(messageType);
        String messageContact = this.getMessageContact(pet,messageType);
        String nowTime = DateUtil.format(new Date(),DateUtil.FORMAT_FULL);

        for(String receiveNo : followBusinessNoList){
            //给每个关注的用户发送站内信
            CustomerMessage customerMessage = new CustomerMessage(receiveNo,messageTitle,messageContact,
                    MessageStateTypeEnum.UN_READ.getState(),nowTime,nowTime,"");
            messageService.insertMessage(customerMessage);
        }
    }

    @Override
    public void messagePushBusiness(String commodityNo, Integer messageType,String orderNo) {
        //站内信类型不正确
        if (!this.judgeMessageType(messageType)) {
            return;
        }
        //获取商家的联系电话
        Pet pet = petService.get(commodityNo);
        Business business = businessService.getByBusinessNoWithOutState(pet.getBusiness().getBusinessNo());
        String businessNo = business.getBusinessNo();

        String messageTitle = MessageTypeEnum.getMsgByType(messageType);
        String nowTime = DateUtil.format(new Date(), DateUtil.FORMAT_FULL);
        String messageContact = "您的宠物"+pet.getPetName()+"已售出,请及时处理订单,订单编号为"+orderNo+"。";

        //给商家发送站内信
        CustomerMessage customerMessage = new CustomerMessage(businessNo, messageTitle, messageContact,
                MessageStateTypeEnum.UN_READ.getState(), nowTime, nowTime, "");
        messageService.insertMessage(customerMessage);
    }

    /**
     *
     * 获取关注该商家/宠物 的用户的手机号列表
     * @param pet
     * @param messageType
     * @return java.util.List<java.lang.String>
     * @author yang hituzi
     * @date 18:07 2020/4/13
     */
    private List<String> listFollowBusinessNo(Pet pet, Integer messageType){
        //店铺上新,获取所有关注店铺的用户的手机号
        if(MessageTypeEnum.COMMODITY_NEW.getType() == messageType){
            return messageService.listFollowBusinessNo(pet.getBusiness().getBusinessNo(), Follow.TYPE_BUSINESS);
        }
        //宠物售出或下架,获取所有关注产品的用户的手机号码
        if(MessageTypeEnum.COMMODITY_SOLD.getType() == messageType
        || MessageTypeEnum.COMMODITY_REMOVE.getType() == messageType){
            return messageService.listFollowBusinessNo(pet.getPetNo(), Follow.TYPE_PET);
        }
        return null;
    }

    /**
     *
     * 获取站内信推送正文内容
     * @param pet
     * @param messageType
     * @return java.lang.String
     * @author yang hituzi
     * @date 10:20 2020/4/14
     */
    private String getMessageContact(Pet pet, Integer messageType){
        StringBuffer messageContact = new StringBuffer("");
        //店铺上新
        if(MessageTypeEnum.COMMODITY_NEW.getType() == messageType){
            String shopName = authService.getByBusinessNo(pet.getBusiness().getBusinessNo()).getShopName();
            messageContact.append("您关注的店铺[")
                    .append(shopName)
                    .append("],发布了新宠[")
                    .append(pet.getPetName())
                    .append("],快去看看吧!");
        }
        //宠物售出
        if(MessageTypeEnum.COMMODITY_SOLD.getType() == messageType){
            messageContact.append("您关注的宠物[")
                    .append(pet.getPetName())
                    .append("]正在大卖,心动不如行动!赶快来购买吧!");
        }
        //宠物下架
        if(MessageTypeEnum.COMMODITY_REMOVE.getType() == messageType){
            messageContact.append("很抱歉,您关注的宠物[")
                    .append(pet.getPetName())
                    .append("]已下架,去看看其它宠物吧!");
        }
        return messageContact.toString();
    }

    /**
     *
     * 判断站内信类型是否正确,正确返回true,不正确返回false
     * @param messageType
     * @return boolean
     * @author yang hituzi
     * @date 10:13 2020/4/14
     */
    public boolean judgeMessageType(Integer messageType){
        return messageType != null
                && (MessageTypeEnum.COMMODITY_NEW.getType() == messageType
                || MessageTypeEnum.COMMODITY_SOLD.getType() == messageType
                || MessageTypeEnum.COMMODITY_REMOVE.getType() == messageType
                || MessageTypeEnum.COMMODITY_SALESTIPS.getType() == messageType);
    }
}
