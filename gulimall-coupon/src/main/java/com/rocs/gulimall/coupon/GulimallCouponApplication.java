package com.rocs.gulimall.coupon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 1、Nacos配置中心的统一管理配置
 * 1）引入依赖
 * 2）创建一个bootstrap.properties
 *      为其配置 spring.application.name=gulimall-coupon
 *              spring.cloud.nacos.config.server-addr=127.0.0.1:8848
 * 3）需要给配置中心加入默认的 数据集（data id）{应用名}.properties
 * 4) 给数据集添加任何配置
 * 5）开启动态获取刷新配置（@RefreshScope） *优先使用/配置中心/的配置 @Value("${。。name。。}") 获取配置内容
 */
@SpringBootApplication
@EnableDiscoveryClient
//@EnableFeignClients
public class GulimallCouponApplication {

    public static void main(String[] args) {
        SpringApplication.run(GulimallCouponApplication.class, args);
    }

}
