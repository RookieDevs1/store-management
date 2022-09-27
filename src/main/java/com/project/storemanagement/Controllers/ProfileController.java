package com.project.storemanagement.Controllers;


import com.project.storemanagement.Entities.Profile;
import com.project.storemanagement.Services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;

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


}

