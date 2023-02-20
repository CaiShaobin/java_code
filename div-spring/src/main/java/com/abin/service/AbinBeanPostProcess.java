package com.abin.service;

import com.abin.spring.config.BeanPostProcess;
import com.abin.spring.config.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Component("abinBeanPostProcess")
public class AbinBeanPostProcess implements BeanPostProcess {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {

        if(beanName.equals("userService")){
            System.out.println("初始化前...");
            ((UserServiceImpl)bean).setHelloPostProcess("Hello BeanPostProcess");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        System.out.println(beanName + ":初始化后...");
        if ("userService".equals(beanName)){
            Object proxyInstance = Proxy.newProxyInstance(AbinBeanPostProcess.class.getClassLoader(), bean.getClass().getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    System.out.println("代理逻辑...");
                    return method.invoke(bean,args);
                }
            });
            return proxyInstance;
        }
        return bean;
    }
}
