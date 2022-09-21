package com.project.storemanagement.Repositories;

import com.project.storemanagement.Entities.Employee;
import com.project.storemanagement.Entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long> {

    //Metodo para filtrar movimientos por empleado
    @Query(value ="select * from transaction where employee_id= ?1", nativeQuery = true)
    public abstract ArrayList<Transaction> findByEmployee(Long id);

    //Metodo para filtrar movimientos por empresa
    @Query(value = "select * from transaction where employee_id in(select id from employee where enterprise_id=?1)",nativeQuery = true)
    public abstract ArrayList<Transaction> findByEnterprise(Long id);

    //Metodo para ver la suma de TODOS LOS MOVIMIENTOS
    @Query(value="SELECT SUM(amount) from transaction", nativeQuery = true)
    public abstract Long sumAmount();

    //Metodo para ver la suma de los montos por empleado
    @Query(value="SELECT SUM(amount) from transaction where employee_id=?1", nativeQuery = true)
    public abstract Long sumAmountByEmployee(Long id); //id del empleado

    //Metodo para ver la suma de los movimientos por empresa
    @Query(value = "select SUM(amount) from transaction where employee_id in(select id from employee where enterprise_id=?1)",nativeQuery = true)
    public  abstract Long sumAmountByEnterprise(Long id); //Id de la empresa

    //Metodo que me trae el id de un usuario cuando tengo su correo
    @Query(value="select id from transaction where email=?1", nativeQuery = true)
    public abstract Long IdPorEmail(String email);


}
