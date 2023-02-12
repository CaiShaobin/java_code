package com.abin.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.DialectConfiguration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    private static final transient Logger logger = LoggerFactory.getLogger(ShiroConfig.class);

    /**
     * filter
     * securityManger
     * Realm
     */

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("shrioSecurityManager") DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        /**
         * 添加shiro的内置过滤器
         *      anon：无需认证就可以访问
         *      authc：必须认证才能访问
         *      user： 必须拥有 记住我 功能才能访问
         *      perms[...]：拥有对某个资源的权限才能访问
         *      role： 拥有某个角色权限才能访问
         */
        Map<String, String> filterChainDefinitionMap = new HashMap<>();
        // 认证filter
//        filterChainDefinitionMap.put("/user/add","anon");
//        filterChainDefinitionMap.put("/user/update","authc");
        filterChainDefinitionMap.put("user/*","authc");
        // 授权filter
        filterChainDefinitionMap.put("/user/update","perms[user:update]");
        filterChainDefinitionMap.put("/user/add","perms[user:add]");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);

        // 设置登录请求
        shiroFilterFactoryBean.setLoginUrl("/toLogin");
        // 设置未授权请求
        shiroFilterFactoryBean.setUnauthorizedUrl("/noauth");
        return shiroFilterFactoryBean;
    }

    @Bean(name="shrioSecurityManager")
    public DefaultWebSecurityManager defaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);

        return securityManager;
    }

    @Bean
    public UserRealm userRealm(){
        return new UserRealm();
    }

    @Bean
    public ShiroDialect getSecurityDialect(){
        return new ShiroDialect();
    }

}
