package com.yzd.admin.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by zd.yao on 2017/6/9.
 */
@SpringBootApplication
//如果发现missing.properties不存在，则抛出异常，也可以使用ignoreResourceNotFound=true去忽略
//@PropertySource(value = "classpath:server.properties",ignoreResourceNotFound = true)
@PropertySource(value = "classpath:server.properties")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

