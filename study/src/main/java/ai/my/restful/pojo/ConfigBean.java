package ai.my.restful.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author shanghang
 * @title: ConfigBean
 * @projectName create-wheel
 * @description: 配置bean
 * @date 2020/8/19-19:58
 */
@ConfigurationProperties(prefix = "spring.testconfig")
@Component
public class ConfigBean {
    private String name;
    private String value;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
