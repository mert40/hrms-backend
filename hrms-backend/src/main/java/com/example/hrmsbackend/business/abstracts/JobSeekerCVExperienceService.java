package com.example.hrmsbackend.business.abstracts;

import com.example.hrmsbackend.core.business.abstracts.BaseService;
import com.example.hrmsbackend.core.utilities.results.DataResult;
import com.example.hrmsbackend.entities.concretes.JobSeekerCVExperience;
import org.springframework.data.domain.Sort.Direction;

import java.util.List;

public interface JobSeekerCVExperienceService extends BaseService<JobSeekerCVExperience, Integer> {
	DataResult<List<JobSeekerCVExperience>> getAllByJobSeekerCV_Id(int jobSeekerCVId);

	DataResult<List<JobSeekerCVExperience>> getAllByJobSeekerCV_IdOrderByQuitDate(int jobSeekerCVId,
			Direction direction);
}
