package com.project.storemanagement.Controllers;

import com.project.storemanagement.Entity.Profile;
import com.project.storemanagement.Services.EmployeeService;
import com.project.storemanagement.Services.ProfileService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class ProfileController {

    ProfileService serviceProfile;

    public ProfileController(ProfileService serviceProfile){
        this.serviceProfile = serviceProfile;
    }
    @GetMapping("/profile")
    public List<Profile> profileList(){
        return this.serviceProfile.getprofileList();
    }
}
