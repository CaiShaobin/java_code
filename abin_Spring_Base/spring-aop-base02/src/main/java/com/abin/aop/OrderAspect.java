package com.abin.aop;

import com.abin.annotation.LogInfo;
import com.abin.convert.OrderConvert;
import com.abin.pojo.Log;
import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


@Aspect
@Component
public class OrderAspect {
    private ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,2,1, TimeUnit.SECONDS,new LinkedBlockingQueue<>(10));

    @Pointcut("@annotation(com.abin.annotation.LogInfo)")
    public void pointcut(){}

    @Around("pointcut()")
    public boolean around(ProceedingJoinPoint pj) throws Throwable {
        Object result = pj.proceed();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                MethodSignature methodSignature = ((MethodSignature) pj.getSignature());
                LogInfo annotation = methodSignature.getMethod().getAnnotation(LogInfo.class);
                Class<? extends OrderConvert> convert = annotation.convert();
                OrderConvert orderConvert = null;
                try {
                    orderConvert = convert.newInstance();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                Log log = orderConvert.convert(pj.getArgs()[0]);
                log.setDesc(annotation.desc());
                log.setResult(result.toString());

                System.out.println("[Debug] : " + JSONObject.toJSONString(log));
            }
        };

        threadPoolExecutor.execute(runnable);

        return ((boolean) result);
    }
}
