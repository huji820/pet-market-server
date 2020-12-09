package com.yangwang.application.pet.market.service.spring.task;

import com.yangwang.application.pet.market.common.utils.WeChatCheckUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 定时获取access_token
 */
@Component
@Configuration
@EnableScheduling
public class AccessTokenTask {

    @Resource
    WeChatCheckUtils weChatCheckUtils;

    @Scheduled( cron = "0 0 0/3 * * ?")
    @Scheduled( cron = "0 30 1/3 * * ?")
    public void getAccessToken(){
        //每隔一个半小时执行一次获取access_token值的方法
        weChatCheckUtils.getAccessToken();
        System.err.println("执行了获取access_token值的定时器");
    }
}
