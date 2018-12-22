package com.zzx.springboot_redise.dao;

import com.zzx.springboot_redise.entity.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.SerializationUtils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by Mr.John on 2018/9/26 9:56.
 **/
@Component
@Slf4j
public class UserDao {
    @Autowired
    RedisTemplate<Object, Object> template;

    public String setUser(String k,String v) throws IOException {
        if(template.opsForValue().get(k)==null){
            template.opsForValue().set(k, v);

            String val= (String) template.opsForValue().get(k);
            if(val.equals(v)){
                UserEntity userEntity=new UserEntity();
                userEntity.setName(k);
                userEntity.setPassword(v);
                FileOutputStream fileOutputStream=new FileOutputStream("E:\\MyProjects\\springboot_redise\\src\\main\\resources\\templates\\test.txt");
                ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(SerializationUtils.serialize(k));
                objectOutputStream.writeObject(SerializationUtils.serialize(v));
                objectOutputStream.flush();
                objectOutputStream.close();
                return val;
            }
            return "失败";
        }
        return "失败！key已经存在！";
    }

    public String getUser(String k){
        log.info("从数据库获取数据");
        String aa= (String) template.opsForValue().get(k);
        if(aa!=null){
            return aa;
        }
        return "失败";
    }

    public void del(String key){

        template.delete(key);
    }


}
