package com.example.hrmsbackend.business.concretes;

import com.example.hrmsbackend.business.abstracts.WorkingTimeService;
import com.example.hrmsbackend.core.business.abstracts.BaseManager;
import com.example.hrmsbackend.dataAccess.abstracts.WorkingTimeDao;
import com.example.hrmsbackend.entities.concretes.WorkingTime;
import org.springframework.stereotype.Service;

@Service
public class WorkingTimeManager extends BaseManager<WorkingTimeDao, WorkingTime, Short> implements WorkingTimeService {
	public WorkingTimeManager(final WorkingTimeDao workingTimeDao) {
		super(workingTimeDao, "Working time");
	}
}
