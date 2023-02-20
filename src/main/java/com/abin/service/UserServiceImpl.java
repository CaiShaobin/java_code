package com.abin.service;


import com.abin.spring.config.*;

@Component("userService")
//@Scope("property")
public class UserServiceImpl implements UserService, BeanNameAware, InitializingBean {

    @Autowired
    private OrderService orderService;

    private String beanName;

    private String helloPostProcess;

    public void setHelloPostProcess(String helloPostProcess) {
        this.helloPostProcess = helloPostProcess;
    }

    public void test(){
        System.out.println(orderService);
        System.out.println(beanName);
        System.out.println(helloPostProcess);
    }

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("初始化来咯...");
    }
}
