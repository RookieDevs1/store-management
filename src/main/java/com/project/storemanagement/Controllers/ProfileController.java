package com.project.storemanagement.Controllers;

import com.project.storemanagement.Entities.Profile;
import com.project.storemanagement.Services.ProfileService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//@Controller
@RestController
public class ProfileController {

    ProfileService serviceProfile;

    public ProfileController(ProfileService serviceProfile){
        this.serviceProfile = serviceProfile;
    }
    @GetMapping("/profile")
    //@RequestMapping(value = "/profile", method = RequestMethod.GET)
    public List<Profile> profileList(){
        return this.serviceProfile.getprofileList();
    }

    @PostMapping("/profile")
    public Profile createProfile(@RequestBody Profile profile){
        return this.serviceProfile.createProfile(profile);
    }

}
