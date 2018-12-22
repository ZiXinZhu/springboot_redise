package com.zzx.springboot_redise.controller;

import com.zzx.springboot_redise.entity.UserEntity;
import com.zzx.springboot_redise.server.UserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**
 * Created by Mr.John on 2018/9/26 10:07.
 **/

@RestController
public class UserController {
    @Autowired
    UserServer server;

    @RequestMapping("/set")
    public String setUser(String k,String v) throws IOException {
       return server.setUser(k, v);
    }
    @RequestMapping("/get")
    public String getUser(String k){
        return server.getUser(k);
    }
    @RequestMapping("/del")
    public void del(String k){
        server.del(k);
    }

    @RequestMapping("/all")
    public List<UserEntity> all(){
       return server.all();
    }
}
