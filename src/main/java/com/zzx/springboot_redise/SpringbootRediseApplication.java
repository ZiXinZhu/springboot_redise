package com.zzx.springboot_redise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.redis.cache.RedisCacheManager;

//@EnableAutoConfiguration(exclude = {RedisAutoConfiguration.class})
@SpringBootApplication
@EnableCaching
public class SpringbootRediseApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRediseApplication.class, args);
	}
}
