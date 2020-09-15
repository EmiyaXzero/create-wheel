package com.my.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import com.my.api.ApiService;
import lombok.extern.slf4j.Slf4j;
import org.apache.skywalking.apm.toolkit.trace.ActiveSpan;
import org.apache.skywalking.apm.toolkit.trace.TraceContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: shanghang
 * @Project:create-wheel
 * @description: 控制类
 * @Date: 2020/9/15 23:44
 **/
@RestController
@RequestMapping("/")
@Slf4j
public class HelloWorldController {
    @Reference
    private ApiService apiService;

    @GetMapping("/getApi/{word}")
    public String hello(@PathVariable("word") String word) throws Exception {
        Thread.sleep(1000);
        log.error("traceId:{}", TraceContext.traceId());
        ActiveSpan.tag("api-trace",word);
        String say = apiService.say(word);
        Thread.sleep(1000);
        return say;
    }

    @GetMapping("/err")
    public String err(){
        String traceId = TraceContext.traceId();
        log.error("traceId:{}", traceId);
        ActiveSpan.tag("error-trace",traceId);
        throw new RuntimeException("err");
    }
}
