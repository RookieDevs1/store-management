package com.project.storemanagement.Services;

import com.project.storemanagement.Entities.Employee;
import com.project.storemanagement.Entities.Enterprise;
import com.project.storemanagement.Entities.Profile;
import com.project.storemanagement.Repositories.EnterpriseRepository;
import net.bytebuddy.asm.Advice;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


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

    public int saveEnterprise(Enterprise enterprise){
        int res=0;
        Enterprise enterprise1= repositoryEnterprise.save(enterprise);
        if(!enterprise1.equals(null)){
            res=1;
        }
        return res;
    }


    public Enterprise getEnterpriseById(Long id) {
        Optional<Enterprise> optional = repositoryEnterprise.findById(id);
        Enterprise enterprise = null;
        if (optional.isPresent()) {
            enterprise = optional.get();
        } else {
            throw new RuntimeException(" Enterprise not found for id :: " + id);
        }
        return enterprise;
    }

    public void deleteEnterprise(Long id){
        repositoryEnterprise.deleteById(id);
    }

    public void  actulizarEnterprise(Enterprise enterprise){
        repositoryEnterprise.save(enterprise);
    }


}


