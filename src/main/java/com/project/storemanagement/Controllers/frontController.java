package com.project.storemanagement.Controllers;

import com.project.storemanagement.Entities.Profile;
import com.project.storemanagement.Services.EmployeeService;
import com.project.storemanagement.Services.ProfileService;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;


@Validated
@Controller
@RequestMapping

public class frontController {


    EmployeeService employeeService;

    ProfileService profileService;

    public frontController(EmployeeService employeeService, ProfileService profileService){
        this.employeeService=employeeService;
        this.profileService=profileService;
    }

    @GetMapping("/")
    public String home( @AuthenticationPrincipal OidcUser principal , Model model) {
        if (principal != null) {
            Profile profile= this.profileService.getCreateProfile(principal.getClaims());
            model.addAttribute("profile",profile);
   //System.out.println( principal.getClaims());
        }
        return "index";
    }




    @GetMapping("/inicio")
    public String Inicio(Model model) {
        return "inicio";
    }





}
