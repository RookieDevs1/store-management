package com.project.storemanagement.Controllers;

import com.project.storemanagement.Entities.Profile;
import com.project.storemanagement.Services.EmployeeService;
import com.project.storemanagement.Services.ProfileService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.awt.color.ProfileDataException;


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
    public String home(Model model, @AuthenticationPrincipal OidcUser principal) {
        if (principal != null) {
            Profile profile= this.profileService.getCreateProfile(principal.getClaims());
            model.addAttribute("profile",profile);
   // System.out.println( principal.getClaims());
        }
        return "index";
    }


    @GetMapping("/inicio")
    public String Inicio(Model model) {
        return "inicio";
    }

}
