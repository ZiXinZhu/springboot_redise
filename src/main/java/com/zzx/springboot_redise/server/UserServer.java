package com.zzx.springboot_redise.server;

import com.zzx.springboot_redise.dao.UserDao;
import com.zzx.springboot_redise.dao.UserMapper;
import com.zzx.springboot_redise.entity.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * Created by Mr.John on 2018/9/26 10:03.
 **/
@Slf4j
@Service
public class UserServer {

    @Autowired
    UserDao userDao;
    @Autowired
    UserMapper user;

    //不能插入重复key
    @CachePut(value = "redisT")
    public String setUser(String k, String v) throws IOException {
      return userDao.setUser(k, v);
    }

    @Cacheable(value = "redisT")
    public String getUser(String k){
        return userDao.getUser(k);
    }

    //清空缓存
    @CacheEvict(value = "redisT",allEntries = true)
    public void del(String k){
        userDao.del(k);
    }

    //@CacheEvict(value = "redisT",allEntries = true)
    @Cacheable(value = "redisT")
    public List<UserEntity> all(){
        log.info("从数据库获取数据！");
       return user.all();
    }
}

