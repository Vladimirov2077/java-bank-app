package com.vaasok.javabankapp;

import com.vaasok.javabankapp.DAOs.AccountDao;
import com.vaasok.javabankapp.Models.Account;
import com.vaasok.javabankapp.Models.Currency;
import com.vaasok.javabankapp.Models.Customer;
import com.vaasok.javabankapp.Services.AccountService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class AccountServiceTests {

    AccountService accountService;

    @BeforeEach
    public void beforeEach() {
        this.accountService = new AccountService(new AccountDao());
    }

    @Test
    public void createAccountTest() {
        Assertions.assertTrue(accountService.getAllAccounts().isEmpty());

        accountService.createAccount(Currency.EUR, Mockito.mock(Customer.class));

        Assertions.assertEquals(1, accountService.getAllAccounts().size());
    }

    @Test
    public void getAllAccountsTest() {
        Assertions.assertTrue(accountService.getAllAccounts().isEmpty());

        accountService.createAccount(Currency.EUR, Mockito.mock(Customer.class));
        accountService.createAccount(Currency.EUR, Mockito.mock(Customer.class));
        accountService.createAccount(Currency.EUR, Mockito.mock(Customer.class));
        accountService.createAccount(Currency.EUR, Mockito.mock(Customer.class));

        Assertions.assertEquals(4, accountService.getAllAccounts().size());

    }

    @Test
    public void getAccountByIdTest() {

        Assertions.assertTrue(accountService.getAllAccounts().isEmpty());

        Account account = accountService.createAccount(Currency.EUR, Mockito.mock(Customer.class));

        Long testId = account.getId();

        Assertions.assertEquals(account, accountService.getAccountById(testId));

    }

    @Test
    public void deleteAccountByIdTest() {

        Assertions.assertTrue(accountService.getAllAccounts().isEmpty());

        Account account = accountService.createAccount(Currency.EUR, Mockito.mock(Customer.class));

        Long testId = account.getId();

        Assertions.assertFalse(accountService.getAllAccounts().isEmpty());

        accountService.deleteAccountById(testId);

        Assertions.assertTrue(accountService.getAllAccounts().isEmpty());

    }

    @Test
    public void depositTest() {

        Account account = accountService.createAccount(Currency.USD, Mockito.mock(Customer.class));

        long testId = account.getId();

        Assertions.assertEquals(0.0, account.getBalance());

        accountService.deposit(testId, 100.0);

        Assertions.assertEquals(100.0, account.getBalance());
    }

    @Test
    public void withdrawTest() {

        Account account = accountService.createAccount(Currency.USD, Mockito.mock(Customer.class));

        long testId = account.getId();

        accountService.deposit(testId, 101.0);

        Assertions.assertEquals(101.0, account.getBalance());

        accountService.withdraw(testId, 100.0);

        Assertions.assertEquals(1.0, account.getBalance());

    }

    @Test
    public void transferTest() {

        Account account1 = accountService.createAccount(Currency.USD, Mockito.mock(Customer.class));
        Account account2 = accountService.createAccount(Currency.USD, Mockito.mock(Customer.class));

        long testId1 = account1.getId();
        long testId2 = account2.getId();

        accountService.deposit(testId1, 102.0);

        accountService.transfer(testId1, testId2, 100.0);

        Assertions.assertEquals(2.0, account1.getBalance());
        Assertions.assertEquals(100.0, account2.getBalance());

    }

}