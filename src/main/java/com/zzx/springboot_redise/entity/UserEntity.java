package com.zzx.springboot_redise.entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * Created by Mr.John on 2018/9/23 16:52.
 **/

@Data
@ToString
public class UserEntity implements Serializable {

    private  int id;
    private String  name;
    private String password;
    private long time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
