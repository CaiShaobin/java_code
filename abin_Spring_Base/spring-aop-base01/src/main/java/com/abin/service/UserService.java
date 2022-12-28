package com.abin.service;

import com.abin.pojo.User;

public interface UserService {
    void add();
    void delete();
    void update();
    User query();
}
