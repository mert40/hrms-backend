package com.example.hrmsbackend.business.concretes;

import com.example.hrmsbackend.business.abstracts.WorkingTypeService;
import com.example.hrmsbackend.core.business.abstracts.BaseManager;
import com.example.hrmsbackend.dataAccess.abstracts.WorkingTypeDao;
import com.example.hrmsbackend.entities.concretes.WorkingType;
import org.springframework.stereotype.Service;

@Service
public class WorkingTypeManager extends BaseManager<WorkingTypeDao, WorkingType, Short> implements WorkingTypeService {
	public WorkingTypeManager(final WorkingTypeDao workingTypeDao) {
		super(workingTypeDao, "Working type");
	}
}
