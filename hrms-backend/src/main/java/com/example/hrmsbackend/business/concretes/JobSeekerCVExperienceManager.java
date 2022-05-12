package com.example.hrmsbackend.business.concretes;

import com.example.hrmsbackend.business.abstracts.JobSeekerCVExperienceService;
import com.example.hrmsbackend.core.business.abstracts.BaseManager;
import com.example.hrmsbackend.core.utilities.results.DataResult;
import com.example.hrmsbackend.core.utilities.results.SuccessDataResult;
import com.example.hrmsbackend.dataAccess.abstracts.JobSeekerCVExperienceDao;
import com.example.hrmsbackend.entities.concretes.JobSeekerCVExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobSeekerCVExperienceManager extends BaseManager<JobSeekerCVExperienceDao, JobSeekerCVExperience, Integer>
		implements JobSeekerCVExperienceService {
	private final JobSeekerCVExperienceDao jobSeekerCVExperienceDao;

	@Autowired
	public JobSeekerCVExperienceManager(final JobSeekerCVExperienceDao jobSeekerCVExperienceDao) {
		super(jobSeekerCVExperienceDao, "Job seeker CV experience");
		this.jobSeekerCVExperienceDao = jobSeekerCVExperienceDao;
	}

	@Override
	public DataResult<List<JobSeekerCVExperience>> getAllByJobSeekerCV_Id(final int jobSeekerCVId) {
		final List<JobSeekerCVExperience> jobSeekerCVExperiences = jobSeekerCVExperienceDao
				.findAllByJobSeekerCV_Id(jobSeekerCVId);

		return new SuccessDataResult<>(jobSeekerCVExperiences);
	}

	@Override
	public DataResult<List<JobSeekerCVExperience>> getAllByJobSeekerCV_IdOrderByQuitDate(final int jobSeekerCVId,
			final Direction direction) {
		final List<JobSeekerCVExperience> jobSeekerEducations = direction.isAscending()
				? jobSeekerCVExperienceDao.findAllByJobSeekerCV_IdOrderByQuitDate(jobSeekerCVId)
				: jobSeekerCVExperienceDao.findAllByJobSeekerCV_IdOrderByQuitDateDesc(jobSeekerCVId);

		return new SuccessDataResult<>(jobSeekerEducations);
	}

}
