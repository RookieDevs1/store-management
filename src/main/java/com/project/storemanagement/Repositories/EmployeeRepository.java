package com.project.storemanagement.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.storemanagement.Entities.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
        @Query(value="SELECT * FROM employee where enterprise_id= ?1", nativeQuery=true)

        public abstract ArrayList<Employee> findByEnterprise(Long id);
}
