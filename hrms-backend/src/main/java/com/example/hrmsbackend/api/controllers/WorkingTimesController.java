package com.example.hrmsbackend.api.controllers;

import com.example.hrmsbackend.business.abstracts.WorkingTimeService;
import com.example.hrmsbackend.core.api.abstracts.BaseController;
import com.example.hrmsbackend.entities.concretes.WorkingTime;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/workingtimes")
public class WorkingTimesController extends BaseController<WorkingTimeService, WorkingTime, Short> {
	public WorkingTimesController(final WorkingTimeService workingTimeService) {
		super(workingTimeService);
	}
}
