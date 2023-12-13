package com.vaasok.javabankapp.Controllers;

import com.vaasok.javabankapp.Models.Account;
import com.vaasok.javabankapp.Models.Currency;
import com.vaasok.javabankapp.Models.Customer;
import com.vaasok.javabankapp.Services.AccountService;
import com.vaasok.javabankapp.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    private final AccountService accountService;
    private final CustomerService customerService;

    @Autowired
    public AccountController(AccountService accountService, CustomerService customerService) {
        this.accountService = accountService;
        this.customerService = customerService;
    }

    @PostMapping("/create")
    public Account createAccount(@RequestParam Currency currency, @RequestParam Long customerId) {

        Customer customer = customerService.getCustomerById(customerId);

        return accountService.createAccount(currency, customer);
    }

    @GetMapping("/all")
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @GetMapping("/{id}")
    public Account getAccountById(@PathVariable Long id) {
        return accountService.getAccountById(id);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteAccount(@PathVariable Long id) {
        return accountService.deleteAccountById(id);
    }

    @PostMapping("/deposit")
    public void deposit(@RequestParam Long accountId, @RequestParam Double amount) {
        accountService.deposit(accountId, amount);
    }

    @PostMapping("/withdraw")
    public boolean withdraw(@RequestParam Long accountId, @RequestParam Double amount) {
        return accountService.withdraw(accountId, amount);
    }

    @PostMapping("/transfer")
    public boolean transfer(@RequestParam Long sourceAccountId, @RequestParam Long targetAccountId, @RequestParam Double amount) {
        return accountService.transfer(sourceAccountId, targetAccountId, amount);
    }
}
