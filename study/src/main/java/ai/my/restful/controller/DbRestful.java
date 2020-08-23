package ai.my.restful.controller;

import ai.my.db.UserMapper;
import ai.my.restful.pojo.User;
import ai.my.util.SpringUtil;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.*;
import sun.plugin2.message.Message;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author shanghang
 * @title: DbRestful
 * @projectName create-wheel
 * @description: 数据库测试
 * @date 2020/8/23-17:34
 */
@RestController
public class DbRestful {
    @GetMapping("/dbrest/insertUser")
    public void add(){
        UserMapper mapper = SpringUtil.getBean(UserMapper.class);
        User user = new User();
        user.setId(1);
        user.setAge(23);
        user.setNickName("张三");
        user.setCreateTime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        mapper.insert(user);
    }
    @PostMapping("/dbrest/getUser")
    public User get(@RequestBody String requestJson){
        JSONObject jsonObject = JSONObject.parseObject(requestJson);
        int id = (int) jsonObject.get("id");
        UserMapper mapper = SpringUtil.getBean(UserMapper.class);
        return mapper.selectById(id);
    }


}
