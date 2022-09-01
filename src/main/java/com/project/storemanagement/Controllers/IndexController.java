package com.project.storemanagement.Controllers;

import com.project.storemanagement.Entity.Employee;
import com.project.storemanagement.Entity.Profile;
import com.project.storemanagement.Services.EmployeeService;
import com.project.storemanagement.Services.ProfileService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IndexController {

    EmployeeService serviceEmployee;

    public IndexController(EmployeeService serviceEmployee){
        this.serviceEmployee = serviceEmployee;
    }

    @GetMapping("/employee")
    public List<Employee> empleadoList(){
        return this.serviceEmployee.getEmpleadosList();
    }





}
