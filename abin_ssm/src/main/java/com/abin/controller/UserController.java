package com.abin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/login")
    @ResponseBody
    public String userLogin(HttpServletRequest request) throws IOException {

        System.out.println("进入登录界面");
        HttpSession session = request.getSession();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if ("admin".equals(username)){
            session.setAttribute("username",username);
            return "200";
        }else {
            return "401";
        }
    }

    @RequestMapping("/loginFail")
    public String loginFail(){
        return "loginFail";
    }

    @RequestMapping("/toLogin")
    public String login(){
        return "login";
    }
}
