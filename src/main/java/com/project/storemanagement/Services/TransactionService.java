package com.project.storemanagement.Services;

import com.project.storemanagement.Entities.Employee;
import com.project.storemanagement.Entities.Enterprise;
import com.project.storemanagement.Entities.Profile;
import com.project.storemanagement.Entities.Transaction;
import com.project.storemanagement.Repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {


    @Autowired
    TransactionRepository transactionRepository;

    public List<Transaction> getAllTransaction(){
        List<Transaction> transactionList= new ArrayList<>();
        transactionRepository.findAll().forEach(transaction -> transactionList.add(transaction));
        return transactionList;
    }

    public Optional<Transaction> getTransactionById(Long id){ //Existe optional y asi se podria usar

        return transactionRepository.findById(id);
    }

    public boolean saveOrUpdateTransaction(Transaction transaction){
        Transaction transactionTemp = transactionRepository.save(transaction);
        if(transactionRepository.findById(transactionTemp.getId())!=null){
            return true;
        }
        return false;
    }

    public boolean deleteTransaction(Long id){
        transactionRepository.deleteById(id);
        if(this.transactionRepository.findById(id).isPresent()){
            return false;
        }
        return true;
    }
    public ArrayList<Transaction> findByEmployee(Long id) {
        return transactionRepository.findByEmployee(id);
    }
    public ArrayList<Transaction> findByEnterprise(Long id) {
        return transactionRepository.findByEnterprise(id);
    }

    public Long sumAmount(){
        return transactionRepository.sumAmount();
    }

    public Long sumAmountByEmployee(Long id){
        return transactionRepository.sumAmountByEmployee(id);
    }

    public Long sumAmountByEnterprise(Long id){
        return transactionRepository.sumAmountByEnterprise(id);
    }

}
