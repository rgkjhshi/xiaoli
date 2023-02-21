package com.mk.xiaoli.service;

import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author shisong
 * @since 2023-02-21
 */
@SpringBootApplication(scanBasePackages = {"com.mk.xiaoli.common", "com.mk.xiaoli.service"},
        exclude = {DataSourceAutoConfiguration.class, MybatisAutoConfiguration.class})
@ImportResource({"classpath:spring/root.xml"})
public class BootApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(BootApplication.class);
        application.run(args);
    }
}