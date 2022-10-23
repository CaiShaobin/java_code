package com.abin.provider.impl;

import com.abin.provider.api.HelloServeice;

public class HelloServiceImpl implements HelloServeice {
    @Override
    public String sayHello(String name) {
        return "执行服务实现类：" + name;
    }
}
