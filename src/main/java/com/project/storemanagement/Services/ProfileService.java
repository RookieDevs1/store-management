package com.project.storemanagement.Services;

import com.project.storemanagement.Entities.Profile;
import com.project.storemanagement.Repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProfileService {


    private ProfileRepository repositoryProfile;



    public ProfileService (ProfileRepository repositoryProfile){
        this.repositoryProfile =repositoryProfile;
    }
// obtner lista de perfiles
    public List<Profile> getprofileList(){
        return this.repositoryProfile.findAll();
    }
//crear y guardar perfil
    public Profile createProfile(Profile profile){
        return this.repositoryProfile.save(profile);
    }

public Profile getProfile(Long id){
        return repositoryProfile.getOne(id);
}


    public void delete(Long id){
        repositoryProfile.deleteById(id);
    }


}
