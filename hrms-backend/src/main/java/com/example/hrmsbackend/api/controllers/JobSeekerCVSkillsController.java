package com.example.hrmsbackend.api.controllers;

import com.example.hrmsbackend.business.abstracts.JobSeekerCVSkillService;
import com.example.hrmsbackend.core.api.abstracts.BaseController;
import com.example.hrmsbackend.core.utilities.results.DataResult;
import com.example.hrmsbackend.entities.concretes.JobSeekerCVSkill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/jobseekers/cvs/skills")
public class JobSeekerCVSkillsController extends BaseController<JobSeekerCVSkillService, JobSeekerCVSkill, Integer> {
	private final JobSeekerCVSkillService jobSeekerCVSkillService;

	@Autowired
	public JobSeekerCVSkillsController(final JobSeekerCVSkillService jobSeekerCVSkillService) {
		super(jobSeekerCVSkillService);
		this.jobSeekerCVSkillService = jobSeekerCVSkillService;
	}

	@GetMapping("/byjobseekercvid")
	public ResponseEntity<DataResult<List<JobSeekerCVSkill>>> getAllByJobSeekerCV_Id(final int jobSeekerCVId) {
		final DataResult<List<JobSeekerCVSkill>> result = jobSeekerCVSkillService.getAllByJobSeekerCV_Id(jobSeekerCVId);

		return ResponseEntity.ok(result);
	}
}
