package com.vaasok.javabankapp.DAOs;

import com.vaasok.javabankapp.Models.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerDao implements DaoI<Customer> {
    private List<Customer> customers = new ArrayList<>();
    private Long id = 0L;

    @Override
    public Customer save(Customer obj) {
        Customer existingCustomer = findById(obj.getId());

        if (existingCustomer == null) {
            obj.setId(++id);
            customers.add(obj);
        } else {
            existingCustomer.setName(obj.getName());
            existingCustomer.setEmail(obj.getEmail());
            existingCustomer.setAge(obj.getAge());
            existingCustomer.setAccounts(obj.getAccounts());
        }

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
    public boolean deleteById(Long id) {
        return customers.removeIf(customer -> customer.getId().equals(id));
    }

    @Override
    public Customer findById(Long id) {
        return customers.stream()
                .filter(customer -> customer.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
