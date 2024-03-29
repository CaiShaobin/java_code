package com.abin.aop;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

public class ServiceAfterReturningAdvice implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("执行了" + method.getName() + "方法，返回结果为：" + o);
    }
}
