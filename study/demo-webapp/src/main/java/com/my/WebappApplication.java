package com.my;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @Author: shanghang
 * @Project:create-wheel
 * @description:TODO
 * @Date: 2020/9/15 23:42
 **/
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, RedisAutoConfiguration.class})
public class WebappApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebappApplication.class,args);
    }
}
