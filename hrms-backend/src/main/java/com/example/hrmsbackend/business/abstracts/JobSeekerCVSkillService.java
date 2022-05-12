package com.example.hrmsbackend.business.abstracts;

import com.example.hrmsbackend.core.business.abstracts.BaseService;
import com.example.hrmsbackend.core.utilities.results.DataResult;
import com.example.hrmsbackend.entities.concretes.JobSeekerCVSkill;

import java.util.List;

public interface JobSeekerCVSkillService extends BaseService<JobSeekerCVSkill, Integer> {
	DataResult<List<JobSeekerCVSkill>> getAllByJobSeekerCV_Id(int jobSeekerCVId);
}
