package com.abin.controller;

import com.abin.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class HelloController {

    @RequestMapping("hello")
    public String hello(){
        return "Hello Swagger";
    }
    @RequestMapping("getuser")
    public User user(){
        return new User();
    }
}
