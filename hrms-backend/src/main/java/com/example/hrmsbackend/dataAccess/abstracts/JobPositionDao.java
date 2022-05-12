package com.example.hrmsbackend.dataAccess.abstracts;

import com.example.hrmsbackend.entities.concretes.JobPosition;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JobPositionDao extends JpaRepository<JobPosition, Integer> {
	Optional<JobPosition> findByTitle(String title);
}
