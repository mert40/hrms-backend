package com.example.hrmsbackend.business.abstracts;

import com.example.hrmsbackend.core.business.abstracts.BaseService;
import com.example.hrmsbackend.core.utilities.results.DataResult;
import com.example.hrmsbackend.entities.concretes.JobSeekerCVWebSite;

import java.util.List;

public interface JobSeekerCVWebSiteService extends BaseService<JobSeekerCVWebSite, Integer> {
	DataResult<List<JobSeekerCVWebSite>> getAllByJobSeekerCV_Id(int jobSeekerCVId);
}
