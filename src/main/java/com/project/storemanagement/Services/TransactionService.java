package com.project.storemanagement.Services;

import com.project.storemanagement.Entities.Employee;
import com.project.storemanagement.Entities.Enterprise;
import com.project.storemanagement.Entities.Profile;
import com.project.storemanagement.Entities.Transaction;
import com.project.storemanagement.Repositories.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public int saveTransaction(Transaction transaction){
        int res=0;
        Transaction transaction1= repositoryTransaction.save(transaction);
        if(!transaction1.equals(null)){
            res=1;
        }
        return res;
    }


    public Transaction getTransactionById(Long id) {
        Optional<Transaction> optional = repositoryTransaction.findById(id);
        Transaction transaction = null;
        if (optional.isPresent()) {
            transaction = optional.get();
        } else {
            throw new RuntimeException(" Transaction not found for id :: " + id);
        }
        return transaction;
    }

    public void deleteTransaction(Long id){
        repositoryTransaction.deleteById(id);
    }

    public void  actulizarTransaction(Transaction Transaction){
        repositoryTransaction.save(Transaction);
    }


}
