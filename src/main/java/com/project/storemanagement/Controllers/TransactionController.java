package com.project.storemanagement.Controllers;

import com.project.storemanagement.Entities.Employee;
import com.project.storemanagement.Entities.Transaction;
import com.project.storemanagement.Services.TransactionService;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Validated
@Controller
@RequestMapping
public class TransactionController {

    TransactionService serviceTransaction;

    public TransactionController(TransactionService serviceTransaction){
        this.serviceTransaction = serviceTransaction;
    }

    @GetMapping("/transaction")
    public String transactionList(Model model){
        List<Transaction> transaction = serviceTransaction.getTransactionList();
        model.addAttribute("transaction", transaction);
        return "transaction";
    }

    @GetMapping("/newTransaction")
    public  String addTransaction(Model model){
        model.addAttribute("transaction", new Transaction());
        return "newTransaction";
    }

    @PostMapping("/saveTransaction")
    public String saveTransaction(@ModelAttribute @DateTimeFormat(pattern = "yyyy-MM-dd") Transaction transaction, Model model ) {
        model.addAttribute(transaction);
        serviceTransaction.saveTransaction(transaction);
        return "redirect:/transaction";
    }



    @GetMapping("/updateTransaction/{id}")
    public String updateTransaction(@PathVariable( value = "id") Long id, Model model) {
        Transaction transaction = serviceTransaction.getTransactionById(id);
        model.addAttribute("transaction", transaction);
        return "updateTransaction";
    }


    @GetMapping("/deleteTransaction/{id}")
    public String deleteTransaction(Model model, @PathVariable (value = "id") Long id) {
        serviceTransaction.deleteTransaction(id);
        return "redirect:/transaction";
    }


}
