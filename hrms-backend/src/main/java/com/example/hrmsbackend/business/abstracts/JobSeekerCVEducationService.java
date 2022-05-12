package com.example.hrmsbackend.business.abstracts;

import com.example.hrmsbackend.core.business.abstracts.BaseService;
import com.example.hrmsbackend.core.utilities.results.DataResult;
import com.example.hrmsbackend.entities.concretes.JobSeekerCVEducation;
import org.springframework.data.domain.Sort.Direction;

import java.util.List;

public interface JobSeekerCVEducationService extends BaseService<JobSeekerCVEducation, Integer> {
	DataResult<List<JobSeekerCVEducation>> getAllByJobSeekerCV_Id(int jobSeekerCVId);

	DataResult<List<JobSeekerCVEducation>> getAllByJobSeekerCV_IdOrderByGraduationDate(int jobSeekerCVId,
			Direction direction);
}
