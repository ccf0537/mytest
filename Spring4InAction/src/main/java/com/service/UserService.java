package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author : chencf-a
 * @date : 2020/11/24 16:14
 */
@Component
public class UserService {
    @Autowired
    private RedisTemplate redisTemplate;
    public void getUserList(){
        ListOperations listOperations = redisTemplate.opsForList();//redis操作列表
        //在列表users左边添加元素
        listOperations.leftPush("users","tom");
        listOperations.leftPush("users","cat");
        System.out.println(listOperations.range("users",0,1));
        //从启用缓存的方法的同一个类内的方法中调用缓存方法不会触发缓存，会直接调用方法执行
        getUserName("11111");
        ValueOperations valueOperations = redisTemplate.opsForValue();
        System.out.println("redis:"+valueOperations.get("11111"));

    }

    @Cacheable(value = "userNameCache")
    public String getUserName(String Id){
        System.out.println("query user from db...");
        return "polly";
    }

    @CacheEvict(value = "userNameCache")
    public void remove(String Id) {
        System.out.println("remove user from db...");
    }
}
