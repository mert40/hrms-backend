package com.example.hrmsbackend.business.concretes;

import com.example.hrmsbackend.business.abstracts.EmailActivationService;
import com.example.hrmsbackend.business.abstracts.JobSeekerService;
import com.example.hrmsbackend.business.abstracts.MernisActivationService;
import com.example.hrmsbackend.business.abstracts.UserService;
import com.example.hrmsbackend.business.adapters.mernisService.PersonForValidateFromMernisService;
import com.example.hrmsbackend.core.business.abstracts.BaseManager;
import com.example.hrmsbackend.core.business.constants.Messages;
import com.example.hrmsbackend.core.utilities.business.BusinessRules;
import com.example.hrmsbackend.core.utilities.results.*;
import com.example.hrmsbackend.dataAccess.abstracts.JobSeekerDao;
import com.example.hrmsbackend.dataAccess.abstracts.JobSeekersFavoriteJobAdvertDao;
import com.example.hrmsbackend.entities.concretes.JobSeeker;
import com.example.hrmsbackend.entities.concretes.JobSeekersFavoriteJobAdvert;
import com.example.hrmsbackend.entities.concretes.MernisActivation;
import com.example.hrmsbackend.entities.dtos.JobSeekerForRegisterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JobSeekerManager extends BaseManager<JobSeekerDao, JobSeeker, Integer> implements JobSeekerService {
	private final JobSeekerDao jobSeekerDao;
	private final UserService userService;
	private final MernisActivationService mernisActivationService;
	private final EmailActivationService emailActivationService;
	private final JobSeekersFavoriteJobAdvertDao jobSeekersFavoriteJobAdvertDao;

	@Autowired
	public JobSeekerManager(final JobSeekerDao jobSeekerDao, final UserService userService,
			final JobSeekersFavoriteJobAdvertDao jobSeekersFavoriteJobAdvertDao,
			final MernisActivationService mernisActivationService,
			final EmailActivationService emailActivationService) {
		super(jobSeekerDao, "Job seeker");
		this.jobSeekerDao = jobSeekerDao;
		this.userService = userService;
		this.jobSeekersFavoriteJobAdvertDao = jobSeekersFavoriteJobAdvertDao;
		this.mernisActivationService = mernisActivationService;
		this.emailActivationService = emailActivationService;
	}

	private Result arePasswordMatch(final String password, final String confirmPassword) {
		return password.equals(confirmPassword) ? new SuccessResult() : new ErrorResult(Messages.passwordsNotMatch);
	}

	@Override
	public DataResult<JobSeeker> getByIdentityNumber(final String identityNumber) {
		final Optional<JobSeeker> jobSeeker = jobSeekerDao.findByIdentityNumber(identityNumber);

		if (jobSeeker.isEmpty())
			return new ErrorDataResult<>(Messages.notFound("Job seeker"));

		return new SuccessDataResult<>(jobSeeker.get());
	}

	@Override
	public Result isNotNationalIdentityExist(final String identityNumber) {
		return jobSeekerDao.findByIdentityNumber(identityNumber).isEmpty() ? new SuccessResult()
				: new ErrorResult(Messages.alreadyExists("A job seeker with the identity number"));
	}

	@Override
	public Result register(final JobSeekerForRegisterDto jobSeekerForRegisterDto) {
		final Result businessRulesResult = BusinessRules.run(
				userService.isNotEmailExist(jobSeekerForRegisterDto.getEmail()),
				isNotNationalIdentityExist(jobSeekerForRegisterDto.getIdentityNumber()),
				arePasswordMatch(jobSeekerForRegisterDto.getPassword(), jobSeekerForRegisterDto.getConfirmPassword()),
				mernisActivationService.check(PersonForValidateFromMernisService.builder()
						.ad(jobSeekerForRegisterDto.getFirstName())
						.soyad(jobSeekerForRegisterDto.getLastName())
						.TCKimlikNo(Long.parseLong(jobSeekerForRegisterDto.getIdentityNumber()))
						.dogumYili(jobSeekerForRegisterDto.getBirthDate().getYear())
						.build()));
		if (!businessRulesResult.isSuccess())
			return businessRulesResult;

		final JobSeeker jobSeeker = JobSeeker.childBuilder()
				.email(jobSeekerForRegisterDto.getEmail())
				.password(jobSeekerForRegisterDto.getPassword())
				.firstName(jobSeekerForRegisterDto.getFirstName())
				.lastName(jobSeekerForRegisterDto.getLastName())
				.identityNumber(jobSeekerForRegisterDto.getIdentityNumber())
				.birthDate(jobSeekerForRegisterDto.getBirthDate())
				.build();

		super.add(jobSeeker);

		emailActivationService.createAndSendActivationCodeByMail(jobSeeker, jobSeeker.getEmail());
		mernisActivationService.add(MernisActivation.builder().user(jobSeeker).build());

		return new SuccessResult(Messages.added("Job seeker"));
	}

	public DataResult<JobSeekersFavoriteJobAdvert> getFavoriteByJobSeekerIdAndJobAdvertId(final int jobSeekerId,
			final int jobAdvertId) {
		Optional<JobSeekersFavoriteJobAdvert> jobSeekersFavoriteJobAdvert = this.jobSeekersFavoriteJobAdvertDao
				.findByJobSeeker_IdAndJobAdvert_Id(jobSeekerId, jobAdvertId);

		if (jobSeekersFavoriteJobAdvert.isEmpty())
			return new ErrorDataResult(Messages.notFound("Job seeker's favorite jobAdvert"));

		return new SuccessDataResult(jobSeekersFavoriteJobAdvert.get());
	}

	public Result favoriteJobAdvert(final JobSeekersFavoriteJobAdvert jobSeekersFavoriteJobAdvert) {
		boolean isThereSameFavorite = !this.jobSeekersFavoriteJobAdvertDao
				.findByJobSeeker_IdAndJobAdvert_Id(jobSeekersFavoriteJobAdvert.getJobSeeker().getId(),
						jobSeekersFavoriteJobAdvert.getJobAdvert().getId())
				.isEmpty();
		if (isThereSameFavorite)
			return new ErrorResult(Messages.alreadyExists("Favorite job advert"));

		this.jobSeekersFavoriteJobAdvertDao.save(jobSeekersFavoriteJobAdvert);

		return new SuccessResult(Messages.added("Favorite job advert"));
	}

	public Result undoFavoriteJobAdvert(final int id) {
		Optional<JobSeekersFavoriteJobAdvert> jobSeekersFavoriteJobAdvert = jobSeekersFavoriteJobAdvertDao.findById(id);

		if (jobSeekersFavoriteJobAdvert.isEmpty())
			return new ErrorDataResult(Messages.notFound("Favorite job advert"));

		jobSeekersFavoriteJobAdvertDao.delete(jobSeekersFavoriteJobAdvert.get());

		return new SuccessResult(Messages.deleted("Favorite job advert"));
	}
}
