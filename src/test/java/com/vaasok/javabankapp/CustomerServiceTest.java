package com.vaasok.javabankapp;

import com.vaasok.javabankapp.DAOs.CustomerDao;
import com.vaasok.javabankapp.Models.Customer;
import com.vaasok.javabankapp.Services.CustomerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CustomerServiceTest {
    CustomerService customerService;

    @BeforeEach
    public void beforeEach() {
        this.customerService = new CustomerService(new CustomerDao());
    }

    @Test
    public void createCustomerTest() {
        Assertions.assertTrue(customerService.getAllCustomers().isEmpty());

        customerService.createCustomer("", "", 0);

        Assertions.assertEquals(1, customerService.getAllCustomers().size());

    }

    @Test
    public void getAllCustomersTest() {
        Assertions.assertTrue(customerService.getAllCustomers().isEmpty());

        customerService.createCustomer("", "", 0);
        customerService.createCustomer("", "", 0);
        customerService.createCustomer("", "", 0);

        Assertions.assertEquals(3, customerService.getAllCustomers().size());

    }

    @Test
    public void getCustomerByIdTest() {
        Assertions.assertTrue(customerService.getAllCustomers().isEmpty());

        Customer customer = customerService.createCustomer("", "", 0);

        long testId = customer.getId();

        Assertions.assertEquals(customer, customerService.getCustomerById(testId));

    }

    @Test
    public void deleteCustomerByIdTest() {
        Assertions.assertTrue(customerService.getAllCustomers().isEmpty());

        Customer customer = customerService.createCustomer("", "", 0);

        long testId = customer.getId();

        customerService.deleteCustomerById(testId);

        Assertions.assertTrue(customerService.getAllCustomers().isEmpty());


    }

    @Test
    public void updateCustomerTest() {
        Assertions.assertTrue(customerService.getAllCustomers().isEmpty());

        Customer customer = customerService.createCustomer("", "", 0);

        long testId = customer.getId();

        customerService.updateCustomer(testId, "test", "test", 1);

        Assertions.assertEquals(customer.getName(), "test");

    }

}
