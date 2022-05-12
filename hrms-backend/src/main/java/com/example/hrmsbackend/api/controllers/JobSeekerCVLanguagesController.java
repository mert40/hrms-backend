package com.example.hrmsbackend.api.controllers;

import com.example.hrmsbackend.business.abstracts.JobSeekerCVLanguageService;
import com.example.hrmsbackend.core.api.abstracts.BaseController;
import com.example.hrmsbackend.core.utilities.results.DataResult;
import com.example.hrmsbackend.entities.concretes.JobSeekerCVLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/jobseekers/cvs/languages")
public class JobSeekerCVLanguagesController
		extends BaseController<JobSeekerCVLanguageService, JobSeekerCVLanguage, Integer> {
	private final JobSeekerCVLanguageService jobSeekerCVLanguageService;

	@Autowired
	public JobSeekerCVLanguagesController(final JobSeekerCVLanguageService jobSeekerCVLanguageService) {
		super(jobSeekerCVLanguageService);
		this.jobSeekerCVLanguageService = jobSeekerCVLanguageService;
	}

	@GetMapping("/byjobseekercvid")
	public ResponseEntity<DataResult<List<JobSeekerCVLanguage>>> getAllByJobSeekerCV_Id(final int jobSeekerCVId) {
		final DataResult<List<JobSeekerCVLanguage>> result = jobSeekerCVLanguageService
				.getAllByJobSeekerCV_Id(jobSeekerCVId);

		return ResponseEntity.ok(result);
	}

}
