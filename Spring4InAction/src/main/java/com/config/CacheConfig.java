package com.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @author : chencf-a
 *      1.在任一config类里使用@EnableCaching注解启用注解驱动的缓存
 *      2.声明缓存管理器，spring内置了很多缓存管理器
 *      3.在需要使用缓存的方法上添加@Cacheable和@CacheEvict
 * @date : 2020/11/25 10:14
 */
@Configuration
@EnableCaching
public class CacheConfig {
    /**
     * 声明缓存管理器，spring提供了如下的缓存管理器，以CaheMange接口类型返回其中一个即可
     *  SimpleCacheManager
     *  NoOpCacheManager
     *  ConcurrentMapCacheManager
     *  CompositeCacheManager
     *  EhCacheCacheManager
     *  RedisCacheManager
     *  GemfireCacheManager
     * @return  CacheManager spring缓存管理器接口
     */
    @Bean
    public CacheManager cacheManager(RedisTemplate redisTemplate){
        return new RedisCacheManager(redisTemplate);
    }

    /**
     * Redis连接工厂bean
     * @return
     */
    @Bean
    public RedisConnectionFactory redisConnectionFactory(){
        JedisConnectionFactory jcf = new JedisConnectionFactory();
        jcf.setHostName("127.0.0.1");
        jcf.setPort(6379);
//        jcf.setPassword("123456");
        return jcf;
    }

    /**
     * RedisTemplate bean
     * @return
     */
    @Bean
    public StringRedisTemplate redisTemplate(){
        RedisConnectionFactory rcf = redisConnectionFactory();
        StringRedisTemplate redisTemplate = new StringRedisTemplate();
        redisTemplate.setConnectionFactory(rcf);
        return redisTemplate;
    }

}
