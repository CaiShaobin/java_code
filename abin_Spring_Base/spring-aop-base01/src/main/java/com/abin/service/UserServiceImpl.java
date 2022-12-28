package com.abin.service;

import com.abin.pojo.User;

public class UserServiceImpl implements UserService{

    @Override
    public void add() {
        System.out.println(">>>add");
    }

    @Override
    public void delete() {
        System.out.println(">>>delete");
    }

    @Override
    public void update() {
        System.out.println(">>>update");
    }

    @Override
    public User query() {
        System.out.println(">>>query");
        return new User(1,"abin","123456");
    }
}
