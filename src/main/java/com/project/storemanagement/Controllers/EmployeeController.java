package com.project.storemanagement.Controllers;

import com.project.storemanagement.Entities.Employee;
import com.project.storemanagement.Services.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
@RestController
public class EmployeeController {

    EmployeeService serviceEmployee;

    public EmployeeController(EmployeeService serviceEmployee){
        this.serviceEmployee = serviceEmployee;
    }
    @GetMapping("/employee")
    public List<Employee> employeeList(){
        return this.serviceEmployee.getEmpleadosList();
    }

    @PostMapping("/employee")
    public Employee createEmployee(@RequestBody Employee employee){
        return this.serviceEmployee.createEmployee(employee);
    }



}
