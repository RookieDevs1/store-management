package com.project.storemanagement.Controllers;


import com.project.storemanagement.Entities.Employee;
import com.project.storemanagement.Entities.Enterprise;
import com.project.storemanagement.Services.EnterpriseService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


//@Controller
@RestController
public class EnterpriseController {

    EnterpriseService serviceEnterprise;

    public EnterpriseController(EnterpriseService serviceEnterprise){
        this.serviceEnterprise = serviceEnterprise;
    }
   @GetMapping("/enterprise")
    public List<Enterprise> enterpriseList(){
        return this.serviceEnterprise.getEnterpriseList();
    }




}
