package ai.my;

import ai.my.util.SpringUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

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
        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(SpringBootStartApplication.class,args);
        SpringUtil.setApplicationContext(configurableApplicationContext);
    }

}
