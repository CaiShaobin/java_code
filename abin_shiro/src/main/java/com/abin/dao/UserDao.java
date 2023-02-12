package com.abin.dao;

import com.abin.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserDao {

    User getUserById(int id);

    List<User> getUser();

}
