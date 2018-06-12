package com.demo;

import com.demo.controller.HelloController;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * 请输入一段话进行描述
 *
 * @author Holley
 * @create 2018-06-12 10:56
 **/
@RunWith(SpringJUnit4ClassRunner.class) // 引入spring对JUnit4的支持
@SpringBootTest
@WebAppConfiguration // 开启web应用配置，用于模拟sServletContext
public class HelloTest {

    /**
     * MockMvc对象：用于模拟调用Controller的接口发起请求
     */
    private MockMvc mvc;

    /**
      * @Author holley
      * @Description Junit中定义在测试用例@Test内容执行前预加载的内容，这里用来初始化对HelloController的模拟
      * @Date 2018/6/12 11:25
      * @Param
      * @return
      */
    @Before
    public void setUp() throws Exception{
        mvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();
    }

    /**
      * @Author holley
      * @Description  perform函数执行一次请求调用，accept用于执行接受的数据类型，andExpect用于判断接口返回的期望值
      *  MockMvcRequestBuilders.get("/hello"):get表示该请求为get请求
      * @Date 2018/6/12 11:25
      * @Param
      * @return
      */
    @Test
    public void hello() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().string(Matchers.equalTo("Hello Word !")));
    }
}
