package ai.my.controller.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @Author: shanghang
 * @Project:create-wheel
 * @description: pojo类
 * @Date: 2020/8/22 21:39
 **/
@Data
public class Author {
    private int id;
    private String name;
    private Date createTime;
}
