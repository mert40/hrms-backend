package com.example.hrmsbackend.api.controllers;

import com.example.hrmsbackend.business.abstracts.JobSeekerCVWebSiteService;
import com.example.hrmsbackend.core.api.abstracts.BaseController;
import com.example.hrmsbackend.core.utilities.results.DataResult;
import com.example.hrmsbackend.entities.concretes.JobSeekerCVWebSite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/jobseekers/cvs/websites")
public class JobSeekerCVWebSitesController
		extends BaseController<JobSeekerCVWebSiteService, JobSeekerCVWebSite, Integer> {
	private final JobSeekerCVWebSiteService jobSeekerCVWebSiteService;

	@Autowired
	public JobSeekerCVWebSitesController(final JobSeekerCVWebSiteService jobSeekerCVWebSiteService) {
		super(jobSeekerCVWebSiteService);
		this.jobSeekerCVWebSiteService = jobSeekerCVWebSiteService;
	}

	@GetMapping("/byjobseekercvid")
	public ResponseEntity<DataResult<List<JobSeekerCVWebSite>>> getAllByJobSeekerCV_Id(final int jobSeekerCVId) {
		final DataResult<List<JobSeekerCVWebSite>> result = jobSeekerCVWebSiteService
				.getAllByJobSeekerCV_Id(jobSeekerCVId);

		return ResponseEntity.ok(result);
	}
}
