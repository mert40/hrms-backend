package com.example.hrmsbackend.business.abstracts;

import com.example.hrmsbackend.core.business.abstracts.BaseService;
import com.example.hrmsbackend.core.utilities.results.Result;
import com.example.hrmsbackend.entities.concretes.CompanyStaff;
import com.example.hrmsbackend.entities.dtos.CompanyStaffForUpdateDto;

public interface CompanyStaffService extends BaseService<CompanyStaff, Integer> {
	Result updateByUser(CompanyStaffForUpdateDto companyStaffForUpdateDto);
}
