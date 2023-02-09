package com.abin.dao;

import com.abin.pojo.Department;
import com.abin.pojo.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Repository
public class EmpDao {

    public List<Employee> getEmpList(){

        ArrayList<Employee> employees = new ArrayList<>();
        Department department = new Department(1,"金融科技部");
        Employee abin = new Employee(10001, "abin", "1111111@163.com", 1, department, new Date("1996/12/01"));
        Employee jia = new Employee(10002, "jia", "1111111@163.com", 0, department, new Date("1996/12/01"));
        Employee xbx = new Employee(10003, "xbx", "1111111@163.com", 0, department, new Date("1996/12/01"));

        employees.add(abin);
        employees.add(jia);
        employees.add(xbx);

        return  employees;
    };
}
