package com.vaasok.javabankapp;

import com.vaasok.javabankapp.DAOs.AccountDao;
import com.vaasok.javabankapp.Models.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class AccountDaoTests {

    AccountDao accountDao;

    @BeforeEach
    public void beforeEach() {
        this.accountDao = new AccountDao();
    }

    @Test
    public void findAllTest() {
        Assertions.assertTrue(accountDao.findAll().isEmpty());

        accountDao.save(Mockito.mock(Account.class));
        accountDao.save(Mockito.mock(Account.class));
        accountDao.save(Mockito.mock(Account.class));

        Assertions.assertTrue(accountDao.findAll().size() == 3);


    }

    @Test
    public void saveTest() {
        Assertions.assertTrue(accountDao.findAll().isEmpty());
        accountDao.save(Mockito.mock(Account.class));
        Assertions.assertFalse(accountDao.findAll().isEmpty());
    }

    @Test
    public void saveAllTest() {
        Assertions.assertTrue(accountDao.findAll().isEmpty());

        List<Account> testList = new ArrayList<>();

        Account testAccount = (Mockito.mock(Account.class));
        Account testAccount1 = (Mockito.mock(Account.class));
        Account testAccount2 = (Mockito.mock(Account.class));

        testList.add(testAccount);
        testList.add(testAccount1);
        testList.add(testAccount2);

        accountDao.saveAll(testList);

        Assertions.assertTrue(accountDao.findAll().size() == 3);
    }

    @Test
    public void deleteTest() {
        Assertions.assertTrue(accountDao.findAll().isEmpty());
        Account account = new Account();
        accountDao.save(account);
        Assertions.assertFalse(accountDao.findAll().isEmpty());
        accountDao.delete(account);
        Assertions.assertTrue(accountDao.findAll().isEmpty());
    }

    @Test
    public void deleteAllTest() {
        Assertions.assertTrue(accountDao.findAll().isEmpty());
        Account account = new Account();
        Account account1 = new Account();
        Account account2 = new Account();
        Account account3 = new Account();
        Account account4 = new Account();
        List<Account> testAccounts = new ArrayList<>(List.of(account, account1, account2, account3, account4));
        accountDao.saveAll(testAccounts);
        Assertions.assertTrue(accountDao.findAll().size() == 5);
        accountDao.deleteAll(testAccounts);
        Assertions.assertTrue(accountDao.findAll().isEmpty());


    }

    @Test
    public void deleteByIdTest() {
        Assertions.assertTrue(accountDao.findAll().isEmpty());

        Account account = (Mockito.mock(Account.class));
        long testId = account.getId();

        accountDao.save(account);

        accountDao.deleteById(testId);

        Assertions.assertTrue(accountDao.findAll().isEmpty());

    }

    @Test
    public void findByIdTest() {
        Assertions.assertTrue(accountDao.findAll().isEmpty());

        Account account = (Mockito.mock(Account.class));

        long testId = account.getId();

        accountDao.save(account);

        Assertions.assertEquals(accountDao.findById(testId), account);

    }

}