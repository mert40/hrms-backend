package com.example.hrmsbackend.business.concretes;

import com.example.hrmsbackend.business.abstracts.EmailActivationService;
import com.example.hrmsbackend.business.constants.Messages;
import com.example.hrmsbackend.core.business.abstracts.BaseManager;
import com.example.hrmsbackend.core.entities.User;
import com.example.hrmsbackend.core.utilities.helpers.email.EmailService;
import com.example.hrmsbackend.core.utilities.results.ErrorResult;
import com.example.hrmsbackend.core.utilities.results.Result;
import com.example.hrmsbackend.core.utilities.results.SuccessResult;
import com.example.hrmsbackend.dataAccess.abstracts.EmailActivationDao;
import com.example.hrmsbackend.entities.concretes.EmailActivation;
import com.example.hrmsbackend.entities.dtos.EmailActivationForVerifyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class EmailActivationManager extends BaseManager<EmailActivationDao, EmailActivation, Integer>
		implements EmailActivationService {
	private final EmailActivationDao emailActivationDao;
	private final EmailService emailService;

	@Autowired
	public EmailActivationManager(final EmailActivationDao emailActivationDao, final EmailService emailService) {
		super(emailActivationDao, "Email activation");
		this.emailActivationDao = emailActivationDao;
		this.emailService = emailService;
	}

	@Override
	public Result createAndSendActivationCodeByMail(final User user, final String... emails) {

		for (final String email : emails) {
			final EmailActivation emailActivation = EmailActivation.builder()
					.user(user)
					.email(email)
					.activationCode("EmailActivationCodeTEST") // TODO create activationCode
					.expirationDate(LocalDateTime.now().plusMonths(1))
					.build();
			super.add(emailActivation);
			emailService.send(email,
					Messages.emailActivationVerifyEmailTitle,
					String.format("%swww.localhost:8080/api/emailactivations/verify?activationCode=%s&email=%s",
							Messages.emailActivationVerifyEmailBody,
							emailActivation.getActivationCode(),
							email));
		}

		return new SuccessResult(Messages.emailActivationCreatedAndSent);
	}

	@Override
	public Result verify(final EmailActivationForVerifyDto emailActivationForVerifyDto) {
		final Optional<EmailActivation> emailActivation = emailActivationDao.findByEmailAndActivationCode(
				emailActivationForVerifyDto.getEmail(),
				emailActivationForVerifyDto.getActivationCode());

		if (emailActivation.isEmpty())
			return new ErrorResult(
					com.example.hrmsbackend.core.business.constants.Messages.notVerified("Email"));

		emailActivation.get().setActivated(true);
		emailActivationDao.save(emailActivation.get());

		return new SuccessResult(com.example.hrmsbackend.core.business.constants.Messages.verified("Email"));
	}

}
