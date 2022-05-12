package com.example.hrmsbackend.dataAccess.abstracts;

import com.example.hrmsbackend.entities.concretes.CompanyStaffVerification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyStaffVerificationDao extends JpaRepository<CompanyStaffVerification, Integer> {
	Optional<CompanyStaffVerification> findByUser_Id(int userId);
}
