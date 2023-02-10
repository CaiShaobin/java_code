package com.abin.dao;

import com.abin.pojo.Department;
import com.abin.pojo.Employee;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class EmpDao {

    public static ArrayList<Employee> employees;

    static {
        employees = new ArrayList<>();
        Department department = new Department(1,"金融科技部");
        Employee abin = new Employee(10001, "abin", "1111111@163.com", 1, department, new Date("1996/12/01"));
        Employee jia = new Employee(10002, "jia", "1111111@163.com", 0, department, new Date("1996/12/01"));
        Employee xbx = new Employee(10003, "xbx", "1111111@163.com", 0, department, new Date("1996/12/01"));

        employees.add(abin);
        employees.add(jia);
        employees.add(xbx);
    }

    public List<Employee> getEmpList(){

        return  employees;
    }

    public int updateEmp(Employee emp){

        deleteEmp(emp.getId());
        employees.add(emp);
        return 1;
    }

    public int deleteEmp(int id){
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId() == id){
                employees.remove(i);
                break;
            }
        }
        return 1;
    }

    public int addEmp(Employee emp){

        int curMaxId = -1;
        Optional<Employee> maxEmp = employees.stream().max(Comparator.comparingInt(Employee::getId));
        if (maxEmp.isPresent()){
            Employee employee = maxEmp.get();
             curMaxId = employee.getId() + 1;
        }

        emp.setId(curMaxId);

        employees.add(emp);
        System.out.println(employees);
        return 200;
    }

    public Employee getEmpById(int id){
        Employee employee = employees.stream().filter(t -> t.getId() == id).findFirst().get();
        return employee;
    }

    private static Employee copyEmpProperty(Employee source,Employee target){
        source = target;
        return source;
    }
}
