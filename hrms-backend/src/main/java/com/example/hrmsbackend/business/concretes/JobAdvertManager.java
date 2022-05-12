package com.example.hrmsbackend.business.concretes;

import com.example.hrmsbackend.business.abstracts.JobAdvertService;
import com.example.hrmsbackend.core.business.abstracts.BaseManager;
import com.example.hrmsbackend.core.business.constants.Messages;
import com.example.hrmsbackend.core.utilities.results.DataResult;
import com.example.hrmsbackend.core.utilities.results.ErrorDataResult;
import com.example.hrmsbackend.core.utilities.results.Result;
import com.example.hrmsbackend.core.utilities.results.SuccessDataResult;
import com.example.hrmsbackend.dataAccess.abstracts.JobAdvertDao;
import com.example.hrmsbackend.entities.concretes.JobAdvert;
import com.example.hrmsbackend.entities.dtos.JobAdvertForListDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JobAdvertManager extends BaseManager<JobAdvertDao, JobAdvert, Integer> implements JobAdvertService {
	private final JobAdvertDao jobAdvertDao;

	@Autowired
	public JobAdvertManager(final JobAdvertDao jobAdvertDao) {
		super(jobAdvertDao, "Job advert");
		this.jobAdvertDao = jobAdvertDao;
	}

	public Result verifyById(final int id) {
		Optional<JobAdvert> jobAdvert = this.jobAdvertDao.findById(id);
		if (jobAdvert.isEmpty())
			return new ErrorDataResult(Messages.notFound("Job advert"));

		jobAdvert.get().setActive(true);

		return super.update(jobAdvert.get());
	}

	public DataResult<Page<JobAdvert>> getAllByIsActive(final boolean isActive, int page, int size,
			String[] sortProperties, Sort.Direction sortDirection) {
		Page<JobAdvert> jobAdverts = jobAdvertDao.findAllByIsActive(isActive,
				PageRequest.of(page, size, Sort.by(sortDirection, sortProperties)));

		return new SuccessDataResult<>(jobAdverts);
	}

	public DataResult<Page<JobAdvertForListDto>> getAllByIsActiveAndEmployer_CompanyNameForList(final boolean isActive,
			final String companyName, int page, int size, String[] sortProperties, Sort.Direction sortDirection) {
		Page<JobAdvertForListDto> jobAdvertForListDtos = jobAdvertDao.findAllByIsActiveAndEmployer_CompanyNameForList(
				isActive,
				companyName,
				PageRequest.of(page, size, Sort.by(sortDirection, sortProperties)));

		return new SuccessDataResult<>(jobAdvertForListDtos);
	}

	public DataResult<Page<JobAdvertForListDto>> getAllByIsActiveForList(final boolean isActive, final int page,
			final int size, final String[] sortProperties, final Sort.Direction sortDirection) {
		Page<JobAdvertForListDto> jobAdvertForListDtos = jobAdvertDao.findAllByIsActiveForList(isActive,
				PageRequest.of(page, size, Sort.by(sortDirection, sortProperties)));

		return new SuccessDataResult<>(jobAdvertForListDtos);
	}

	public DataResult<Page<JobAdvertForListDto>> getAllByIsActiveAndCityAndWorkingTimeForList(final boolean isActive,
			final short cityId, final short workingTimeId, int page, int size, String[] sortProperties,
			Sort.Direction sortDirection) {
		Page<JobAdvertForListDto> jobAdvertForListDtos = jobAdvertDao.findAllByIsActiveAndCityAndWorkingTimeForList(
				isActive,
				cityId,
				workingTimeId,
				PageRequest.of(page, size, Sort.by(sortDirection, sortProperties)));

		return new SuccessDataResult<>(jobAdvertForListDtos);
	}
}
