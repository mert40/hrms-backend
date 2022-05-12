package com.example.hrmsbackend.business.concretes;

import com.example.hrmsbackend.business.abstracts.JobSeekerCVEducationService;
import com.example.hrmsbackend.core.business.abstracts.BaseManager;
import com.example.hrmsbackend.core.utilities.results.DataResult;
import com.example.hrmsbackend.core.utilities.results.SuccessDataResult;
import com.example.hrmsbackend.dataAccess.abstracts.JobSeekerCVEducationDao;
import com.example.hrmsbackend.entities.concretes.JobSeekerCVEducation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobSeekerCVEducationManager extends BaseManager<JobSeekerCVEducationDao, JobSeekerCVEducation, Integer>
		implements JobSeekerCVEducationService {
	private final JobSeekerCVEducationDao jobSeekerCVEducationDao;

	@Autowired
	public JobSeekerCVEducationManager(final JobSeekerCVEducationDao jobSeekerCVEducationDao) {
		super(jobSeekerCVEducationDao, "Job seeker CV education");
		this.jobSeekerCVEducationDao = jobSeekerCVEducationDao;
	}

	@Override
	public DataResult<List<JobSeekerCVEducation>> getAllByJobSeekerCV_Id(final int jobSeekerCVId) {
		final List<JobSeekerCVEducation> jobSeekerCVEducations = jobSeekerCVEducationDao
				.findAllByJobSeekerCV_Id(jobSeekerCVId);

		return new SuccessDataResult<>(jobSeekerCVEducations);
	}

	@Override
	public DataResult<List<JobSeekerCVEducation>> getAllByJobSeekerCV_IdOrderByGraduationDate(final int jobSeekerCVId,
			final Direction direction) {
		final List<JobSeekerCVEducation> jobSeekerCVEducations = direction.isAscending()
				? jobSeekerCVEducationDao.findAllByJobSeekerCV_IdOrderByGraduationDate(jobSeekerCVId)
				: jobSeekerCVEducationDao.findAllByJobSeekerCV_IdOrderByGraduationDateDesc(jobSeekerCVId);

		return new SuccessDataResult<>(jobSeekerCVEducations);
	}

}
