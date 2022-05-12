package com.example.hrmsbackend.business.abstracts;

import com.example.hrmsbackend.core.business.abstracts.BaseService;
import com.example.hrmsbackend.core.utilities.results.DataResult;
import com.example.hrmsbackend.core.utilities.results.Result;
import com.example.hrmsbackend.entities.concretes.JobAdvert;
import com.example.hrmsbackend.entities.dtos.JobAdvertForListDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

public interface JobAdvertService extends BaseService<JobAdvert, Integer> {
	Result verifyById(int id);

	DataResult<Page<JobAdvert>> getAllByIsActive(boolean isActive, int page, int size, String[] sortProperties,
			Sort.Direction sortDirection);

	DataResult<Page<JobAdvertForListDto>> getAllByIsActiveAndEmployer_CompanyNameForList(boolean isActive,
			String companyName, int page, int size, String[] sortProperties, Sort.Direction sortDirection);

	DataResult<Page<JobAdvertForListDto>> getAllByIsActiveForList(boolean isActive, int page, int size,
			String[] sortProperties, Sort.Direction sortDirection);

	DataResult<Page<JobAdvertForListDto>> getAllByIsActiveAndCityAndWorkingTimeForList(boolean isActive, short cityId,
			short workingTimeId, int page, int size, String[] sortProperties, Sort.Direction sortDirection);
}
