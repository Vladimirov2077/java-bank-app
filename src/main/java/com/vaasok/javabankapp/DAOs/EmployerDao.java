package com.vaasok.javabankapp.DAOs;

import com.vaasok.javabankapp.Models.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployerDao extends JpaRepository<Employer, Long> {
    // Custom queries if needed
}