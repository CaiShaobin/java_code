package com.abin;

import com.abin.dao.DepDao;
import com.abin.dao.EmpDao;
import com.abin.pojo.Employee;
import com.abin.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class AbinSpringbootBaseApplicationTests {

    @Autowired
    EmpDao empDao;

    @Autowired
    DepDao depDao;

    @Test
    void contextLoads() {

        List<Employee> empList =  empDao.getEmpList();
        System.out.println(empList);
    }

}
