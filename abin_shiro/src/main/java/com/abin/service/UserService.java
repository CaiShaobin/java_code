package com.abin.service;

import com.abin.pojo.User;

import java.util.List;

public interface UserService {

    User getUserById(int id);

    List<User> getUser();
}
