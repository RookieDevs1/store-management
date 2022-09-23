package com.project.storemanagement.Controllers;


import com.project.storemanagement.Entities.Enterprise;
import com.project.storemanagement.Services.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Validated
@Controller
@RequestMapping
public class EnterpriseController {

    @Autowired
    EnterpriseService enterpriseService;

    @GetMapping("/enterprise")
    public String viewEnterprise(Model model, @ModelAttribute("message") String message) {
        List<Enterprise> enterpriseList = enterpriseService.getAllEnterprise();
        model.addAttribute("enterprise", enterpriseList);
        model.addAttribute("message", message);
        return "enterprise";
    }

    @GetMapping("/newEnterprise")
    public String newEnterprise(Model model, @ModelAttribute("message") String message) {
        Enterprise enterprise = new Enterprise();
        model.addAttribute("enterprise", enterprise);
        model.addAttribute("message", message);
        return "newEnterprise";
    }

    @PostMapping("/saveEnterprise")
    public String saveEnterprise(Enterprise enterprise, RedirectAttributes redirectAttributes) {
        if (enterpriseService.saveOrUpdateEnterprise(enterprise)) {
            redirectAttributes.addFlashAttribute("message", "saveOK");
            return "redirect:/enterprise";
        }
        redirectAttributes.addFlashAttribute("message", "saveERROR");
        return "redirect:/newEnterprise";
    }

    @GetMapping("/updateEnterprise/{id}")
    public String editEnterprise(Model model, @PathVariable Long id, @ModelAttribute("message") String message) {
        Enterprise enterprise = enterpriseService.getEnterpriseById(id);
        model.addAttribute("enterprise", enterprise);
        model.addAttribute("message", message);
        return "updateEnterprise";
    }

    @PostMapping("/updateEnterprise")
    public String updateEnterprise(Enterprise enterprise, RedirectAttributes redirectAttributes) {
        if (enterpriseService.saveOrUpdateEnterprise(enterprise)) {
            redirectAttributes.addFlashAttribute("message", "updateOK");
            return "redirect:/enterprise";
        }
        redirectAttributes.addFlashAttribute("message", "updateERROR");
        return "redirect:/updateEnterprise";
    }

    @GetMapping("/deleteEnterprise/{id}")
    public String deleteEnterprise(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        if (enterpriseService.deleteEnterprise(id)) {
            redirectAttributes.addFlashAttribute("message", "deleteERROR");
            return "redirect:/enterprise";

        }
        redirectAttributes.addFlashAttribute("message", "deleteOK");
        return "redirect:/enterprise";
    }

}
