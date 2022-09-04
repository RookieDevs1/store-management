package com.project.storemanagement.Services;

import com.project.storemanagement.Entities.Employee;
import com.project.storemanagement.Entities.Profile;
import com.project.storemanagement.Repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeService {
private EmployeeRepository repositoryEmpleado;

public EmployeeService(EmployeeRepository repositoryEmpleado){
    this.repositoryEmpleado =repositoryEmpleado;
}

public List<Employee> getEmpleadosList(){
    return this.repositoryEmpleado.findAll();
}

public Employee createEmployee(Employee employee){
    return this.repositoryEmpleado.save(employee);
}

    public Employee getEmployee(Long id){
        return repositoryEmpleado.getOne(id);
    }


    public void delete(Long id){
        repositoryEmpleado.deleteById(id);
    }
}
