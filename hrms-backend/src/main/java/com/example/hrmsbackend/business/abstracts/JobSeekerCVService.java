package com.example.hrmsbackend.business.abstracts;

import com.example.hrmsbackend.core.business.abstracts.BaseService;
import com.example.hrmsbackend.core.utilities.results.DataResult;
import com.example.hrmsbackend.entities.concretes.JobSeekerCV;

public interface JobSeekerCVService extends BaseService<JobSeekerCV, Integer> {
	DataResult<JobSeekerCV> getByJobSeeker_Id(int jobSeekerId);
}
