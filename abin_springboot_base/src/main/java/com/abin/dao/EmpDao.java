package com.abin.dao;

import com.abin.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface EmpDao {

    List<Employee> getEmpList();

    int updateEmp(Employee emp);

    int deleteEmp(int id);

    int addEmp(Employee emp);

    Employee getEmpById(int id);
}
