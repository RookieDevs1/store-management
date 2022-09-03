package com.project.storemanagement.Controllers;


import com.project.storemanagement.Entities.Employee;
import com.project.storemanagement.Entities.Enterprise;
import com.project.storemanagement.Services.EnterpriseService;
import net.bytebuddy.asm.Advice;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/enterprise")
    public Enterprise createEnterprise(@RequestBody Enterprise enterprise){
        return this.serviceEnterprise.createEnterprise(enterprise);
    }

//buscar por id
    @GetMapping("/enterprise/{id}")
    public Enterprise getEnterprise(@PathVariable("id") Long id){
        return serviceEnterprise.getEnterprise(id);
    }

    //eliminar por id
    @DeleteMapping("/enterprise/{id}")
    @Query("SELECT DISTINCT enterprise.id from enterprise  where  enterprise.id= ?")
    public void delete(@PathVariable("id") Long id){
        serviceEnterprise.delete(id);
    }




}
