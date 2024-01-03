package com.vaasok.javabankapp.Services;

import com.vaasok.javabankapp.Models.Account;
import com.vaasok.javabankapp.Models.Customer;
import com.vaasok.javabankapp.DAOs.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerDao customerDao;

    @Autowired
    public CustomerService(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public Customer createCustomer(String name, String email, Integer age) {
        Customer customer = new Customer(name, email, age);
        return customerDao.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerDao.findAll();
    }

    public Customer getCustomerById(Long id) {
        return customerDao.findById(id);
    }

    public boolean deleteCustomerById(Long id) {
        return customerDao.deleteById(id);
    }

    public Customer updateCustomer(Long id, String name, String email, Integer age) {

        if (customerDao.findById(id) == null) {
            return null;
        }

        Customer customer = customerDao.findById(id);
        customer.setName(name);
        customer.setEmail(email);
        customer.setAge(age);
        customerDao.save(customer);

        return customer;

    }

    public Customer addAccountToCustomer(Long customerId, Account account) {

        if (customerDao.findById(customerId) == null) {
            return null;
        }

        Customer customer = customerDao.findById(customerId);
        customer.addAccount(account);
        customerDao.save(customer);
        return customer;
    }


}
