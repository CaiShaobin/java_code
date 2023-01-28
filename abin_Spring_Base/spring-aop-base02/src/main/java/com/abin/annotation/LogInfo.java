package com.abin.annotation;

import com.abin.convert.OrderConvert;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface LogInfo {

    String desc() default "";
    Class<? extends OrderConvert> convert();

}
