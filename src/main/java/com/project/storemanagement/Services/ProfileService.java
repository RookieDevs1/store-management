package com.project.storemanagement.Services;

import com.project.storemanagement.Entities.Employee;
import com.project.storemanagement.Entities.Profile;
import com.project.storemanagement.Repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;



    public ProfileService (ProfileRepository repositoryProfile){
        this.profileRepository =repositoryProfile;
    }

public Profile createProfile(Profile newProfile){
        return this.profileRepository.save(newProfile);

}
public Profile findProfileByEmail(String email){
        return this.profileRepository.findByEmail(email);
}
    public Profile getCreateProfile(Map<String, Object> profileData) {

        String email = (String) profileData.get("email");

        Profile profile = findProfileByEmail(email);
        if (profile == null) {

            String name = (String) profileData.get("name");
            String image = (String) profileData.get("picture");
            String authoId = (String) profileData.get("sub");



            Profile newProfile = new Profile(name=name, email = email, image = image, authoId = authoId);
            return createProfile(newProfile);
        }
       // System.out.println(profile.getEmail());
        return profile;
    }


    public List<Profile> getAllProfile(){
        List<Profile> profileList= new ArrayList<>();
        profileRepository.findAll().forEach(profile -> profileList.add(profile));
        return profileList;
    }





}
