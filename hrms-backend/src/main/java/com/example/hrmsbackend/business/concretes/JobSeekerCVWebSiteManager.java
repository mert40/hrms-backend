package com.example.hrmsbackend.business.concretes;

import com.example.hrmsbackend.business.abstracts.JobSeekerCVWebSiteService;
import com.example.hrmsbackend.core.business.abstracts.BaseManager;
import com.example.hrmsbackend.core.utilities.results.DataResult;
import com.example.hrmsbackend.core.utilities.results.SuccessDataResult;
import com.example.hrmsbackend.dataAccess.abstracts.JobSeekerCVWebSiteDao;
import com.example.hrmsbackend.entities.concretes.JobSeekerCVWebSite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobSeekerCVWebSiteManager extends BaseManager<JobSeekerCVWebSiteDao, JobSeekerCVWebSite, Integer>
		implements JobSeekerCVWebSiteService {
	private final JobSeekerCVWebSiteDao jobSeekerCVWebSiteDao;

	@Autowired
	public JobSeekerCVWebSiteManager(final JobSeekerCVWebSiteDao jobSeekerCVWebSiteDao) {
		super(jobSeekerCVWebSiteDao, "Job seeker CV webSite");
		this.jobSeekerCVWebSiteDao = jobSeekerCVWebSiteDao;
	}

	@Override
	public DataResult<List<JobSeekerCVWebSite>> getAllByJobSeekerCV_Id(final int jobSeekerCVId) {
		final List<JobSeekerCVWebSite> jobSeekerCVWebSites = jobSeekerCVWebSiteDao
				.findAllByJobSeekerCV_Id(jobSeekerCVId);

		return new SuccessDataResult<>(jobSeekerCVWebSites);
	}

}
