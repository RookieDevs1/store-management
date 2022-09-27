package com.project.storemanagement.Services;

import com.project.storemanagement.Entities.Employee;
import com.project.storemanagement.Entities.Enterprise;
import com.project.storemanagement.Entities.Profile;
import com.project.storemanagement.Repositories.EnterpriseRepository;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class EnterpriseService {

    @Autowired
    EnterpriseRepository enterpriseRepository;
    //Metodo que retorna una lista de empresas
    public List<Enterprise> getAllEnterprise(){
        List<Enterprise> enterpriseList = new ArrayList<>();
        enterpriseRepository.findAll().forEach(enterprise -> enterpriseList.add(enterprise));
        return enterpriseList;
    }
    //Metodo que retorna una empresa por id
    public Enterprise getEnterpriseById(Long id){
        return enterpriseRepository.findById(id).get();
    }


    public boolean saveOrUpdateEnterprise(Enterprise enterprise){
        Enterprise enterpriseTemp = enterpriseRepository.save(enterprise);
        if(enterpriseRepository.findById(enterpriseTemp.getId())!=null){
            return true;
        }
        return false;
    }

    public boolean deleteEnterprise(Long id){
        enterpriseRepository.deleteById(id);
        if (enterpriseRepository.findById(id)==null){
            return true;
        }
        return false;
    }

}


