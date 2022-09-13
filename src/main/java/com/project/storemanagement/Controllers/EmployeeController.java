package com.project.storemanagement.Controllers;

import com.project.storemanagement.Entities.Employee;
import com.project.storemanagement.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Validated
@Controller
@RequestMapping
public class EmployeeController {



    @GetMapping("/")
    public String home(Model model, @AuthenticationPrincipal OidcUser principal) {
        return "index";
    }
    @Autowired
    private EmployeeService serviceEmployee;


    @GetMapping("/employee")
    // @RequestMapping(value = "listar", method = RequestMethod.GET)
    public String employeeList(Model model){
        List<Employee> employee = serviceEmployee.getEmployeeList();
        model.addAttribute("employee", employee);
        return "employee";
    }

    @GetMapping("/newEmployee")
    public  String addEmployee(Model model){
        model.addAttribute("employee", new Employee());
        return "newEmployee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        // save employee to database
        serviceEmployee.saveEmployee(employee);
        return "redirect:/employee";
    }


    @GetMapping("/updateEmployee/{id}")
    public String updateEmployee(@PathVariable ( value = "id") Long id, Model model) {
        Employee employee = serviceEmployee.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "updateEmployee";
    }



}
