package com.yangwang.application.pet.market.service.spring.common;

import com.yangwang.application.pet.market.common.enums.MessageStateTypeEnum;
import com.yangwang.application.pet.market.common.enums.MessageTypeEnum;
import com.yangwang.application.pet.market.model.business.Follow;
import com.yangwang.application.pet.market.model.common.CustomerMessage;
import com.yangwang.application.pet.market.model.common.Item;
import com.yangwang.application.pet.market.model.vo.ItemVo;
import com.yangwang.application.pet.market.service.facade.common.ItemDetailService;
import com.yangwang.application.pet.market.service.facade.common.MessagePushService;
import com.yangwang.application.pet.market.service.facade.common.MessageService;
import com.yangwang.application.pet.market.service.service.AuthService;
import com.yangwang.sysframework.utils.DateUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author yang hituzi
 * @description 商品的站内信推送
 * @date 2020年4月13日 15:19:05
 */
@Service("PushItemService")
public class MessagePushItemServiceImpl implements MessagePushService {

    @Resource
    ItemDetailService itemDetailService;

    @Resource
    MessageService messageService;

    @Resource
    AuthService authService;

    @Override
    public void messagePush(String commodityNo, Integer messageType) {
        //站内信类型不正确
        if (!this.judgeMessageType(messageType)) {
            return;
        }

        ItemVo itemVo = itemDetailService.get(Integer.parseInt(commodityNo));
        //获取关注的用户的手机号列表
        List<String> followBusinessNoList = this.listFollowBusinessNo(itemVo.getItem(), messageType);

        String messageTitle = MessageTypeEnum.getMsgByType(messageType);
        String nowTime = DateUtil.format(new Date(), DateUtil.FORMAT_FULL);
        String messageContact = this.getMessageContact(itemVo.getItem(), messageType);

        for (String receiveNo : followBusinessNoList) {
            //给关注的每个用户发送站内信
            CustomerMessage customerMessage = new CustomerMessage(receiveNo, messageTitle, messageContact,
                    MessageStateTypeEnum.UN_READ.getState(), nowTime, nowTime, "");
            messageService.insertMessage(customerMessage);
        }
    }

    @Override
    public void messagePushBusiness(String commodityNo, Integer messageType,String orderNo) {
        //站内信类型不正确
        if (!this.judgeMessageType(messageType)) {
            return;
        }
        //获取商家的编号
        ItemVo itemVo = itemDetailService.get(Integer.parseInt(commodityNo));
        String businessNo = itemVo.getItem().getBusiness().getBusinessNo();

        String messageTitle = MessageTypeEnum.getMsgByType(messageType);
        String nowTime = DateUtil.format(new Date(), DateUtil.FORMAT_FULL);
        String messageContact = "您的商品"+itemVo.getItem().getItemName()+"已售出,请及时处理订单，订单编号为"+orderNo+"。";

        //给商家发送站内信
        CustomerMessage customerMessage = new CustomerMessage(businessNo, messageTitle, messageContact,
                MessageStateTypeEnum.UN_READ.getState(), nowTime, nowTime, "");
        messageService.insertMessage(customerMessage);
    }

    /**
     * 获取关注该商家/商品的 用户的手机号列表
     *
     * @param item
     * @param messageType
     * @return java.util.List<java.lang.String>
     * @author yang hituzi
     * @date 18:01 2020/4/13
     */
    private List<String> listFollowBusinessNo(Item item, Integer messageType) {
        //店铺上新,获取所有关注店铺的用户的手机号
        if (MessageTypeEnum.COMMODITY_NEW.getType() == messageType) {
            return messageService.listFollowBusinessNo(item.getBusiness().getBusinessNo(), Follow.TYPE_BUSINESS);
        }
        //商品售出或下架,获取所有关注产品的用户的手机号码
        if (MessageTypeEnum.COMMODITY_SOLD.getType() == messageType
                || MessageTypeEnum.COMMODITY_REMOVE.getType() == messageType) {
            return messageService.listFollowBusinessNo(Integer.toString(item.getItemNo()), Follow.TYPE_ITEM);
        }
        return null;
    }

    /**
     * 获取站内信消息正文内容
     *
     * @param item
     * @param messageType
     * @return java.lang.String
     * @author yang hituzi
     * @date 9:56 2020/4/14
     */
    private String getMessageContact(Item item, Integer messageType) {
        StringBuffer messageContact = new StringBuffer("");
        //店铺上新
        if (MessageTypeEnum.COMMODITY_NEW.getType() == messageType) {
            String shopName = authService.getByBusinessNo(item.getBusiness().getBusinessNo()).getShopName();
            messageContact.append("您关注的店铺[")
                    .append(shopName)
                    .append("],发布了新品[")
                    .append(item.getItemName())
                    .append("],快去看看吧!");
        }
        //产品售出
        if (MessageTypeEnum.COMMODITY_SOLD.getType() == messageType) {
            messageContact.append("您关注的商品[")
                    .append(item.getItemName())
                    .append("]正在大卖,心动不如行动!赶快来购买吧!");
        }
        //产品下架
        if (MessageTypeEnum.COMMODITY_REMOVE.getType() == messageType) {
            messageContact.append("很抱歉,您关注的商品[")
                    .append(item.getItemName())
                    .append("]已经下架,去看看其它类似商品吧!");
        }
        return messageContact.toString();
    }

    /**
     * 判断站内信类型是否正确,正确返回true,不正确返回false
     *
     * @param messageType
     * @return boolean
     * @author yang hituzi
     * @date 10:11 2020/4/14
     */
    public boolean judgeMessageType(Integer messageType) {
        return messageType != null
                && (MessageTypeEnum.COMMODITY_NEW.getType() == messageType
                || MessageTypeEnum.COMMODITY_SOLD.getType() == messageType
                || MessageTypeEnum.COMMODITY_REMOVE.getType() == messageType
                || MessageTypeEnum.COMMODITY_SALESTIPS.getType() == messageType
        );
    }
}
