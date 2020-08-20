package ai.my;

import ai.my.restful.controller.JsonRestful;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * @Author: shanghang
 * @Project:create-wheel
 * @description:单元测试类
 * @Date: 2020/8/20 23:23
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootTests {
    public MockMvc mvc;

    @Before
    public void init(){
        mvc = MockMvcBuilders.standaloneSetup(new JsonRestful()).build();
    }

    @Test
    public void doTest() throws Exception {
        RequestBuilder request = null;
        request = MockMvcRequestBuilders.get("/restful/jsonRequest").contentType(MediaType.APPLICATION_JSON);
        mvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }
}
