package com.example.hrmsbackend.business.concretes;

import com.example.hrmsbackend.business.abstracts.CompanyStaffService;
import com.example.hrmsbackend.core.business.abstracts.BaseManager;
import com.example.hrmsbackend.core.business.constants.Messages;
import com.example.hrmsbackend.core.utilities.business.BusinessRules;
import com.example.hrmsbackend.core.utilities.results.ErrorResult;
import com.example.hrmsbackend.core.utilities.results.Result;
import com.example.hrmsbackend.core.utilities.results.SuccessResult;
import com.example.hrmsbackend.dataAccess.abstracts.CompanyStaffDao;
import com.example.hrmsbackend.entities.concretes.CompanyStaff;
import com.example.hrmsbackend.entities.dtos.CompanyStaffForUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyStaffManager extends BaseManager<CompanyStaffDao, CompanyStaff, Integer>
		implements CompanyStaffService {
	private final CompanyStaffDao companyStaffDao;

	@Autowired
	public CompanyStaffManager(final CompanyStaffDao companyStaffDao) {
		super(companyStaffDao, "Company staff");
		this.companyStaffDao = companyStaffDao;
	}

	private Result arePasswordMatch(final String password, final String confirmPassword) {
		return password.equals(confirmPassword) ? new SuccessResult() : new ErrorResult(Messages.passwordsNotMatch);
	}

	@Override
	public Result updateByUser(final CompanyStaffForUpdateDto companyStaffForUpdateDto) {
		final Optional<CompanyStaff> companyStaff = companyStaffDao.findById(companyStaffForUpdateDto.getId());
		if (companyStaff.isEmpty())
			return new ErrorResult(Messages.notFound("Company staff"));

		final Result businessRulesResult = BusinessRules
				.run(arePasswordMatch(companyStaff.get().getPassword(), companyStaffForUpdateDto.getPassword()));
		if (!businessRulesResult.isSuccess())
			return businessRulesResult;

		companyStaff.get().setFirstName(companyStaffForUpdateDto.getFirstName());
		companyStaff.get().setLastName(companyStaffForUpdateDto.getLastName());
		companyStaffDao.save(companyStaff.get());

		return new SuccessResult(Messages.updated("Company Staff"));
	}
}
