package com.example.springboot_multi_redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootApplication
public class SpringbootMultiRedisApplication implements CommandLineRunner {
    private final StringRedisTemplate stringRedisTemplate;
    private final StringRedisTemplate stringRedisTemplate2;

    @Autowired
    public SpringbootMultiRedisApplication(StringRedisTemplate stringRedisTemplate,
                                           StringRedisTemplate stringRedisTemplate2) {
        this.stringRedisTemplate = stringRedisTemplate;
        this.stringRedisTemplate2 = stringRedisTemplate2;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMultiRedisApplication.class, args);
    }

    @Override
    public void run(String... args) {
        stringRedisTemplate.opsForValue().set("test", "1");
        stringRedisTemplate2.opsForValue().set("test", "2");
    }
}
