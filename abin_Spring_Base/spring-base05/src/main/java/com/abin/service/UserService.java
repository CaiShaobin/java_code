package com.abin.service;

import com.abin.dao.UserMapper;
import com.abin.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    public User queryUser(){
        User user = new User();
        return user;
    }
}
