package com.redis.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.data.redis.core.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 *   
 *  Created with IDEA  
 *  @author:尚旭波  
 *  @Date:2018/2/24  
 *  @Time:15:41    
 *  
 */
@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;


    @RequestMapping("/testRedis")

    public String testRedis() {
        System.out.println("ffffff");
        //测试Redis 的String 类型
        ValueOperations ops = redisTemplate.opsForValue();


        ops.set("k1","v1");
        String k1 = (String) ops.get("k1");
        System.out.println(k1);

        //测试Redis 的List
        ListOperations<String, String> opsForList = redisTemplate.opsForList();
        opsForList.leftPushAll("k2","v1","v2","v3","v4");

        //测试Redis 的set
        SetOperations<String, String> opsForSet = redisTemplate.opsForSet();
        opsForSet.add("k3","v1","v2","v3","v4");

        //测试Redis 的hset
        HashOperations<String, Object, Object> opsForHash = redisTemplate.opsForHash();

        opsForHash.put("k4","o4","v1");
        opsForHash.put("k4","o4","v2");
        opsForHash.put("k4","o4","v3");
        opsForHash.put("k4","o4","v4");

        return "success";
    }


}
