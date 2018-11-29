package com.zzx.springboot_redise.server;

import com.zzx.springboot_redise.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by Mr.John on 2018/9/26 10:03.
 **/

@Service
public class UserServer {

    @Autowired
    UserDao userDao;

    //不能插入重复key
    @CachePut(value = "redisT")
    public String setUser(String k, String v) {
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
}

