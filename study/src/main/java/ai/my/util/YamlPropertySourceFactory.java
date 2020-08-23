package ai.my.util;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.DefaultPropertySourceFactory;
import org.springframework.core.io.support.EncodedResource;

import java.io.IOException;
import java.util.Optional;
import java.util.Properties;

/**
 * @Author: shanghang
 * @Project:create-wheel
 * @description:yml工具拓展类
 * @Date: 2020/8/23 23:49
 **/
public class YamlPropertySourceFactory extends DefaultPropertySourceFactory {
    private static final String YML = "yml";
    private static final String YAML = "yaml";


    @Override
    public PropertySource<?> createPropertySource( String name, EncodedResource resource) throws IOException {
        String sourceName = Optional.ofNullable(name).orElse(resource.getResource().getFilename());
        if(!resource.getResource().exists()){
            //配置文件不存在
            return new PropertiesPropertySource(sourceName, new Properties());
        }else if(sourceName.endsWith(YML) || sourceName.endsWith(YAML)){
            Properties properties =  loadYaml(sourceName,resource);
            return new PropertiesPropertySource(sourceName,properties);
        }else {
            return super.createPropertySource(name,resource);
        }
    }

    private Properties loadYaml(String sourceName, EncodedResource resource) {
        YamlPropertiesFactoryBean factoryBean = new YamlPropertiesFactoryBean();
        factoryBean.setResources(resource.getResource());
        factoryBean.afterPropertiesSet();
        return factoryBean.getObject();
    }
}
