package com.project.storemanagement.Controllers;

import com.project.storemanagement.Entities.Profile;
import com.project.storemanagement.Services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;


//@Controller
@RestController
public class ProfileController {
    @Autowired
   ProfileService serviceProfile;


    public ProfileController(ProfileService serviceProfile) {
        this.serviceProfile = serviceProfile;
    }

    @GetMapping("/profile")
    //@RequestMapping(value = "/profile", method = RequestMethod.GET)
    public List<Profile> profileList() {
        return this.serviceProfile.getprofileList();
    }

    @PostMapping("/profile")
    public Profile createProfile(@RequestBody Profile profile) {
        serviceProfile.createProfile(profile);
        return this.serviceProfile.createProfile(profile);
    }

    @GetMapping("/profile/{id}")
    public  Profile getProfile(@PathVariable("id") Long id){
        return serviceProfile.getProfile(id);
    }
        @DeleteMapping("/profile/{id}")
    public void delete(@PathVariable("id") Long id){
        serviceProfile.delete(id);
    }


}

