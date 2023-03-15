package com.abin.dao;

import com.abin.config.SharedDataSource;
import com.abin.pojo.User;
import org.mybatis.spring.SqlSessionTemplate;

public class UserMapperImpl implements UserMapper{

    private SqlSessionTemplate sqlSession;

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    @SharedDataSource
    public User queryUser(Long id) {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.queryUser(id);
        return user;
    }
}
