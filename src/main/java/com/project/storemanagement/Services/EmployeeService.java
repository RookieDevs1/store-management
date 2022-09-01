package com.project.storemanagement.Services;

import com.project.storemanagement.Entities.Employee;
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


}
