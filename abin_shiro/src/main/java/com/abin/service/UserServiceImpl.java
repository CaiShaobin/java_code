package com.abin.service;

import com.abin.dao.UserDao;
import com.abin.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserDao userDao;

    @Override
    public User getUserById(int id) {
        User user = userDao.getUserById(id);
        return user;
    }

    @Override
    public List<User> getUser() {
        List<User> userList = userDao.getUser();
        return userList;
    }
}
