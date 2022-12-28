package com.abin.diy;

public class DiyAdvice {

    public void before(){
        System.out.println("----------执行了前置通知----------");
    }

    public void after(){
        System.out.println("----------执行了后置通知----------");
    }
}
