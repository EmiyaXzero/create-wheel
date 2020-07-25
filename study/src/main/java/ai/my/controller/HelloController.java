package ai.my.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.RequestWrapper;

/**
 * @author shanghang
 * @title: HelloController
 * @projectName create-wheel
 * @description: 控制器
 * @date 2020/7/25-17:52
 */
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello(){
        return "hello Spring Boot";
    }
}
