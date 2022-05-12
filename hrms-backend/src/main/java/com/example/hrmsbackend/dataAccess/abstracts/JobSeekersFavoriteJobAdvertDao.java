package com.example.hrmsbackend.dataAccess.abstracts;

import com.example.hrmsbackend.entities.concretes.JobSeekersFavoriteJobAdvert;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JobSeekersFavoriteJobAdvertDao extends JpaRepository<JobSeekersFavoriteJobAdvert, Integer> {
	Optional<JobSeekersFavoriteJobAdvert> findByJobSeeker_IdAndJobAdvert_Id(int jobSeekerId, int jobAdvertId);
}
