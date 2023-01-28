package com.abin.config;

import com.abin.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.abin")
public class AbinConfig {

    @Bean
    public User getUser(){
        return new User();
    }
}
