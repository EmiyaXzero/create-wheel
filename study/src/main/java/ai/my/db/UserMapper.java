package ai.my.db;

import ai.my.restful.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author shanghang
 * @title: UserMapper
 * @projectName create-wheel
 * @description: mapper类
 * @date 2020/8/23-17:28
 */
@Mapper
@Component
public interface UserMapper extends BaseMapper<User> {
}
