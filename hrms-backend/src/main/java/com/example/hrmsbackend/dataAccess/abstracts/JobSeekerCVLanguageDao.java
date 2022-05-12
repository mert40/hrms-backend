package com.example.hrmsbackend.dataAccess.abstracts;

import com.example.hrmsbackend.entities.concretes.JobSeekerCVLanguage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobSeekerCVLanguageDao extends JpaRepository<JobSeekerCVLanguage, Integer> {
	List<JobSeekerCVLanguage> findAllByJobSeekerCV_Id(int jobSeekerCVId);
}
