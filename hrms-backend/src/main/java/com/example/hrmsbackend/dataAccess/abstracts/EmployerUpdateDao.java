package com.example.hrmsbackend.dataAccess.abstracts;

import com.example.hrmsbackend.entities.concretes.EmployerUpdate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployerUpdateDao extends JpaRepository<EmployerUpdate, Integer> {
	List<EmployerUpdate> findAllByEmployer_IdOrderByUpdatedAtDesc(int employerId);

	List<EmployerUpdate> findAllByIsApprovedAndIsDeleted(boolean isApproved, boolean isDeleted);
}
