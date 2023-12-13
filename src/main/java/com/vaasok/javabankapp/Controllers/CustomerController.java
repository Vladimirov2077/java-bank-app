package com.vaasok.javabankapp.Controllers;

import com.vaasok.javabankapp.Models.Account;
import com.vaasok.javabankapp.Models.Currency;
import com.vaasok.javabankapp.Models.Customer;
import com.vaasok.javabankapp.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/create")
    public Customer createCustomer(@RequestParam String name, @RequestParam String email, @RequestParam Integer age) {
        return customerService.createCustomer(name, email, age);
    }

    @GetMapping("/all")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteCustomer(@PathVariable Long id) {
        return customerService.deleteCustomerById(id);
    }

    @PutMapping("/update/{id}")
    public void updateCustomer(
            @PathVariable Long id,
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam Integer age
    ) {
        customerService.updateCustomer(id, name, email, age);
    }

}
