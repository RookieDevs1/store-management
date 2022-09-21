package com.project.storemanagement.Services;

import com.project.storemanagement.Entities.Employee;
import com.project.storemanagement.Entities.Enterprise;
import com.project.storemanagement.Repositories.EmployeeRepository;
import com.project.storemanagement.Repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    private TransactionRepository transactionRepository;


    public List<Employee> getAllEmployee(){
        List<Employee> employeeList= new ArrayList<>();
        employeeRepository.findAll().forEach(employee -> employeeList.add(employee));
        return employeeList;
    }


    public Optional<Employee> getEmployeeById(Long id){ //Existe optional y asi se podria usar

        return employeeRepository.findById(id);
    }

    public ArrayList<Employee> getEmployeeByEnterprise(Long id){
        return employeeRepository.findByEnterprise(id);
    }


    public boolean saveOrUpdateEmployee(Employee employee){
        Employee employeeTemp = employeeRepository.save(employee);
        if(employeeRepository.findById(employeeTemp.getId())!=null){
            return true;
        }
        return false;
    }

    public boolean deleteEmployee(Long id){
        employeeRepository.deleteById(id);
        if(this.employeeRepository.findById(id).isPresent()){
            return false;
        }
        return true;
    }






}
