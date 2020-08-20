package ai.my.redis;

import ai.my.util.SpringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;


/**
 * @author shanghang
 * @title: RedisUtil
 * @projectName create-wheel
 * @description: RedisDemo
 * @date 2020/8/19-10:40
 */
public class RedisDemo {
    @Autowired
    private StringRedisTemplate stringRedisTemplate ;

    private StringRedisTemplate getInstance(){
        if(this.stringRedisTemplate == null){
            this.stringRedisTemplate = SpringUtil.getBean(StringRedisTemplate.class);
        }
        return this.stringRedisTemplate;
    }


    public void doGetRedis(){
        Object o = this.getInstance().opsForValue().get("BILLZD:com.ai.appframe2.complex.cache.impl.TableSplitCacheImpl:20200715172319");
        o.getClass();
    }
}
