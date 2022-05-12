package com.example.hrmsbackend.business.concretes;

import com.example.hrmsbackend.business.abstracts.CompanyStaffVerificationService;
import com.example.hrmsbackend.core.business.abstracts.BaseManager;
import com.example.hrmsbackend.core.business.constants.Messages;
import com.example.hrmsbackend.core.utilities.results.*;
import com.example.hrmsbackend.dataAccess.abstracts.CompanyStaffVerificationDao;
import com.example.hrmsbackend.entities.concretes.CompanyStaffVerification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyStaffVerificationManager
		extends BaseManager<CompanyStaffVerificationDao, CompanyStaffVerification, Integer>
		implements CompanyStaffVerificationService {
	private final CompanyStaffVerificationDao companyStaffVerificationDao;

	@Autowired
	public CompanyStaffVerificationManager(final CompanyStaffVerificationDao companyStaffVerificationDao) {
		super(companyStaffVerificationDao, "Company staff verification");
		this.companyStaffVerificationDao = companyStaffVerificationDao;
	}

	@Override
	public DataResult<CompanyStaffVerification> getByUserId(final int userId) {
		final Optional<CompanyStaffVerification> companyStaffVerification = companyStaffVerificationDao
				.findByUser_Id(userId);

		if (companyStaffVerification.isEmpty())
			return new ErrorDataResult<>(Messages.notFound("Company staff verification"));

		return new SuccessDataResult<>(companyStaffVerification.get());
	}

	@Override
	public Result verify(final int userId) {
		final DataResult<CompanyStaffVerification> companyStaffVerification = getByUserId(userId);

		if (!companyStaffVerification.isSuccess())
			return new ErrorResult(Messages.notFound("Company staff verification"));

		companyStaffVerification.getData().setApproved(true);
		companyStaffVerificationDao.save(companyStaffVerification.getData());

		return new SuccessResult(Messages.verified("User"));
	}

}
