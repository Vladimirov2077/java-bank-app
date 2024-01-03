package com.vaasok.javabankapp.Controllers;

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

    @PostMapping("/delete")
    public String deleteCustomer(@RequestParam Long id) {

        boolean b = customerService.deleteCustomerById(id);

        if (b) {
            return "Customer with id " + id + " was deleted";
        } else {
            return "Customer with id " + id + " was not deleted";
        }

    }

    @PostMapping("/update")
    public Customer updateCustomer(
            @RequestParam Long id,
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam Integer age
    ) {

        return customerService.updateCustomer(id, name, email, age);

    }


}
