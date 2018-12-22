package com.zzx.springboot_redise.dao;

import com.zzx.springboot_redise.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Mr.John on 2018/12/22 15:57.
 **/
@Mapper
public interface UserMapper {
    @Select("SELECT * FROM user")
    List<UserEntity>  all();
}
