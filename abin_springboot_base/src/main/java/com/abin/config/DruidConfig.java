package com.abin.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {

    @Primary
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druidDataSource(){
        return new DruidDataSource();
    }

    // druid后台监控
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean<StatViewServlet> registrationBean = new ServletRegistrationBean<>(new StatViewServlet(),"/druid/*");

        Map<String, String> initParameters = new HashMap<>();

        // 设置登录信息
        initParameters.put("loginUsername","admin");
        initParameters.put("loginPassword","123456");

        // 允许谁访问
        initParameters.put("allow","");
        registrationBean.setInitParameters(initParameters);
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean<WebStatFilter> bean = new FilterRegistrationBean<>(new WebStatFilter());

        Map<String, String> initParameters = new HashMap<>();
        initParameters.put("exclusions","/static/*,*.js,*.jpg,*.png,*.ico,*.css,/druid/*");
        bean.setInitParameters(initParameters);
        bean.addUrlPatterns("/*");
        return bean;
    }

}
