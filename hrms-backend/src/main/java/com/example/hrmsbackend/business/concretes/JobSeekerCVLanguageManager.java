package com.example.hrmsbackend.business.concretes;

import com.example.hrmsbackend.business.abstracts.JobSeekerCVLanguageService;
import com.example.hrmsbackend.core.business.abstracts.BaseManager;
import com.example.hrmsbackend.core.utilities.results.DataResult;
import com.example.hrmsbackend.core.utilities.results.SuccessDataResult;
import com.example.hrmsbackend.dataAccess.abstracts.JobSeekerCVLanguageDao;
import com.example.hrmsbackend.entities.concretes.JobSeekerCVLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobSeekerCVLanguageManager extends BaseManager<JobSeekerCVLanguageDao, JobSeekerCVLanguage, Integer>
		implements JobSeekerCVLanguageService {
	private final JobSeekerCVLanguageDao jobSeekerCVLanguageDao;

	@Autowired
	public JobSeekerCVLanguageManager(final JobSeekerCVLanguageDao jobSeekerCVLanguageDao) {
		super(jobSeekerCVLanguageDao, "Job seeker CV language");
		this.jobSeekerCVLanguageDao = jobSeekerCVLanguageDao;
	}

	@Override
	public DataResult<List<JobSeekerCVLanguage>> getAllByJobSeekerCV_Id(final int jobSeekerCVId) {
		final List<JobSeekerCVLanguage> jobSeekerCVLanguages = jobSeekerCVLanguageDao
				.findAllByJobSeekerCV_Id(jobSeekerCVId);

		return new SuccessDataResult<>(jobSeekerCVLanguages);
	}

}