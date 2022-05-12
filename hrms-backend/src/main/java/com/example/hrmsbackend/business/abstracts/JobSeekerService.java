package com.example.hrmsbackend.business.abstracts;

import com.example.hrmsbackend.core.business.abstracts.BaseService;
import com.example.hrmsbackend.core.utilities.results.DataResult;
import com.example.hrmsbackend.core.utilities.results.Result;
import com.example.hrmsbackend.entities.concretes.JobSeeker;
import com.example.hrmsbackend.entities.concretes.JobSeekersFavoriteJobAdvert;
import com.example.hrmsbackend.entities.dtos.JobSeekerForRegisterDto;

public interface JobSeekerService extends BaseService<JobSeeker, Integer> {
	DataResult<JobSeeker> getByIdentityNumber(String identityNumber);

	Result isNotNationalIdentityExist(String identityNumber);

	Result register(JobSeekerForRegisterDto jobSeekerForRegisterDto);

	DataResult<JobSeekersFavoriteJobAdvert> getFavoriteByJobSeekerIdAndJobAdvertId(int jobSeekerId, int jobAdvertId);

	Result undoFavoriteJobAdvert(int id);

	Result favoriteJobAdvert(JobSeekersFavoriteJobAdvert jobSeekersFavoriteJobAdvert);
}
