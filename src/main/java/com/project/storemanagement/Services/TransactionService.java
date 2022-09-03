package com.project.storemanagement.Services;

import com.project.storemanagement.Entities.Employee;
import com.project.storemanagement.Entities.Transaction;
import com.project.storemanagement.Repositories.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    private TransactionRepository repositoryTransaction;

    public TransactionService(TransactionRepository repositoryTransaction){
            this.repositoryTransaction = repositoryTransaction;
    }

    public List<Transaction> getTransactionList(){
        return this.repositoryTransaction.findAll();
    }

    public Transaction createTransaction(Transaction transaction){
        return this.repositoryTransaction.save(transaction);
    }

    public Transaction getTransaction(Long id){
        return repositoryTransaction.getOne(id);
    }

    public void delete(Long id){
        repositoryTransaction.deleteById(id);
    }
}
