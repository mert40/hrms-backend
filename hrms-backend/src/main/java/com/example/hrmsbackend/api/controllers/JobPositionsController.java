package com.example.hrmsbackend.api.controllers;

import com.example.hrmsbackend.business.abstracts.JobPositionService;
import com.example.hrmsbackend.core.api.abstracts.BaseController;
import com.example.hrmsbackend.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/jobpositions")
public class JobPositionsController extends BaseController<JobPositionService, JobPosition, Integer> {
	@Autowired
	public JobPositionsController(final JobPositionService jobPositionService) {
		super(jobPositionService);
	}
}