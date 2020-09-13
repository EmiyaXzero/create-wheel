package api.interfaces;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @Author: shanghang
 * @Project:create-wheel
 * @description: 默认实现
 * @Date: 2020/9/13 23:34
 **/
@Service
@Component
public class DefaultApiService implements ApiService{
    @Override
    public String say(String name) throws Exception {
        Thread.sleep(2000);
        return "hello "+name;
    }
}
