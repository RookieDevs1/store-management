package com.project.storemanagement.Controllers;

import com.project.storemanagement.Entities.Employee;
import com.project.storemanagement.Entities.Enterprise;
import com.project.storemanagement.Entities.Profile;
import com.project.storemanagement.Services.EmployeeService;
import com.project.storemanagement.Services.EnterpriseService;
import com.project.storemanagement.Services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Validated
@Controller
@RequestMapping
public class EmployeeController {


    @Autowired
    EmployeeService employeeService;
    @Autowired
    EnterpriseService enterpriseService;
    @Autowired
    ProfileService profileService;

    @GetMapping("/employee")
    public String viewEmployee(Model model, @ModelAttribute("message") String message) {
        List<Employee> employeeList = employeeService.getAllEmployee();
        model.addAttribute("employee", employeeList);
        model.addAttribute("message", message);
        return "employee";
    }

    @GetMapping("/newEmployee")
    public String newEmployee(Model model, @ModelAttribute("message") String message) {
        Employee employee = new Employee();
        List<Enterprise> enterpriseList = enterpriseService.getAllEnterprise();
        List<Profile> profileList = profileService.getAllProfile();
        model.addAttribute("profile", profileList);
        model.addAttribute("employee", employee);
        model.addAttribute("enterprise", enterpriseList);
        model.addAttribute("message", message);
        return "newEmployee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(Employee employee, RedirectAttributes redirectAttributes) {
        if (employeeService.saveOrUpdateEmployee(employee)) {
            redirectAttributes.addFlashAttribute("message", "saveOK");
            return "redirect:/employee";
        }
        redirectAttributes.addFlashAttribute("message", "saveERROR");
        return "redirect:/newEmployee";
    }

    @GetMapping("/updateEmployee/{id}")
    public String editEmployee(Model model, @PathVariable Long id, @ModelAttribute("message") String message) {
        List<Enterprise> enterpriseList = enterpriseService.getAllEnterprise();

        Employee employee = employeeService.getEmployeeById(id).get();
        model.addAttribute("enterprise", enterpriseList);
        model.addAttribute("employee", employee);
        model.addAttribute("message", message);
        return "updateEmployee";
    }



    @PostMapping("/updateEmployee")
    public String updateEmployee(@ModelAttribute("employee")Employee employee, RedirectAttributes redirectAttributes) {
        if (employeeService.saveOrUpdateEmployee(employee)) {
            redirectAttributes.addFlashAttribute("message", "updateOK");
            return "redirect:/employee";
        }
        redirectAttributes.addFlashAttribute("message", "updateERROR");
        return "redirect:/updateEmployee";
    }



    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable (value = "id") Long id, RedirectAttributes redirectAttributes) {
        if (employeeService.deleteEmployee(id)) {
            redirectAttributes.addFlashAttribute("message", "deleteERROR");
            return "redirect:/employee";
        }
        redirectAttributes.addFlashAttribute("message", "deleteOK");
        return "redirect:/employee";
    }


    @GetMapping("/enterprise/{id}/employee")
    public String viewEmployeeByEnterprise(@PathVariable("id") Long id, Model model){
        List<Employee> employeeList = employeeService.getEmployeeByEnterprise(id);
        model.addAttribute("employee",employeeList);
        return "employee";
    }


}
