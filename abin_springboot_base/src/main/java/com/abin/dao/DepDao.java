package com.abin.dao;

import com.abin.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DepDao {

    public static ArrayList<Department> depList;

    static {
        depList = new ArrayList<>();
        depList.add(new Department(1,"市场部"));
        depList.add(new Department(2,"设计部"));
        depList.add(new Department(3,"采购部"));
        depList.add(new Department(4,"科技部"));
    }

    public List<Department> getDepList(){

        return depList;
    }

    public Department getDepById(int id){
        Department department = depList.stream().filter(t -> t.getDepId().equals(id)).findFirst().get();
        return department;
    }
}
