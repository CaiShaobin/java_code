package com.abin.dao;


import com.abin.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    @SuppressWarnings("all")
    User queryUser();
}
