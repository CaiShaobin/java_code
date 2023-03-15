package com.abin.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class DataSourceAop{

    @Around("@annotation(SharedDataSource)")
    public Object changeDataSource(ProceedingJoinPoint joinPoint) throws Throwable {

        Object[] args = joinPoint.getArgs();
        Long userId = null;
        for (Object arg : args) {
            if (arg instanceof Long) {
                userId = (Long) arg;
                break;
            }
        }

        System.out.println("当前方法参数为：" + userId);
        // 选择数据源
        if (userId != null) {
            if (userId % 2 == 0) {
                DatasourceType.setDataBaseType(DatasourceType.DataBaseType.Master);
            } else {
                DatasourceType.setDataBaseType(DatasourceType.DataBaseType.Slave);

            }
        } else {
            DatasourceType.setDataBaseType(DatasourceType.DataBaseType.Master);
        }
        System.out.println("选择数据源为：" + DatasourceType.getDataBaseType());
        System.out.println("changeDataSource...");
        Object proceed = joinPoint.proceed();

        return proceed;

    }
}
