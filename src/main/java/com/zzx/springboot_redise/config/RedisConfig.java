/*
package com.zzx.springboot_redise.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

*/
/**
 * Created by Mr.John on 2018/9/23 10:14.
 **//*



@Configuration
public class RedisConfig {
    @Bean
    public RedisConnectionFactory redisCF(){
        //如果什么参数都不设置，默认连接本地6379端口
        JedisConnectionFactory factory = new JedisConnectionFactory();
        factory.setPort(6379);
        factory.setHostName("localhost");
        return factory;
    }
}
*/
