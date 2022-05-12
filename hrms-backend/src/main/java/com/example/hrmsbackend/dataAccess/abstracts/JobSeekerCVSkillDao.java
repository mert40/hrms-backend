package com.example.hrmsbackend.dataAccess.abstracts;

import com.example.hrmsbackend.entities.concretes.JobSeekerCVSkill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobSeekerCVSkillDao extends JpaRepository<JobSeekerCVSkill, Integer> {
	List<JobSeekerCVSkill> findAllByJobSeekerCV_Id(int jobSeekerCVId);
}
