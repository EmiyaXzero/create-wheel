package ai.my.controller;

import ai.my.controller.pojo.Author;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import sun.misc.Request;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: shanghang
 * @Project:create-wheel
 * @description:视图demo
 * @Date: 2020/8/22 21:37
 **/
@Controller
public class GetController {
    @GetMapping("/getAuthor")
    public String getAuthor(HttpServletRequest request){
        Map<String,Object> map = new HashMap<>();
        Author author = new Author();
        author.setName("test");
        author.setId(1);
        author.setCreateTime(new Date());
        map.put("author",author);
        request.setAttribute("authorData",map);
        return "hello";
    }
}
