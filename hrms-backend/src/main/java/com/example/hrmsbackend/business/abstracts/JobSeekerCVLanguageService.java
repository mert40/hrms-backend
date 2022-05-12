package com.example.hrmsbackend.business.abstracts;

import com.example.hrmsbackend.core.business.abstracts.BaseService;
import com.example.hrmsbackend.core.utilities.results.DataResult;
import com.example.hrmsbackend.entities.concretes.JobSeekerCVLanguage;

import java.util.List;

public interface JobSeekerCVLanguageService extends BaseService<JobSeekerCVLanguage, Integer> {
	DataResult<List<JobSeekerCVLanguage>> getAllByJobSeekerCV_Id(int jobSeekerCVId);
}
