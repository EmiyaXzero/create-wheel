package ai.my;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author shanghang
 * @title: SpringBootStart
 * @projectName create-wheel
 * @description: springBoot启动
 * @date 2020/7/25-17:45
 * @SpringBootApplication注解申明让spring boot自动给程序进行必要的配置，等价于以默认属性使用@configuration @EnableAutoConfiguration
 * 和@ComponentScan
 */

@SpringBootApplication
public class SpringBootStartApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootStartApplication.class,args);
    }
}
