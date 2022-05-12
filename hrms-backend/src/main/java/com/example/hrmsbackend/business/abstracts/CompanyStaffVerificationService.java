package com.example.hrmsbackend.business.abstracts;

import com.example.hrmsbackend.core.business.abstracts.BaseService;
import com.example.hrmsbackend.core.utilities.results.DataResult;
import com.example.hrmsbackend.core.utilities.results.Result;
import com.example.hrmsbackend.entities.concretes.CompanyStaffVerification;

public interface CompanyStaffVerificationService extends BaseService<CompanyStaffVerification, Integer> {
	DataResult<CompanyStaffVerification> getByUserId(final int userId);

	Result verify(int id);
}
