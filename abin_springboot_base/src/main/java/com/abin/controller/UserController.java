package com.abin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/login")
    public String userLogin(HttpServletRequest request, HttpServletResponse response, Model model){
        String password = request.getParameter("password");
        if("123456".equals(password)){
            String cookie = request.getParameter("cookie");
            if ("check".equals(cookie)){
                HttpSession session = request.getSession();
                session.setAttribute("username",request.getParameter("username"));
            }
            return "index";
        }else {
            model.addAttribute("msg","密码错误！");
            return "login";
        }

    }
}
