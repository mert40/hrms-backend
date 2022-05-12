package com.example.hrmsbackend.business.abstracts;

import com.example.hrmsbackend.core.business.abstracts.BaseService;
import com.example.hrmsbackend.core.utilities.results.Result;
import com.example.hrmsbackend.entities.concretes.JobPosition;

public interface JobPositionService extends BaseService<JobPosition, Integer> {
	Result isNotExistsJobPosition(final String title);
}
