package com.abin.controller;

import com.abin.dao.EmpDao;
import com.abin.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/emp")
@Controller
public class EmpController {

    @Autowired
    EmpDao empDao;

    @RequestMapping("/list")
    public String getEmpList(Model model){

        List<Employee> empList = empDao.getEmpList();
        model.addAttribute("empList",empList);
        return "emp/empList";
    }
}
