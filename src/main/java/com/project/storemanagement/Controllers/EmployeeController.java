package com.project.storemanagement.Controllers;

import com.project.storemanagement.Entities.Employee;
import com.project.storemanagement.Services.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RestController
public class EmployeeController {

    EmployeeService serviceEmployee;

    public EmployeeController(EmployeeService serviceEmployee){
        this.serviceEmployee = serviceEmployee;
    }
   // @RequestMapping(value = "/employee", method = RequestMethod.GET)
    @GetMapping("/employee")
    public List<Employee> empleadoList(){
        return this.serviceEmployee.getEmpleadosList();
    }





}
