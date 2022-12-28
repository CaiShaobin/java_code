package com.abin.demo3;

import com.abin.demo2.UserService;
import com.abin.demo2.UserServiceImpl;

public class Client {
    public static void main(String[] args) {

        UserServiceImpl userService = new UserServiceImpl();
        ProxyInvocationHandler pih = new ProxyInvocationHandler();
        pih.setTarget(userService);
        UserService proxy = (UserService) pih.getProxy();

        proxy.add();
        proxy.delete();
        proxy.update();
        proxy.query();
    }
}
