package ai.my.util;


import ai.my.SpringBootStartApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author shanghang
 * @title: SpringUtil
 * @projectName create-wheel
 * @description: Spring工具类
 * @date 2020/8/19-10:46
 */
public class SpringUtil {
    private static ApplicationContext context;

    public static void setApplicationContext(ApplicationContext applicationContext){
        context = applicationContext;
    }

    public static ApplicationContext getApplicationContext(){return context;}

    public static<T> T getBean(Class<T> clazz){return getApplicationContext().getBean(clazz);}

    public static Object getBean(String name){return context.getBean(name);}
}
