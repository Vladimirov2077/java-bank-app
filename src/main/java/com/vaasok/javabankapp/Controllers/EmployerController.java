package com.vaasok.javabankapp.Controllers;

import com.vaasok.javabankapp.Models.Employer;
import com.vaasok.javabankapp.Services.EmployerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employers")
public class EmployerController {


    private final EmployerService employerService;

    public EmployerController(EmployerService employerService) {
        this.employerService = employerService;
    }

    @GetMapping("/all")
    public List<Employer> getAllEmployers() {
        return employerService.getAllEmployers();
    }
}
