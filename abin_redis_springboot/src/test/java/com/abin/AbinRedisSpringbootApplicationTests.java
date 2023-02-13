package com.abin;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class AbinRedisSpringbootApplicationTests {

    @Autowired
    RedisTemplate redisTemplate;

    @Test
    void contextLoads() {

        redisTemplate.opsForValue().set("abin","a good man！");


        String s = ((String) redisTemplate.opsForValue().get("abin"));

        System.out.println(s);

    }

}
