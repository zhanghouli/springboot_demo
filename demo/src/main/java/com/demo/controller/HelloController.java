package com.demo.controller;

import org.springframework.web.bind.annotation.*;

/**
 * 请输入一段话进行描述
 *
 * @author Holley
 * @create 2018-06-12 10:47
 **/

// @RestController = @ResponseBody + @Controller ; @ResponseBody代表返回类型为字符串形式
@RestController
//@RequestMapping("/holley")
public class HelloController {

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String index(){
        return "Hello Word !";
    }
    @RequestMapping(value = "/hello2",method = RequestMethod.POST)
    public String index2(){
        return "Hello Word2 !";
    }
    @GetMapping("/hello3")
    public String index3(){
        return "Hello Word3 !";
    }
    @PostMapping("/hello4")
    public String index4(){
        return "Hello Word4 !";
    }
}
