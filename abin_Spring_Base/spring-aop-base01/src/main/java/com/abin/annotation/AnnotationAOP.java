package com.abin.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class AnnotationAOP {

    @Before("execution(* com.abin.service.UserService.*(..))")
    public void before(){
        System.out.println("==========annotation.beforeAdvice==========");
    }

    @After("execution(* com.abin.service.UserService.*(..))")
    public void after(){
        System.out.println("==========annotation.afterAdvice==========");
    }

    @Around("execution(* com.abin.service.UserService.*(..))")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("==========annotation.aroundBeforeAdvice==========");
        joinPoint.proceed();
        System.out.println("==========annotation.aroundAfterAdvice==========");
    }

    @After("execution(* com.abin.service.UserService.*(..))")
    public void returnAdvice(){
        System.out.println("==========annotation.returnAdvice==========");
    }

    @AfterReturning("execution(* com.abin.service.UserService.*(..))")
    public void afterReturnAdvice(){
        System.out.println("==========annotation.afterReturnAdvice==========");
    }

    @AfterThrowing("execution(* com.abin.service.UserService.*(..))")
    public void afterThrowingAdvice(){
        System.out.println("==========annotation.afterThrowingAdvice==========");
    }
}
