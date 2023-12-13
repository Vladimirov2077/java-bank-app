package com.vaasok.javabankapp.DAOs;

import com.vaasok.javabankapp.Models.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerDao implements DaoI<Customer> {
    private List<Customer> customers = new ArrayList<>();

    @Override
    public Customer save(Customer obj) {
        customers.add(obj);
        return obj;
    }

    @Override
    public boolean delete(Customer obj) {
        return customers.remove(obj);
    }

    @Override
    public void deleteAll(List<Customer> entities) {
        customers.removeAll(entities);
    }

    @Override
    public void saveAll(List<Customer> entities) {
        customers.addAll(entities);
    }

    @Override
    public List<Customer> findAll() {
        return customers;
    }

    @Override
    public boolean deleteById(long id) {
        return customers.removeIf(customer -> customer.getId().equals(id));
    }

    @Override
    public Customer findById(long id) {
        return customers.stream()
                .filter(customer -> customer.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
