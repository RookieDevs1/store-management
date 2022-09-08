package com.project.storemanagement.Controllers;

import com.project.storemanagement.Entities.Employee;
import com.project.storemanagement.Entities.Profile;
import com.project.storemanagement.Entities.Transaction;
import com.project.storemanagement.Services.TransactionService;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
@RestController
public class TransactionController {

    TransactionService serviceTransaction;

    public TransactionController(TransactionService serviceTransaction){
        this.serviceTransaction = serviceTransaction;
    }

    @GetMapping("/transaction")
    public List<Transaction> transactionsList(){
        return this.serviceTransaction.getTransactionList();
    }

    @PostMapping("/transaction")
    public Transaction createTransaction(@RequestBody Transaction transaction){
        return this.serviceTransaction.createTransaction(transaction);
    }

    @GetMapping("/transaction/{id}")
    public Transaction getTransaction(@PathVariable("id") Long id){
        return serviceTransaction.getTransaction(id);
    }

    @DeleteMapping("/transaction/{id}")
  //  @Query("SELECT DISTINCT transaction.id from transaction  where  transaction.id= ?")
    public void delete(@PathVariable("id") Long id){
        serviceTransaction.delete(id);
    }

    @PutMapping("/transaction/{id}")
    public void actulizarProfile(@RequestBody Transaction transaction){
        serviceTransaction.actulizar(transaction);
    }


}
