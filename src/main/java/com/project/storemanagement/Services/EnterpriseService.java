package com.project.storemanagement.Services;

import com.project.storemanagement.Entities.Enterprise;
import com.project.storemanagement.Entities.Profile;
import com.project.storemanagement.Repositories.EnterpriseRepository;
import net.bytebuddy.asm.Advice;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class EnterpriseService {


    private EnterpriseRepository repositoryEnterprise;

    public EnterpriseService(EnterpriseRepository repositoryEnterprise) {
        this.repositoryEnterprise = repositoryEnterprise;
    }

    public List<Enterprise> getEnterpriseList(){
        return this.repositoryEnterprise.findAll();
    }

    public Enterprise createEnterprise(Enterprise enterprise){
        return this.repositoryEnterprise.save(enterprise);
    }
    public Enterprise getEnterprise(Long id){
        return repositoryEnterprise.getOne(id);
    }




}


