package ai.my.controller;

//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: shanghang
 * @Project:create-wheel
 * @description:制造一个异常
 * @Date: 2020/7/26 21:50
 **/
//@RestController
public class ExceptionController {
//    @RequestMapping("/exception")
    public void doException(){
        int i = 1/0;
    }
}
