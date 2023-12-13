package com.vaasok.javabankapp.Services;

import com.vaasok.javabankapp.Models.Account;
import com.vaasok.javabankapp.Models.Currency;
import com.vaasok.javabankapp.Models.Customer;
import com.vaasok.javabankapp.DAOs.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    private final AccountDao accountDao;

    @Autowired
    public AccountService(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public Account createAccount(Currency currency, Customer customer) {

        Account account = new Account(currency, customer);

        customer.addAccount(account);

        return accountDao.save(account);

    }

    public List<Account> getAllAccounts() {
        return accountDao.findAll();
    }

    public Account getAccountById(Long id) {
        return accountDao.findById(id);
    }

    public boolean deleteAccountById(Long id) {
        return accountDao.deleteById(id);
    }

    public void deposit(Long accountId, Double amount) {
        Account account = accountDao.findById(accountId);
        account.setBalance(account.getBalance() + amount);
        accountDao.save(account);
    }

    public boolean withdraw(Long accountId, Double amount) {
        Account account = accountDao.findById(accountId);
        if (account.getBalance() >= amount) {
            account.setBalance(account.getBalance() - amount);
            accountDao.save(account);
            return true;
        }
        return false;
    }

    public boolean transfer(Long sourceAccountId, Long targetAccountId, Double amount) {
        Account sourceAccount = accountDao.findById(sourceAccountId);
        Account targetAccount = accountDao.findById(targetAccountId);

        if (sourceAccount.getBalance() >= amount) {
            sourceAccount.setBalance(sourceAccount.getBalance() - amount);
            targetAccount.setBalance(targetAccount.getBalance() + amount);

            accountDao.save(sourceAccount);
            accountDao.save(targetAccount);

            return true;
        }
        return false;
    }
}