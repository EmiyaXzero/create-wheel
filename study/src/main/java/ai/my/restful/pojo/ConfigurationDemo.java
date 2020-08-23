package ai.my.restful.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: shanghang
 * @Project:create-wheel
 * @description:配置注入
 * @Date: 2020/8/23 22:54
 **/
@Component
@ConfigurationProperties(prefix = "myproperties")
@Data
public class ConfigurationDemo {
    private String demoName;
    private int demoAge;

    @Override
    public String toString() {
        return "ConfigurationDemo{" +
                "demoName='" + demoName + '\'' +
                ", demoAge=" + demoAge +
                '}';
    }
}
