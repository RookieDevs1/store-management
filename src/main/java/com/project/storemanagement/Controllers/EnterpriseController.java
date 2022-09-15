package com.project.storemanagement.Controllers;


import com.project.storemanagement.Entities.Enterprise;
import com.project.storemanagement.Services.EnterpriseService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Validated
@Controller
@RequestMapping
public class EnterpriseController {

    EnterpriseService serviceEnterprise;

    public EnterpriseController(EnterpriseService serviceEnterprise){
        this.serviceEnterprise = serviceEnterprise;
    }



    @GetMapping("/enterprise")
    public String enterpriseList(Model model){
        List<Enterprise> enterprise = serviceEnterprise.getEnterpriseList();
        model.addAttribute("enterprise", enterprise);
        return "enterprise";
    }


    @GetMapping("/newEnterprise")
    public  String addEnterprise(Model model){
        model.addAttribute("enterprise", new Enterprise());
        return "newEnterprise";
    }

    @PostMapping("/saveEnterprise")
    public String saveEnterprise(@DateTimeFormat(pattern = "YYY-MM-DD") @ModelAttribute("enterprise") Enterprise enterprise) {
        serviceEnterprise.saveEnterprise(enterprise);
        return "redirect:/enterprise";
    }


    @GetMapping("/updateEnterprise/{id}")
    public String updateEnterprise(@PathVariable ( value = "id") Long id, Model model) {
        Enterprise enterprise = serviceEnterprise.getEnterpriseById(id);
        model.addAttribute("enterprise", enterprise);
        return "updateEnterprise";
    }


    @GetMapping("/deleteEnterprise/{id}")
    public String deleteEnterprise(Model model, @PathVariable (value = "id") Long id) {
        serviceEnterprise.deleteEnterprise(id);
        return "redirect:/enterprise";
    }


}
