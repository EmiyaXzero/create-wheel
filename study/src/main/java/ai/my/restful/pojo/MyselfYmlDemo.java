package ai.my.restful.pojo;

import ai.my.util.YamlPropertySourceFactory;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @Author: shanghang
 * @Project:create-wheel
 * @description:配置注入
 * @Date: 2020/8/23 22:54
 **/
@Component
@PropertySource(value = {"classpath:demo.yml"},encoding = "UTF-8",factory = YamlPropertySourceFactory.class)
@ConfigurationProperties(prefix = "demo2")
@Data
public class MyselfYmlDemo {
    private String name;
    private String desc;
    private String[] lists;

    @Override
    public String toString() {
        return "MyselfYmlDemo{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", lists=" + Arrays.toString(lists) +
                '}';
    }
}
