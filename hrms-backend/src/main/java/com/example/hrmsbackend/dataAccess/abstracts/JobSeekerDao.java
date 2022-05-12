package com.example.hrmsbackend.dataAccess.abstracts;

import com.example.hrmsbackend.entities.concretes.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JobSeekerDao extends JpaRepository<JobSeeker, Integer> {
	Optional<JobSeeker> findByIdentityNumber(String identityNumber);
}
