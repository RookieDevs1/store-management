package com.project.storemanagement.Controllers;

import com.project.storemanagement.Entities.Transaction;
import com.project.storemanagement.Services.TransactionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
