package com.vaasok.javabankapp;

import com.vaasok.javabankapp.DAOs.CustomerDao;
import com.vaasok.javabankapp.Models.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class CustomerDaoTest {

    CustomerDao customerDao;

    @BeforeEach
    public void beforeEach() {
        this.customerDao = new CustomerDao();
    }

    @Test
    public void findAllTest() {
        Assertions.assertTrue(customerDao.findAll().isEmpty());

        customerDao.save(new Customer("TestName", "TestEmail", 20));
        customerDao.save(new Customer("TestName", "TestEmail", 20));
        customerDao.save(new Customer("TestName", "TestEmail", 20));

        Assertions.assertTrue(customerDao.findAll().size() == 3);

    }

    @Test
    public void saveTest() {
        Assertions.assertTrue(customerDao.findAll().isEmpty());

        customerDao.save(Mockito.mock(Customer.class));

        Assertions.assertFalse(customerDao.findAll().isEmpty());

    }

    @Test
    public void saveAllTest() {
        Assertions.assertTrue(customerDao.findAll().isEmpty());

        List<Customer> testList = new ArrayList<>();

        testList.add(Mockito.mock(Customer.class));
        testList.add(Mockito.mock(Customer.class));
        testList.add(Mockito.mock(Customer.class));
        testList.add(Mockito.mock(Customer.class));

        customerDao.saveAll(testList);

        Assertions.assertTrue(customerDao.findAll().size() == 4);

    }

    @Test
    public void deleteTest() {
        Assertions.assertTrue(customerDao.findAll().isEmpty());

        Customer testCustomer = Mockito.mock(Customer.class);

        customerDao.save(testCustomer);

        customerDao.delete(testCustomer);

        Assertions.assertTrue(customerDao.findAll().isEmpty());

    }

    @Test
    public void deleteAllTest() {
        Assertions.assertTrue(customerDao.findAll().isEmpty());

        List<Customer> testList = new ArrayList<>();

        Customer testCustomer = Mockito.mock(Customer.class);
        Customer testCustomer1 = Mockito.mock(Customer.class);
        Customer testCustomer2 = Mockito.mock(Customer.class);

        testList.add(testCustomer);
        testList.add(testCustomer1);
        testList.add(testCustomer2);

        customerDao.saveAll(testList);

        customerDao.deleteAll(testList);

        Assertions.assertTrue(customerDao.findAll().isEmpty());

    }

    @Test
    public void deleteByIdTest() {
        Assertions.assertTrue(customerDao.findAll().isEmpty());

        Customer testCustomer = Mockito.mock(Customer.class);

        Long testId = testCustomer.getId();

        customerDao.save(testCustomer);

        customerDao.deleteById(testId);

        Assertions.assertTrue(customerDao.findAll().isEmpty());

    }

    @Test
    public void findByIdTest() {
        Assertions.assertTrue(customerDao.findAll().isEmpty());

        Customer testCustomer = Mockito.mock(Customer.class);

        Long testId = testCustomer.getId();

        customerDao.save(testCustomer);

        Assertions.assertEquals(customerDao.findById(testId), testCustomer);

    }

}