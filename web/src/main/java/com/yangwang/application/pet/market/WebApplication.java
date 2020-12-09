package com.yangwang.application.pet.market;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @param
 * @author LiuXiangLin
 * @description 项目启动主类
 * @date 9:54 2019/10/16
 * @return
 **/
@EnableAsync
@EnableCaching
@EnableSwagger2
@SpringBootApplication(scanBasePackages = {"com.yangwang.application.pet.market", "com.yangwang.sysframework"})
@MapperScan("com.yangwang.application.pet.market.dao")
@EnableTransactionManagement
public class WebApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
        System.err.println("启动成功！");
    }
}
