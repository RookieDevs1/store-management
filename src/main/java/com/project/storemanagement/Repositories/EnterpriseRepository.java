package com.project.storemanagement.Repositories;

import com.project.storemanagement.Entities.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnterpriseRepository extends JpaRepository<Enterprise, Long> {

}
