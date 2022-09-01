package com.project.storemanagement.Services;

import com.project.storemanagement.Entities.Profile;
import com.project.storemanagement.Repositories.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProfileService {


    private ProfileRepository repositoryProfile;

    public ProfileService (ProfileRepository repositoryProfile){
        this.repositoryProfile =repositoryProfile;
    }

    public List<Profile> getprofileList(){
        return this.repositoryProfile.findAll();
    }

}
