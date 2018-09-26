package com.zzx.springboot_redise.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by Mr.John on 2018/9/26 9:56.
 **/
@Component
public class UserDao {
    @Autowired
    RedisTemplate<Object, Object> template;
    public String setUser(String k,String v) {
        template.opsForValue().set(k, v);
        String val= (String) template.opsForValue().get(k);
        if(val.equals(v)){
            return val;
        }
        return "失败";
    }

    public String getUser(String k){
        String aa= (String) template.opsForValue().get(k);
        if(aa!=null){
            return aa;
        }
        return "失败";
    }

}
