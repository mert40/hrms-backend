package com.example.hrmsbackend.dataAccess.abstracts;

import com.example.hrmsbackend.entities.concretes.JobSeekerCV;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JobSeekerCVDao extends JpaRepository<JobSeekerCV, Integer> {
	Optional<JobSeekerCV> findByJobSeeker_Id(int jobSeekerId);
}
