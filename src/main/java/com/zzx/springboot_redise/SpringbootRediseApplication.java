package com.zzx.springboot_redise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

//@EnableAutoConfiguration(exclude = {RedisAutoConfiguration.class})
@SpringBootApplication
@EnableCaching
public class SpringbootRediseApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRediseApplication.class, args);
	}
}
