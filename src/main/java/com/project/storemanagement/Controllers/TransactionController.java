package com.project.storemanagement.Controllers;

import com.project.storemanagement.Entities.Employee;
import com.project.storemanagement.Entities.Transaction;
import com.project.storemanagement.Services.EmployeeService;
import com.project.storemanagement.Services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Validated
@Controller
@RequestMapping
public class TransactionController {

    @Autowired
    TransactionService transactionService;
    @Autowired
    EmployeeService employeeService;






@GetMapping("/transaction")
public String viewEmployee(Model model, @ModelAttribute("message") String message) {
    List<Transaction> transactionList = transactionService.getAllTransaction();
    model.addAttribute("transaction", transactionList);
    model.addAttribute("message", message);
    return "transaction";
}


    @GetMapping("/newTransaction")
    public String newTransaction(Model model, @ModelAttribute("message") String message) {
        Transaction transaction = new Transaction();
        List<Employee> employeeList = employeeService.getAllEmployee();
        model.addAttribute("transaction",transaction);
        model.addAttribute("employee", employeeList);
        model.addAttribute("message", message);
        return "newTransaction";
    }

    @PostMapping("/saveTransaction")
    public String saveTransaction(Transaction transaction, RedirectAttributes redirectAttributes) {
        transaction.setEnterprise(transaction.getEmployee().getEnterprise());
        if (transactionService.saveOrUpdateTransaction(transaction)) {
            redirectAttributes.addFlashAttribute("message", "saveOK");
            return "redirect:/transaction";
        }
        redirectAttributes.addFlashAttribute("message", "saveERROR");
        return "redirect:/transaction";
    }

    @GetMapping("/updateTransaction/{id}")
    public String editTransaction(Model model, @PathVariable Long id, @ModelAttribute("message") String message) {
        List<Employee> employeeList = employeeService.getAllEmployee();

        Transaction transaction = transactionService.getTransactionById(id).get();
        model.addAttribute("employee", employeeList);
        model.addAttribute("transaction", transaction);
        model.addAttribute("message", message);
        return "updateTransaction";
    }

    @PostMapping("/updateTransaction")
    public String updateTransactioe(Transaction transaction, RedirectAttributes redirectAttributes) {
        if (transactionService.saveOrUpdateTransaction(transaction)) {
            redirectAttributes.addFlashAttribute("message", "updateOK");
            return "redirect:/transaction";
        }
        redirectAttributes.addFlashAttribute("message", "updateERROR");
        return "redirect:/updateTransaction";
    }

    @GetMapping("/deleteTransaction/{id}")
    public String deleteTransaction(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try  {
            transactionService.deleteTransaction(id);
            redirectAttributes.addFlashAttribute("message", "deleteOK");
            return "redirect:/transaction";
        }catch (Exception e){
        redirectAttributes.addFlashAttribute("message", "deleteERROR");
        return "redirect:/transaction";}
    }





}
