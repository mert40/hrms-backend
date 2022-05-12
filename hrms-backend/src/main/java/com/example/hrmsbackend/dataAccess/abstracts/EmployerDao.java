package com.example.hrmsbackend.dataAccess.abstracts;

import com.example.hrmsbackend.entities.concretes.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployerDao extends JpaRepository<Employer, Integer> {
	Optional<Employer> findByCorporateEmail(String corporateEmail);
}
