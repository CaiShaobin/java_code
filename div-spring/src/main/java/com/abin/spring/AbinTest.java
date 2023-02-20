package com.abin.spring;

import com.abin.service.UserService;
import com.abin.spring.config.AbinConfig;

public class AbinTest {
    public static void main(String[] args) {

        AbinApplicationContext abinApplicationContext = new AbinApplicationContext(AbinConfig.class);

        UserService userService1 = ((UserService) abinApplicationContext.getBean("userService"));

        userService1.test();

    }
}
