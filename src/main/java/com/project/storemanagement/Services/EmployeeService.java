package com.project.storemanagement.Services;

import com.project.storemanagement.Entities.Employee;
import com.project.storemanagement.Repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
private EmployeeRepository repositoryEmployee;

public EmployeeService(EmployeeRepository repositoryEmpleado){
    this.repositoryEmployee =repositoryEmpleado;
}

public List<Employee> getEmployeeList(){
    return repositoryEmployee.findAll();
}

public Employee createEmployee(Employee employee){
    return this.repositoryEmployee.save(employee);
}


public int saveEmployee(Employee employee){
    int res=0;
    Employee employee1= repositoryEmployee.save(employee);
    if(!employee1.equals(null)){
        res=1;
    }
    return res;
}
/*
    public Employee getEmployee(Long id){
        return repositoryEmployee.getOne(id);
    }
    */


    public Employee getEmployeeById(Long id) {
        Optional<Employee> optional = repositoryEmployee.findById(id);
        Employee employee = null;
        if (optional.isPresent()) {
            employee = optional.get();
        } else {
            throw new RuntimeException(" Employee not found for id :: " + id);
        }
        return employee;
    }

    public void delete(Long id){
        repositoryEmployee.deleteById(id);
    }

    public void  actulizar(Employee employee){
       repositoryEmployee.save(employee);
}

}
