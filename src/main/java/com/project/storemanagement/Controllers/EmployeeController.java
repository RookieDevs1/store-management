package com.project.storemanagement.Controllers;

import com.project.storemanagement.Entities.Employee;
import com.project.storemanagement.Services.EmployeeService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class EmployeeController {

    EmployeeService serviceEmployee;

    public EmployeeController(EmployeeService serviceEmployee){
        this.serviceEmployee = serviceEmployee;
    }
    @GetMapping("/employee")
    public List<Employee> employeeList(){
        return this.serviceEmployee.getEmpleadosList();
    }

    @PostMapping("/employee")
    public Employee createEmployee(@RequestBody Employee employee){
        return this.serviceEmployee.createEmployee(employee);
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable("id") Long id){
        return serviceEmployee.getEmployee(id);
    }

    @DeleteMapping("/employee/{id}")
   // @Query("SELECT DISTINCT employee.id from employee where  employee.id= ?")
        public void delete(@PathVariable("id") Long id){
        serviceEmployee.delete(id);
    }
    @PutMapping("/employee/{id}")
    public void actulizarEmployee(@RequestBody Employee employee){
        serviceEmployee.actulizar(employee);

    }

}
