package com.abin.dao;

import com.abin.pojo.Department;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface DepDao {

    List<Department> getDepList();

    Department getDepById(int id);
}
