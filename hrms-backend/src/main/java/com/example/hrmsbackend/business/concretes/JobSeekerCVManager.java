package com.example.hrmsbackend.business.concretes;

import com.example.hrmsbackend.business.abstracts.JobSeekerCVService;
import com.example.hrmsbackend.core.business.abstracts.BaseManager;
import com.example.hrmsbackend.core.business.constants.Messages;
import com.example.hrmsbackend.core.utilities.results.DataResult;
import com.example.hrmsbackend.core.utilities.results.ErrorDataResult;
import com.example.hrmsbackend.core.utilities.results.SuccessDataResult;
import com.example.hrmsbackend.dataAccess.abstracts.JobSeekerCVDao;
import com.example.hrmsbackend.entities.concretes.JobSeekerCV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JobSeekerCVManager extends BaseManager<JobSeekerCVDao, JobSeekerCV, Integer>
		implements JobSeekerCVService {
	private final JobSeekerCVDao jobSeekerCVDao;

	@Autowired
	public JobSeekerCVManager(final JobSeekerCVDao jobSeekerCVDao) {
		super(jobSeekerCVDao, "Job seeker CV");
		this.jobSeekerCVDao = jobSeekerCVDao;
	}

	@Override
	public DataResult<JobSeekerCV> getByJobSeeker_Id(final int jobSeekerId) {
		final Optional<JobSeekerCV> jobSeekerCV = jobSeekerCVDao.findByJobSeeker_Id(jobSeekerId);

		if (jobSeekerCV.isEmpty())
			return new ErrorDataResult<>(Messages.notFound("Job seeker"));

		return new SuccessDataResult<>(jobSeekerCV.get());
	}

}
