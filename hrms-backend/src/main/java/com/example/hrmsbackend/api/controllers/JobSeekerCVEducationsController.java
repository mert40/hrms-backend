package com.example.hrmsbackend.api.controllers;

import com.example.hrmsbackend.business.abstracts.JobSeekerCVEducationService;
import com.example.hrmsbackend.core.api.abstracts.BaseController;
import com.example.hrmsbackend.core.utilities.results.DataResult;
import com.example.hrmsbackend.entities.concretes.JobSeekerCVEducation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/jobseekers/cvs/educations")
public class JobSeekerCVEducationsController
		extends BaseController<JobSeekerCVEducationService, JobSeekerCVEducation, Integer> {
	private final JobSeekerCVEducationService jobSeekerCVEducationService;

	@Autowired
	public JobSeekerCVEducationsController(final JobSeekerCVEducationService jobSeekerCVEducationService) {
		super(jobSeekerCVEducationService);
		this.jobSeekerCVEducationService = jobSeekerCVEducationService;
	}

	@GetMapping("/byjobseekercvid")
	public ResponseEntity<DataResult<List<JobSeekerCVEducation>>> getAllByJobSeekerCV_Id(final int jobSeekerCVId) {
		final DataResult<List<JobSeekerCVEducation>> result = jobSeekerCVEducationService
				.getAllByJobSeekerCV_Id(jobSeekerCVId);

		return ResponseEntity.ok(result);
	}

	@GetMapping("/byjobseekercvidorderbygraduationdate")
	public ResponseEntity<DataResult<List<JobSeekerCVEducation>>> getAllByJobSeekerCV_IdOrderByGraduationDate(
			@RequestParam final int jobSeekerCVId, @RequestParam final Direction direction) {
		final DataResult<List<JobSeekerCVEducation>> result = jobSeekerCVEducationService
				.getAllByJobSeekerCV_IdOrderByGraduationDate(jobSeekerCVId, direction);

		return ResponseEntity.ok(result);
	}
}
