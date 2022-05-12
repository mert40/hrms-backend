package com.example.hrmsbackend.dataAccess.abstracts;

import com.example.hrmsbackend.entities.concretes.JobSeekerCVWebSite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobSeekerCVWebSiteDao extends JpaRepository<JobSeekerCVWebSite, Integer> {
	List<JobSeekerCVWebSite> findAllByJobSeekerCV_Id(int jobSeekerCVId);
}
