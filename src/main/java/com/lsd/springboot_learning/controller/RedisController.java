package com.lsd.springboot_learning.controller;

import com.lsd.springboot_learning.base.Result;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("redis")
public class RedisController {
    // 还是构造方式注入
    @Resource
    private  RedisTemplate redisTemplate;

    @GetMapping("save")
    public Result save(String key, String value){
        redisTemplate.opsForValue().set(key,value);
        return Result.success();
    }

}
