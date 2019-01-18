package com.example.myproject3.config;

import org.springframework.boot.autoconfigure.session.RedisSessionProperties;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;


@Configuration
@EnableCaching
public class CachingConfigurerSupport {
    @Bean
    public KeyGenerator keyGenerator(){
        return new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... params) {
                StringBuffer buffer = new StringBuffer();
                buffer.append(target.getClass().getName());
                buffer.append(method.getName());
                for (Object obj :
                        params) {
                    buffer.append(obj.toString());
                }
                return buffer.toString();
            }
        };
    }

//    @Bean
//    public CacheManager cacheManager(){
//        new ca
//        return cacheManager;
//    }

//    public rediste
}
