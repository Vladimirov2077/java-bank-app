package com.vaasok.javabankapp.DAOs;

import com.vaasok.javabankapp.Models.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDao implements DaoI<Account> {
    private List<Account> accounts = new ArrayList<>();

    @Override
    public Account save(Account obj) {
        accounts.add(obj);
        return obj;
    }

    @Override
    public boolean delete(Account obj) {
        return accounts.remove(obj);
    }

    @Override
    public void deleteAll(List<Account> entities) {
        accounts.removeAll(entities);
    }

    @Override
    public void saveAll(List<Account> entities) {
        accounts.addAll(entities);
    }

    @Override
    public List<Account> findAll() {
        return accounts;
    }

    @Override
    public boolean deleteById(long id) {
        return accounts.removeIf(account -> account.getId().equals(id));
    }

    @Override
    public Account findById(long id) {

        for (Account account : accounts) {
            if (account.getId() == id) {
                return account;
            }
        }
        return null;
    }
}
