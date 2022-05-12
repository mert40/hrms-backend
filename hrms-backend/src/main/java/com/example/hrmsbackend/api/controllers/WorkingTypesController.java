package com.example.hrmsbackend.api.controllers;

import com.example.hrmsbackend.business.abstracts.WorkingTypeService;
import com.example.hrmsbackend.core.api.abstracts.BaseController;
import com.example.hrmsbackend.entities.concretes.WorkingType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/workingtypes")
public class WorkingTypesController extends BaseController<WorkingTypeService, WorkingType, Short> {
	public WorkingTypesController(final WorkingTypeService workingTypeService) {
		super(workingTypeService);
	}
}
