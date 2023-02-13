package com.abin.schedule.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService{

    @Scheduled(cron = "0 25 16 13 2 ?")
    @Override
    public void sayHello() throws InterruptedException {
        System.out.println("Asyn...");
        Thread.sleep(10);
        asynExcuter();
    }

    @Async
    void asynExcuter(){
        for (int i = 0; i < 10; i++) {

            System.out.println("Hello...执行了");
        }
    }
}
