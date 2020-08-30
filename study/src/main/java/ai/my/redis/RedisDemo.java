package ai.my.redis;

import ai.my.util.SpringUtil;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.connection.stream.ByteRecord;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;


/**
 * @author shanghang
 * @title: RedisUtil
 * @projectName create-wheel
 * @description: RedisDemo
 * @date 2020/8/19-10:40
 */
public class RedisDemo {
    private StringRedisTemplate stringRedisTemplate ;

    private RedisTemplate redisTemplate;

    private StringRedisTemplate getInstance(){
        if(this.stringRedisTemplate == null){
            this.stringRedisTemplate = SpringUtil.getBean(StringRedisTemplate.class);
        }
        return this.stringRedisTemplate;
    }

    private RedisTemplate getRedisTemplateInstance(){
        if(this.redisTemplate == null){
            this.redisTemplate = (RedisTemplate) SpringUtil.getBean("redisTemplate");
        }
        return this.redisTemplate;
    }


    public void doGetRedis(){
        Object o = this.getInstance().opsForValue().get("");
        o.getClass();
    }
}
