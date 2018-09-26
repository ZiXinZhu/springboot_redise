package com.zzx.springboot_redise.test;


import com.zzx.springboot_redise.SpringbootRediseApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Mr.John on 2018/9/23 10:19.
 **/

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringbootRediseApplication.class)
public class RedisTest {

    @Autowired
    RedisConnectionFactory factory;
    @Autowired
    RedisTemplate<String,Object> template ;
    @Test
    public void testRedis(){
        //得到一个连接
        RedisConnection conn = factory.getConnection();
        conn.set("hello".getBytes(), "world".getBytes());
        System.out.println(new String(conn.get("hello".getBytes())));

        //template测试
        template.opsForValue().set("keys","values");
        System.out.println(template.opsForValue().get("keys"));

    }


}
