package com.vaasok.javabankapp.Services;

import com.vaasok.javabankapp.DAOs.EmployerDao;
import com.vaasok.javabankapp.Models.Employer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerService {

    private final EmployerDao employerDao;

    public EmployerService(EmployerDao employerDao) {
        this.employerDao = employerDao;
    }

    public List<Employer> getAllEmployers() {
        return employerDao.findAll();
    }
}
