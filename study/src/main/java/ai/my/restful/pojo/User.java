package ai.my.restful.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @author shanghang
 * @title: User
 * @projectName create-wheel
 * @description: 用户类
 * @date 2020/8/23-17:28
 */
@Data
public class User {
    private int id;
    private String nickName;
    private int age;
    private String createTime;
}
