package com.abin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Controller
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("jia");
    }

    @Bean
    public Docket docket1(Environment environment){

        // 判断是不是dev环境或者test环境
        Profiles profiles = Profiles.of("dev","test");//设定环境信息
        boolean flag = environment.acceptsProfiles(profiles);//监听是否指定环境

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("abin")// 组名
                .apiInfo(getApiInfo())
                .enable(flag)// dev或test环境才swagger
                .select()
                /**
                 * RequestHandlerSelectors:配置要扫描的接口的方式
                     * basePackage：指定要扫描的包
                     * any()：扫描全部
                     * none(): 不扫描
                     * withClassAnnotation: 扫描类上的注解，参数是一个注解的反射对象
                     * withMethodAnnotation：扫描方法上的注解
                 */
                .apis(RequestHandlerSelectors.basePackage("com.abin.controller"))
                /**
                 * 过滤请求
                 */
//                .paths(PathSelectors.ant("/user/**"))
                .build();
    }

    private ApiInfo getApiInfo(){
        return new ApiInfo("Abin`s API Document",
                "好好学习，天天向上",
                "1.0",
                "http://www.baidu.com",
                new Contact("abin", "", "www.1171513902@qq.com"),
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }
}
