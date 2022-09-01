package com.project.storemanagement.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.storemanagement.Entity.Employee;
import org.springframework.stereotype.Repository;

@Repository

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
