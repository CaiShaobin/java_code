package com.abin.controller;

import com.abin.dao.DepDao;
import com.abin.dao.EmpDao;
import com.abin.pojo.Department;
import com.abin.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/emp")
@Controller
public class EmpController {

    @Autowired
    EmpDao empDao;
    @Autowired
    DepDao depDao;

    @RequestMapping("/list")
    public String getEmpList(Model model){

        List<Employee> empList = empDao.getEmpList();
        model.addAttribute("empList",empList);
        return "emp/empList";
    }

    @RequestMapping("/toAdd")
    public String toAddEmp(Model model){
        List<Department> depList = depDao.getDepList();
        model.addAttribute("depList",depList);
        return "emp/addEmp";
    }

    @GetMapping("/toUpdate/{id}")
    public String toUpdateEmp(@PathVariable("id") Integer empId, Model model){
        List<Department> depList = depDao.getDepList();
        model.addAttribute("depList",depList);

        Employee employee = empDao.getEmpById(empId);
        model.addAttribute("emp",employee);
        return "emp/updateEmp";
    }

    @PostMapping(value = "/doAdd")
    public String addEmp(Employee employee, Model model) {

        employee.getDepartment().setDepName(depDao.getDepById(employee.getDepartment().getDepId()).getDepName());
        int code = empDao.addEmp(employee);

        if (1 == code){
            return "redirect:/emp/list";
        }else {
            model.addAttribute("error","添加失败");
            return "redirect:/emp/toAdd";
        }
    }

    @PostMapping(value = "/doUpdate")
    public String updateEmp(Employee employee,Model model){

        employee.getDepartment().setDepName(depDao.getDepById(employee.getDepartment().getDepId()).getDepName());
        int code = empDao.updateEmp(employee);

        return "redirect:/emp/list";
    }

    @RequestMapping("/delEmp/{id}")
    public String deleteEmp(@PathVariable("id")Integer empId){

        empDao.deleteEmp(empId);
        return "redirect:/emp/list";
    }
}
