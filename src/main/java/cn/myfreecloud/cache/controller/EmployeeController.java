package cn.myfreecloud.cache.controller;

import cn.myfreecloud.cache.bean.Employee;
import cn.myfreecloud.cache.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/getEmployee")
    public Employee getEmployee(Integer id) {
        System.out.println("查询员工" + id);
        return employeeService.getEmpById(id);
    }

    @GetMapping("/updateEmployee")
    public Employee updateEmployee(Employee employee) {
        return employeeService.updateEmpById(employee);
    }

    @GetMapping("/deleteEmployee")
    public void deleteEmployee(Integer id) {
        employeeService.deleteEmpById(id);
    }

    @GetMapping("/getEmpByLastName/{lastName}")
    public Employee getEmpByLastName(@PathVariable("lastName") String lastName) {
        Employee empByLastName = employeeService.getEmpByLastName(lastName);
        return empByLastName;
    }
}
