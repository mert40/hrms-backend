package com.example.hrmsbackend.business.concretes;

import com.example.hrmsbackend.business.abstracts.JobPositionService;
import com.example.hrmsbackend.core.business.abstracts.BaseManager;
import com.example.hrmsbackend.core.business.constants.Messages;
import com.example.hrmsbackend.core.utilities.business.BusinessRules;
import com.example.hrmsbackend.core.utilities.results.ErrorResult;
import com.example.hrmsbackend.core.utilities.results.Result;
import com.example.hrmsbackend.core.utilities.results.SuccessResult;
import com.example.hrmsbackend.dataAccess.abstracts.JobPositionDao;
import com.example.hrmsbackend.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobPositionManager extends BaseManager<JobPositionDao, JobPosition, Integer>
		implements JobPositionService {
	private final JobPositionDao jobPositionDao;

	@Autowired
	public JobPositionManager(final JobPositionDao jobPositionDao) {
		super(jobPositionDao, "Job position");
		this.jobPositionDao = jobPositionDao;
	}

	@Override
	public Result add(final JobPosition jobPosition) {
		final Result businessRulesResult = BusinessRules.run(isNotExistsJobPosition(jobPosition.getTitle()));
		if (!businessRulesResult.isSuccess())
			return businessRulesResult;

		jobPositionDao.save(jobPosition);

		return new SuccessResult(Messages.added("Job position"));
	}

	@Override
	public Result isNotExistsJobPosition(final String title) {
		return jobPositionDao.findByTitle(title).isEmpty() ? new SuccessResult()
				: new ErrorResult(Messages.alreadyExists("Job position with title"));
	}
}
