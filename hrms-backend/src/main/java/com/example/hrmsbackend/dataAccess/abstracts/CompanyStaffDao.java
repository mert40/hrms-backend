package com.example.hrmsbackend.dataAccess.abstracts;

import com.example.hrmsbackend.entities.concretes.CompanyStaff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyStaffDao extends JpaRepository<CompanyStaff, Integer> {
}
