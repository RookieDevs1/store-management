package com.project.storemanagement.Repositories;

import com.project.storemanagement.Entities.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;
import java.util.ArrayList;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {


}
