package ai.my.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author shanghang
 * @title: HelloController
 * @projectName create-wheel
 * @description: 控制器
 * @date 2020/7/25-17:52
 */
@RestController
@Slf4j
public class HelloController {
    @RequestMapping("/hello")
    public String hello(Model model){
        Map<String, Object> map =  model.asMap();
        log.error(map.toString());
        return "hello";
    }
}
