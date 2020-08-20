package ai.my.restful.controller;

import ai.my.redis.RedisDemo;
import ai.my.restful.pojo.ResponsePojo;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;


/**
 * @Author: shanghang
 * @Project:create-wheel
 * @description:JsonRestFul demo
 * @Date: 2020/7/26 20:48
 **/
//@RestController
//@RequestMapping("/restful")
public class JsonRestful {
   // @RequestMapping("/jsonRequest")
    public ResponsePojo getJson(){
        ResponsePojo responsePojo = new ResponsePojo();
        responsePojo.setId(1L);
        responsePojo.setName("test");
        return responsePojo;
    }

    //@RequestMapping("/redisGet")
    public ResponsePojo getRedis(){
        new RedisDemo().doGetRedis();
        ResponsePojo responsePojo = new ResponsePojo();
        return responsePojo;
    }

}
