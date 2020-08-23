package ai.my.restful.controller;

import ai.my.restful.pojo.ConfigurationDemo;
import ai.my.restful.pojo.MyselfYmlDemo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: shanghang
 * @Project:create-wheel
 * @description:自动配置Restful
 * @Date: 2020/8/23 22:58
 **/
@RestController
@RequestMapping("properties")
@Slf4j
public class PropertiesRestful {

    /**
     * 不建议字段注入，修改为构造器自动注入
     */
    //@Autowired
    private ConfigurationDemo configurationDemo;
    private MyselfYmlDemo myselfYmlDemo;
    public PropertiesRestful(){

    }

    @Autowired
    public PropertiesRestful(ConfigurationDemo configurationDemo,MyselfYmlDemo myselfYmlDemo){
        this.configurationDemo = configurationDemo;
        this.myselfYmlDemo = myselfYmlDemo;
    }

    @GetMapping("/getConfig")
    public String doGet(){
        log.error("request is coming");
        return configurationDemo.toString();
    }

    @GetMapping("/getMyself")
    public String doGetMyself(){
        log.error("request is coming");
        return myselfYmlDemo.toString();
    }
}
