package com.example.hrmsbackend.dataAccess.abstracts;

import com.example.hrmsbackend.entities.concretes.JobSeekerCVEducation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobSeekerCVEducationDao extends JpaRepository<JobSeekerCVEducation, Integer> {
	List<JobSeekerCVEducation> findAllByJobSeekerCV_Id(int jobSeekerId);

	List<JobSeekerCVEducation> findAllByJobSeekerCV_IdOrderByGraduationDate(int jobSeekerCVId);

	List<JobSeekerCVEducation> findAllByJobSeekerCV_IdOrderByGraduationDateDesc(int jobSeekerCVId);
}
