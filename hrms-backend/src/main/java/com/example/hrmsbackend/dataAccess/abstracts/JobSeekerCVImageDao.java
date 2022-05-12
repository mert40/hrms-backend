package com.example.hrmsbackend.dataAccess.abstracts;

import com.example.hrmsbackend.entities.concretes.JobSeekerCVImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobSeekerCVImageDao extends JpaRepository<JobSeekerCVImage, Integer> {
	List<JobSeekerCVImage> findAllByJobSeekerCV_Id(int jobSeekerCVId);
}
