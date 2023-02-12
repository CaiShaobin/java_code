package com.abin.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShiroQuickStart {

    private static final transient Logger logger = LoggerFactory.getLogger(ShiroQuickStart.class);

    public static void main(String[] args) {

        String username = "abin";
        String password = "123456";
        Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        session.setAttribute("username","abin");
        session.getAttribute("username");
        if (!currentUser.isAuthenticated()) {
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            token.setRememberMe(true);
            try {
                currentUser.login(token);
            }
            catch (UnknownAccountException e){// 用户未注册
                logger.info("no user with username of " + token.getPrincipal());
            }
            catch (IncorrectCredentialsException e){ // 密码错误
                logger.info("password for account " + token.getPrincipal() + " was incorrect");
            }
            catch (LockedAccountException e){ // 用户锁定
                logger.info("the account for username " + token.getPrincipal() + " is lock" +
                        " Please contact your admin to unlock it");
            }
            catch (AuthenticationException e) {// 认证失败
                e.printStackTrace();
            }
        }
        if (currentUser.hasRole("admin")) {
            logger.info("you are admin");
        }else {
            logger.info("Just a visitor");
        }
        if (currentUser.isPermitted("user:add")) {
            logger.info("May user add");// 任何人都需要拥有user的add权限
        }else {
            logger.info("401");
        }

        if (currentUser.isPermitted("abin:user:add")) {
            logger.info("May user add");// abin需要拥有user的add权限
        }else {
            logger.info("401");
        }
        currentUser.logout();
        System.exit(0);
    }
}
