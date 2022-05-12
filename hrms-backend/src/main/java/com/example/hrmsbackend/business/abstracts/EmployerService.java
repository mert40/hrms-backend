package com.example.hrmsbackend.business.abstracts;

import com.example.hrmsbackend.core.business.abstracts.BaseService;
import com.example.hrmsbackend.core.utilities.results.DataResult;
import com.example.hrmsbackend.core.utilities.results.Result;
import com.example.hrmsbackend.entities.concretes.Employer;
import com.example.hrmsbackend.entities.concretes.EmployerUpdate;
import com.example.hrmsbackend.entities.dtos.EmployerForRegisterDto;
import com.example.hrmsbackend.entities.dtos.EmployerForUpdateDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface EmployerService extends BaseService<Employer, Integer> {
	DataResult<EmployerUpdate> getLastUpdateByUserId(int employerId);

	DataResult<List<EmployerUpdate>> getAllByIsApprovedAndIsDeleted(boolean isApproved, boolean isDeleted);

	Result isNotCorporateEmailExist(String corporateEmail);

	Result register(EmployerForRegisterDto employerForRegister);

	Result updateByUser(EmployerForUpdateDto employerForUpdateDto, MultipartFile companyImage);

	Result verifyUpdate(int employerUpdateId);

	Result denyUpdate(final int employerUpdateId);
}
