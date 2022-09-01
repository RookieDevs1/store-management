package com.project.storemanagement.Controllers;

import com.project.storemanagement.Entities.Profile;
import com.project.storemanagement.Services.ProfileService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class ProfileController {

    ProfileService serviceProfile;

    public ProfileController(ProfileService serviceProfile){
        this.serviceProfile = serviceProfile;
    }
    @GetMapping("/profile")
    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public List<Profile> profileList(){
        return this.serviceProfile.getprofileList();
    }
}
