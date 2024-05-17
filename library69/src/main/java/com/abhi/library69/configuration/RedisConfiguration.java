package com.abhi.library69.configuration;

import com.abhi.library69.domain.Book;
import com.fasterxml.jackson.databind.ser.SerializerFactory;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.beans.Customizer;

@Configuration
public class RedisConfiguration {

    /**
     *
     * Caching -> Redis
     *
     *
     * 1. Dependency
     * 2. Driver for Redis (inbuilt in the dependency)
     *  a. Lettuce
     *  b. Jedis
     *
     * Where is our redis? -> a. download and use in local
     *                        b. start using the redis cloud
     *
     * 3. Create a connection bean
     * 4. create a template to access the data
     *
     *
     * */


    @Bean
    public LettuceConnectionFactory getLettuceConnectionFactory(){

        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration("redis-14653.c52.us-east-1-4.ec2.redns.redis-cloud.com",14653);
        redisStandaloneConfiguration.setPassword("PLrc9ERRuHa5q9Nb56iWlp0nJp55rDu9");
        LettuceConnectionFactory lettuceConnectionFactory = new LettuceConnectionFactory(redisStandaloneConfiguration);
        return lettuceConnectionFactory;

    }

    @Bean
    public RedisTemplate<String,Object> getRedisTemplate(){

        RedisTemplate<String,Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(getLettuceConnectionFactory());
        redisTemplate.setKeySerializer(new StringRedisSerializer() );
//        redisTemplate.setValueSerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(new Jackson2JsonRedisSerializer<Object>(Object.class));
        return redisTemplate;
    }







}
