package com.abin.controller;

import com.abin.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WebController {

    private static final transient Logger logger = LoggerFactory.getLogger(WebController.class);

    @RequestMapping("user/add")
    public String addUser(){
        return "/user/add";
    }

    @RequestMapping("user/update")
    public String updateUser(){
        return "/user/update";
    }

    @RequestMapping("toLogin")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("login")
    public String login(String username, String password, Model model){
        Subject currentUser = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        try {
            currentUser.login(token);
            return "index";
        } catch (UnknownAccountException e){// 用户未注册
            model.addAttribute("msg","no user with username");
            logger.info("no user with username of " + token.getPrincipal());
            return "login";
        }
        catch (IncorrectCredentialsException e){ // 密码错误
            model.addAttribute("msg","password was incorrect");
            logger.info("password for account " + token.getPrincipal() + " was incorrect");
            return "login";
        }
        catch (LockedAccountException e){ // 用户锁定
            model.addAttribute("msg","username was lock");
            logger.info("the account for username " + token.getPrincipal() + " is lock" +
                    " Please contact your admin to unlock it");
            return "login";
        }
        catch (AuthenticationException e) {// 认证失败
            e.printStackTrace();
            return "login";
        }
    }

    @RequestMapping("/noauth")
    @ResponseBody
    public String unauthorized(){
        return "未授权！！！";
    }

    @RequestMapping("logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "index";
    }


}
