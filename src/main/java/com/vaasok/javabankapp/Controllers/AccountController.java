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
    public Object createAccount(@RequestParam String currency, @RequestParam Long customerId) {

        if (customerService.getCustomerById(customerId) == null) {
            return "Customer with id " + customerId + " does not exist";
        }

        Currency currency1 = Currency.valueOf(currency);

        Customer customer = customerService.getCustomerById(customerId);

        Account account = accountService.createAccount(currency1, customer);

        customerService.addAccountToCustomer(customer.getId(), account);

        return account;
    }

    @GetMapping("/all")
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @GetMapping("/{id}")
    public Object getAccountById(@RequestParam Long id) {

        Account account = accountService.getAccountById(id);

        if (account == null) {
            return "Account with id " + id + " does not exist";
        }

        return account;
    }


    @PostMapping("/delete")
    public String deleteAccount(@RequestParam Long id) {
        boolean success = accountService.deleteAccountById(id);

        if (success) {
            return "Account with ID " + id + " was deleted";
        } else {
            return "Account with ID " + id + " was not deleted";
        }
    }


    @PostMapping("/deposit")
    public String deposit(@RequestParam Long accountId, @RequestParam Double amount) {
        if (accountService.deposit(accountId, amount)) {
            return "Deposit successful";
        } else {
            return "Deposit failed";
        }

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
