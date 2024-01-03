package com.vaasok.javabankapp.DAOs;

import com.vaasok.javabankapp.Models.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDao implements DaoI<Account> {
    private List<Account> accounts = new ArrayList<>();
    private Long id = 0L;

    @Override
    public Account save(Account obj) {

        Account existingAccount = findById(obj.getId());

        if (existingAccount == null) {
            obj.setId(++id);
            accounts.add(obj);
        } else {
            existingAccount.setCurrency(obj.getCurrency());
            existingAccount.setCustomer(obj.getCustomer());
        }

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
    public boolean deleteById(Long id) {
        for (Account account : accounts) {
            if (account.getId() == id) {
                return accounts.remove(account);
            }
        }
        return false;
    }

    @Override
    public Account findById(Long id) {

        for (Account account : accounts) {
            if (account.getId() == id) {
                return account;
            }
        }
        return null;
    }
}
