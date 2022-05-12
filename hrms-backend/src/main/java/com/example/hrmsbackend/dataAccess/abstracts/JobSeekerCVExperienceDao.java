package com.example.hrmsbackend.dataAccess.abstracts;

import com.example.hrmsbackend.entities.concretes.JobSeekerCVExperience;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobSeekerCVExperienceDao extends JpaRepository<JobSeekerCVExperience, Integer> {
	List<JobSeekerCVExperience> findAllByJobSeekerCV_Id(int jobSeekerCVId);

	List<JobSeekerCVExperience> findAllByJobSeekerCV_IdOrderByQuitDate(int jobSeekerCVId);

	List<JobSeekerCVExperience> findAllByJobSeekerCV_IdOrderByQuitDateDesc(int jobSeekerCVId);
}
