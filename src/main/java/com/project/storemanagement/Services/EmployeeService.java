package com.project.storemanagement.Services;

import com.project.storemanagement.Entities.Employee;
import com.project.storemanagement.Repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeService {
private EmployeeRepository repositoryEmployee;

public EmployeeService(EmployeeRepository repositoryEmpleado){
    this.repositoryEmployee =repositoryEmpleado;
}

public List<Employee> getEmpleadosList(){
    return this.repositoryEmployee.findAll();
}

public Employee createEmployee(Employee employee){
    return this.repositoryEmployee.save(employee);
}

    public Employee getEmployee(Long id){
        return repositoryEmployee.getOne(id);
    }


    public void delete(Long id){
        repositoryEmployee.deleteById(id);
    }

    public void  actulizar(Employee employee){
       repositoryEmployee.save(employee);
}


}
