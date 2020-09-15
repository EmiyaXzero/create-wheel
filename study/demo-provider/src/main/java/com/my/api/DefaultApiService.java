package com.my.api;

import com.alibaba.dubbo.config.annotation.Service;
import com.my.api.ApiService;
import org.springframework.stereotype.Component;

/**
 * @Author: shanghang
 * @Project:create-wheel
 * @description: 默认实现
 * @Date: 2020/9/13 23:34
 **/
@Service
@Component
public class DefaultApiService implements ApiService {
    @Override
    public String say(String name) throws Exception {
        Thread.sleep(2000);
        return "hello "+name;
    }
}
